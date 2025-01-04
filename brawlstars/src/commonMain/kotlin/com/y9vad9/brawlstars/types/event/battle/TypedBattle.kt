package com.y9vad9.brawlstars.types.event.battle

import com.y9vad9.brawlstars.pagination.PagesIterator
import com.y9vad9.brawlstars.types.brawler.value.PowerLevel
import com.y9vad9.brawlstars.types.event.*
import com.y9vad9.brawlstars.types.event.value.*
import com.y9vad9.brawlstars.types.player.value.EntityTag
import com.y9vad9.brawlstars.types.player.value.requirePlayer
import com.y9vad9.brawlstars.types.value.Count

/**
 * Creates a type-safe list of [Battle]s instead of raw usage of [RawBattle].
 * Automatically merges Ranked GameMode battles into one.
 *
 * May return fewer elements due to merging.
 *
 * **The input list should be sorted by battleTime descending. If you're
 * getting this list from the API, you're good to go, but otherwise you should make sure it's sorted to
 * avoid incorrect results.**
 */
public fun List<RawBattle>.typed(): List<Battle> {
    val iterator = iterator()
    val outputList = mutableListOf<Battle>()

    // contains possibly ranked battles or regular-ranked battles
    val tempRankedBattlesList = mutableListOf<RawBattle>()

    while (iterator.hasNext()) {
        val next = iterator.next()

        // if in previous iteration, there was/were candidate(s) for friendly ranked battle
        // of the explicit friendly battle – we should process following battles to
        // link them with each other into a single [RankedBattle]
        if (tempRankedBattlesList.isNotEmpty()) {
            val firstElement = tempRankedBattlesList.first()

            // if the current element matches the previous by event, teams and type – we
            // add it into a temporal buffer and repeat everything
            if (next.event == firstElement.event && next.result.teams == firstElement.result.teams && next.result.type == firstElement.result.type) {
                tempRankedBattlesList += next

                // only continue if starPlayer remain null
                // in the last battle of ranked battles there's always
                // a star player
                if (next.result.starPlayer == null)
                    continue
            }

            // if the current element did not match with previous
            // we apply buffer and clear it up.
            if (tempRankedBattlesList.size > 1) {
                outputList += if (firstElement.isFriendly) {
                    tempRankedBattlesList.toFriendlyRankedGame()
                } else {
                    tempRankedBattlesList.toRegularRankedGame()
                }

                tempRankedBattlesList.clear()
            } else {
                val battle = tempRankedBattlesList.single()

                // if it's a ranked game mode, we treat it anyway as
                // a regular-ranked game even if it's only a one round
                if (battle.isRankedGameMode) {
                    outputList += tempRankedBattlesList.toRegularRankedGame()
                } else {
                    // this can be friendly ranked, but if we get the only one
                    // we treat it as a regular teams battle
                    outputList += battle.toTeamsBattle()
                }

                tempRankedBattlesList.clear()
            }
        }

        // if the battle is friendly and definitely is not a showdown
        // we add it to the ranked battle candidates
        if (next.isFriendly && !next.result.mode.isShowdown) {
            tempRankedBattlesList.add(next)
            continue
        }

        // if battle is explicitly showdown or there's ranking position
        // specified, we treat both as a ShowdownBattle
        if (next.result.mode.isShowdown || next.result.rank != null) {
            outputList += next.toShowdownBattle()
            continue
        }

        // if battle is explicitly ranked game mode, we
        // look for previous battles to combine them into a one game with
        // rounds within type-system.
        if (next.isRankedGameMode) {
            tempRankedBattlesList += next
            continue
        }

        // if the game is any teams game mode and didn't satisfy any
        // previous conditions, we treat it as a regular teams battle
        if (next.isTeamsGameMode) {
            outputList += next.toTeamsBattle()
            continue
        }

        error("Shouldn't reach this state; next was $next")
    }

    return outputList
}

/**
 * Creates type-safe [Battle] based on input iterator. This operation
 * might load additional data, based on the input, for example, to handle
 * [FriendlyRankedBattle]s. Effectively, it works until grouped values like [RankedBattle]
 * does not equal originally requested size from the API or original iterator returns zero elements.
 *
 * Some of the extra loaded items may remain in the pages iterator. It's important to
 *  keep a single instance or to create your cursors based on the last received item from
 * the iterator, not on the actual loaded items.
 *
 * **Implementation Note**: Does not support going back due to dynamic nature subloading
 * the items.
 */
