package com.y9vad9.bsapi.types.event

import com.y9vad9.bsapi.annotations.ContextualApi
import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.brawler.value.BrawlerId
import com.y9vad9.bsapi.types.brawler.value.BrawlerName
import com.y9vad9.bsapi.types.brawler.value.PowerLevel
import com.y9vad9.bsapi.types.event.value.*
import com.y9vad9.bsapi.types.exception.InvalidContextException
import com.y9vad9.bsapi.types.player.value.PlayerName
import com.y9vad9.bsapi.types.player.value.PlayerTag
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
public data class Battle(
    val battleTime: Instant,
    val event: Event,
    val mode: EventMode,
    val duration: Seconds,
    val result: BattleResult,
    val type: BattleType,
    val starPlayer: PlayerView,
    val teams: BattleTeams,
) {
    @Serializable
    public data class PlayerView(
        val tag: PlayerTag,
        val name: PlayerName,
        val brawler: BrawlerBattleView,
    )


    @Serializable
    public data class BrawlerBattleView(
        val id: BrawlerId,
        val name: BrawlerName,
        val power: PowerLevel,
        /**
         * Contains meaningful information only if [Battle.type] is for trophies.
         */
        val trophies: Trophies,
    )
}

/**
 * Gets [RankedStage] of a player.
 *
 * @param playerTag player's tag in the battle.
 *
 * **API Note**: This API is marked as a [ContextualApi], because it works
 * only if [Battle.type] satisfies [BattleType.isRankedGameMode].
 *
 * @see BattleType.isRankedGameMode
 * @return [RankedStage] or exception if battle is not of type 'ranked'.
 */
@Throws(InvalidContextException::class)
@ContextualApi
public fun Battle.getRankedStage(playerTag: PlayerTag): RankedStage {
    if (!type.isRankedGameMode) throw InvalidContextException("Battle is not a ranked game.")

    @OptIn(ValueConstructor.Unsafe::class)
    return teams.findPlayer(playerTag)?.brawler?.trophies?.asRankedStageUnsafe()
        ?: throw NoSuchElementException("No player found with tag '$playerTag'.")
}