public fun PagesIterator<RawBattle>.typed(): PagesIterator<Battle> {
    return BattlesPagesIterator(this)
}


// -- Internal --

private fun RawBattle.toTeamsBattle(): TeamsBattle {
    require(event.mode?.isShowdown != true)
    require(!result.type.isRankedGameMode)

    return if (isFriendly) {
        FriendlyTeamsBattle(
            battleTime = battleTime,
            event = event,
            duration = result.duration!!,
            starPlayer = result.starPlayer?.let {
                StarPlayer(
                    tag = it.tag,
                    name = it.name,
                    brawler = it.brawler.toBrawlerView()
                        as FriendlyBrawlerView
                )
            },
            result = result.resultKind!!,
            teams = BattleTeams(
                result.teams!!.map { team ->
                    team.map {
                        Battle.PlayerView(
                            tag = it.tag,
                            name = it.name,
                            brawler = it.brawler.toBrawlerView()
                                as FriendlyBrawlerView
                        )
                    }
                }
            )
        )
    } else if (isForTrophies) {
        TrophiesTeamsBattle(
            battleTime = battleTime,
            event = event,
            duration = result.duration!!,
            starPlayer = result.starPlayer?.let {
                StarPlayer(
                    tag = it.tag.requirePlayer(),
                    name = it.name,
                    brawler = it.brawler.toBrawlerView(forTrophies = true)
                        as TrophiesBrawlerView
                )
            },
            result = result.resultKind!!,
            teams = BattleTeams(
                result.teams!!.map { team ->
                    team.map {
                        Battle.PlayerView(
                            tag = it.tag.requirePlayer(),
                            name = it.name,
                            brawler = it.brawler.toBrawlerView(forTrophies = true)
                                as TrophiesBrawlerView
                        )
                    }
                }
            )
        )
    } else {
        error("Shouldn't reach this state; please report.")
    }
}

private fun RawBattle.toShowdownBattle(): ShowdownBattle {
    return when {
        isFriendly && isSoloGameMode -> {
            FriendlySoloShowdownBattle(
                battleTime = battleTime,
                event = event,
                rank = result.rank!!,
                players = result.players!!.map {
                    Battle.PlayerView(
                        tag = it.tag,
                        name = it.name,
                        brawler = it.brawler.toBrawlerView() as FriendlyBrawlerView
                    )
                }
            )
        }

        isFriendly && isTeamsGameMode -> {
            FriendlyTeamShowdownBattle(
                battleTime = battleTime,
                event = event,
                rank = result.rank!!,
                teams = BattleTeams(
                    result.teams!!.map { team ->
                        team.map {
                            Battle.PlayerView(
                                tag = it.tag,
                                name = it.name,
                                brawler = it.brawler.toBrawlerView()
                                    as FriendlyBrawlerView
                            )
                        }
                    }
                )
            )
        }

        !isFriendly && isSoloGameMode -> {
            TrophiesSoloShowdownBattle(
                battleTime = battleTime,
                event = event,
                rank = result.rank!!,
                players = result.players!!.map {
                    Battle.PlayerView(
                        tag = it.tag.requirePlayer(),
                        name = it.name,
                        brawler = it.brawler.toBrawlerView(forTrophies = true) as TrophiesBrawlerView
                    )
                },
                trophyChange = result.trophyChange ?: Trophies.ZERO,
            )
        }

        !isFriendly && isTeamsGameMode -> {
            TrophiesTeamShowdownBattle(
                battleTime = battleTime,
                event = event,
                rank = result.rank!!,
                teams = BattleTeams(
                    result.teams!!.map { team ->
                        team.map {
                            Battle.PlayerView(
                                tag = it.tag.requirePlayer(),
                                name = it.name,
                                brawler = it.brawler.toBrawlerView(forTrophies = true)
                                    as TrophiesBrawlerView
                            )
                        }
                    }
                ),
                trophyChange = result.trophyChange ?: Trophies.ZERO,
            )
        }

        else -> {
            error("Shouldn't reach this state, please report.")
        }
    }
}

private fun List<RawBattle>.toRegularRankedGame(): RegularRankedBattle {
    val first = first()

    require(first.result.type.isRankedGameMode)

    return RegularRankedBattle(
        battleTime = first.battleTime,
        event = first.event,
        starPlayer = first.result.starPlayer?.let {
            StarPlayer(
                tag = first.result.starPlayer.tag.requirePlayer(),
                name = first.result.starPlayer.name,
                brawler = first.result.starPlayer.brawler.toBrawlerView(rankedGameMode = true)
                    as RankedBrawlerView,
            )
        },
        rounds = map {
            RankedBattle.Round(
                it.result.resultKind!!,
                it.result.duration!!
            )
        },
        type = first.result.type,
        result = first.result.resultKind!!,
        teams = BattleTeams(
            first.result.teams!!.map { team ->
                team.map {
                    Battle.PlayerView(
                        tag = it.tag.requirePlayer(),
                        name = it.name,
                        brawler = it.brawler.toBrawlerView(rankedGameMode = true)
                            as RankedBrawlerView
                    )
                }
            }
        )
    )
}

private fun List<RawBattle>.toFriendlyRankedGame(): FriendlyRankedBattle {
    val first = first()

    require(first.result.type == BattleType.FRIENDLY)

    return FriendlyRankedBattle(
        battleTime = first.battleTime,
        event = first.event,
        starPlayer = first.result.starPlayer?.let {
            StarPlayer(
                tag = first.result.starPlayer.tag,
                name = first.result.starPlayer.name,
                brawler = FriendlyBrawlerView(
                    id = first.result.starPlayer.brawler.id,
                    name = first.result.starPlayer.brawler.name
                )
            )
        },
        rounds = map {
            RankedBattle.Round(
                it.result.resultKind!!,
                it.result.duration!!
            )
        },
        type = first.result.type,
        result = first.result.resultKind!!,
        teams = BattleTeams(
            first.result.teams!!.map { team ->
                team.map {
                    Battle.PlayerView(
                        tag = it.tag,
                        name = it.name,
                        brawler = it.brawler.toBrawlerView(rankedGameMode = true)
                            as FriendlyBrawlerView
                    )
                }
            }
        )
    )
}

private class BattlesPagesIterator(
    private val originalIterator: PagesIterator<RawBattle>,
) : PagesIterator<Battle> {
    private val nextBuffer: MutableList<RawBattle> = mutableListOf()

    override val pageSize: Count
        get() = originalIterator.pageSize

    override fun hasNext(): Boolean {
        return originalIterator.hasNext() || nextBuffer.any()
    }

    override fun hasPrevious(): Boolean {
        return false
    }

    override suspend fun next(): Result<List<Battle>> {
        return when {
            originalIterator.hasNext() -> {
                originalIterator.next().map {
                    typed(it)
                }
            }

            nextBuffer.isNotEmpty() -> {
                Result.success(typed(emptyList()))
            }

            else -> {
                throw NoSuchElementException()
            }
        }
    }

    override suspend fun previous(): Result<List<Battle>> {
        error("Unsupported operation")
    }

    private suspend fun typed(list: List<RawBattle>): List<Battle> {
        val battles = run {
            nextBuffer.addAll(list)
            nextBuffer
        }

        // early-exit
        if (battles.isEmpty()) return emptyList()

        val outputList = mutableListOf<Battle>()

        // contains possibly ranked battles or regular-ranked battles
        val tempRankedBattlesList = mutableListOf<RawBattle>()

        var iteration = -1

        // we repeat until the list is ended
        // manual work with indexes is due to the nature of
        // operation – it may sub-load elements on its own;
        // it avoids ConcurrentModificationException
        while (iteration < battles.size || tempRankedBattlesList.isNotEmpty() || outputList.size < pageSize.raw) {
            if (outputList.size >= pageSize.raw) {
                iteration++
                break
            }

            iteration++

            // check whether there are any candidates waiting for sub-loading,
            // due to the end of available buffer, to construct true types
            if (iteration == battles.size) {
                if (tempRankedBattlesList.isEmpty()) break

                // we load the exact same number of elements as if there was
                // just a next() call on original iterator
                // safe to throw: previous elements are retained right on
                // the subsequent call
                val nextBattles: List<RawBattle> = originalIterator.next().getOrElse { emptyList() }

                // if iterator returns empty list, it effectively means
                // that the iterator reached the end.
                if (nextBattles.isEmpty()) {
                    outputList += tempRankedBattlesList.toFriendlyRankedGame()
                    battles.clear()
                    break
                }

                battles.addAll(nextBattles)
                iteration--
                continue
            }

            val next = battles[iteration]

            // if in previous iteration, there was/were candidate(s) for friendly ranked battle
            // of the explicit friendly battle – we should process following battles to
            // link them with each other into a single [RankedBattle]
            if (tempRankedBattlesList.isNotEmpty()) {
                val firstElement = tempRankedBattlesList.first()

                // if the current element matches the previous by event, teams and type – we
                // add it into a temporal buffer and repeat everything
                if (next.event == firstElement.event && next.result.teams == firstElement.result.teams && next.result.type == firstElement.result.type) {
                    tempRankedBattlesList += next

                    // only continue if starPlayer remain null
                    // in the last battle of ranked battles there's always
                    // a star player
                    if (next.result.starPlayer == null)
                        continue
                }

                // if the current element did not match with previous
                // we apply buffer and clear it up.
                if (tempRankedBattlesList.size > 1) {
                    outputList += if (firstElement.isFriendly) {
                        tempRankedBattlesList.toFriendlyRankedGame()
                    } else {
                        tempRankedBattlesList.toRegularRankedGame()
                    }

                    tempRankedBattlesList.clear()
                } else {
                    val battle = tempRankedBattlesList.single()

                    // if it's a ranked game mode, we treat it anyway as
                    // a regular-ranked game even if it's only a one round
                    if (battle.isRankedGameMode) {
                        outputList += tempRankedBattlesList.toRegularRankedGame()
                    } else {
                        // this can be friendly ranked, but if we get the only one
                        // we treat it as a regular teams battle
                        outputList += battle.toTeamsBattle()
                    }

                    tempRankedBattlesList.clear()
                }
            }

            // if the battle is friendly and definitely is not a showdown
            // we add it to the ranked battle candidates
            if (next.isFriendly && !next.result.mode.isShowdown) {
                tempRankedBattlesList.add(next)
                continue
            }

            // if battle is explicitly showdown or there's ranking position
            // specified, we treat both as a ShowdownBattle
            if (next.result.mode.isShowdown || next.result.rank != null) {
                outputList += next.toShowdownBattle()
                continue
            }

            // if battle is explicitly ranked game mode, we
            // look for previous battles to combine them into a one game with
            // rounds within type-system.
            if (next.isRankedGameMode) {
                tempRankedBattlesList += next
                continue
            }

            // if the game is any teams game mode and didn't satisfy any
            // previous conditions, we treat it as a regular teams battle
            if (next.isTeamsGameMode) {
                outputList += next.toTeamsBattle()
                continue
            }

            error("Shouldn't reach this state; \$next was $next")
        }

        // if the cycle is ended, we clear the buffer and add ranked battle
        // candidates to the start of the buffer to be used by another query.
        battles.subList(0, iteration).clear()
        battles.addAll(0, tempRankedBattlesList)

        return outputList
    }
}


internal fun <TEntityTag : EntityTag, TBrawlerView : BrawlerView> RawBattle.PlayerView.toStarPlayer(
    brawlerView: TBrawlerView?,
): StarPlayer<TEntityTag, TBrawlerView>? {
    if (brawlerView == null) return null
    return StarPlayer(
        tag = tag as TEntityTag,
        name = name,
        brawler = brawlerView,
    )
}

internal fun RawBattle.BrawlerBattleView.toBrawlerView(
    rankedGameMode: Boolean = false,
    forTrophies: Boolean = false,
): BrawlerView {
    return when {
        power != PowerLevel.UNDEFINED && rankedGameMode -> RankedBrawlerView(
            id = id,
            name = name,
            power = power,
            rankedStage = trophies.asRankedStageUnsafe(),
        )

        power == PowerLevel.UNDEFINED && rankedGameMode -> FriendlyBrawlerView(
            id = id,
            name = name,
        )

        forTrophies -> TrophiesBrawlerView(
            id = id,
            name = name,
            power = power,
            trophies = trophies,
        )

        else -> FriendlyBrawlerView(
            id = id,
            name = name,
        )
    }
}

private fun <T : Any> List<T>.reversedIfTrue(boolean: Boolean): List<T> {
    return if (boolean)
        asReversed()
    else this
}
