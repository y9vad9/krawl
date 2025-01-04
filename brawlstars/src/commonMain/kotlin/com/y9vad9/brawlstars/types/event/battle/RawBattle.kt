package com.y9vad9.brawlstars.types.event.battle

import com.y9vad9.brawlstars.annotations.ContextualBSApi
import com.y9vad9.brawlstars.exception.InvalidContextException
import com.y9vad9.brawlstars.internal.DurationFromSecondsSerializer
import com.y9vad9.brawlstars.internal.InstantInternalSerializer
import com.y9vad9.brawlstars.types.brawler.value.BrawlerId
import com.y9vad9.brawlstars.types.brawler.value.BrawlerName
import com.y9vad9.brawlstars.types.brawler.value.PowerLevel
import com.y9vad9.brawlstars.types.event.Event
import com.y9vad9.brawlstars.types.event.value.*
import com.y9vad9.brawlstars.types.player.value.*
import com.y9vad9.ktiny.kotlidator.createOrThrow
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlin.time.Duration

@Serializable
public data class RawBattle(
    @Serializable(with = InstantInternalSerializer::class)
    val battleTime: Instant,
    val event: Event,
    @SerialName("battle")
    val result: BattleResult,
) {
    @Serializable
    public data class BattleResult(
        val mode: EventMode,
        // null for showdown
        @Serializable(with = DurationFromSecondsSerializer::class)
        val duration: Duration? = null,
        /**
         * Null if the game wasn't 3-vs-3 (multiple teams).
         */
        @SerialName("result")
        val resultKind: BattleResultKind? = null,
        val type: BattleType,
        /**
         * Not null only for [EventMode.SOLO_SHOWDOWN], [EventMode.DUO_SHOWDOWN] or
         * [EventMode.TRIO_SHOWDOWN].
         */
        val rank: RankingPosition? = null,
        /**
         * Null if it's either friendly, mega pig or 'mapmaker' battles.
         */
        val trophyChange: Trophies? = null,
        /**
         * Star player might be null if it's ranked gamemode and the round is not final one.
         */
        val starPlayer: PlayerView? = null,
        val teams: List<List<PlayerView>>? = null,
        val players: List<PlayerView>? = null,
    )

    /**
     * Represents a view of a player in the game, including their tag, name, and current brawler in battle.
     * The [EntityTag] may represent either a player or a bot, particularly in the context of friendly matches.
     *
     * In friendly matches, it's possible for the tag to belong to a bot instead of a player. This distinction is
     * important when processing data related to players and bots in the game. The [EntityTag] interface allows
     * for easy handling of both scenarios in a type-safe manner.
     *
     * @property tag The [EntityTag] representing either the player's or bot's tag.
     * @property name The name of the player, represented by the [PlayerName] type.
     * @property brawler The current brawler being used by the player or bot in the battle, represented by [BrawlerBattleView].
     */
    @Serializable
    public data class PlayerView(
        @SerialName("tag")
        private val _tag: String,
        val name: PlayerName,
        val brawler: BrawlerBattleView,
    ) {
        @Transient
        public val tag: EntityTag = when {
            _tag.startsWith("Bot") && _tag.length in 3..4 ->
                BotTag.createOrThrow(_tag)
            else -> {
                PlayerTag.createOrThrow(_tag)
            }
        }
    }


    @Serializable
    public data class BrawlerBattleView(
        val id: BrawlerId,
        val name: BrawlerName,
        val power: PowerLevel,
        /**
         * Contains meaningful information only if [BattleResult.type] is for trophies.
         */
        val trophies: Trophies,
    )
}

/**
 * Gets [RankedStage] of a player.
 *
 * @param playerTag player's tag in the battle.
 *
 * **API Note**: This API is marked as a [ContextualBSApi], because it works
 * only if [RawBattle.type] satisfies [BattleType.isRankedGameMode].
 *
 * @see BattleType.isRankedGameMode
 * @return [RankedStage] or exception if battle is not of type 'ranked'.
 */
@Throws(InvalidContextException::class)
@ContextualBSApi
public fun RawBattle.getRankedStage(playerTag: PlayerTag): RankedStage {
    if (!isRankedGameMode) throw InvalidContextException("Battle is not a ranked game.")

    return result.teams?.flatten()?.firstOrNull { it.tag == playerTag }?.brawler?.trophies?.asRankedStageUnsafe()
        ?: throw NoSuchElementException("No player found with tag '$playerTag'.")
}

/**
 * Extension property that checks if the battle is for trophies.
 * This property considers the battle to be for trophies if:
 * - The [BattleType] is of type 'ranked' (as represented by [BattleType.TROPHIES]),
 * - The [BattleResult] includes a non-null [trophyChange] field,
 * - The battle is marked as friendly.
 */
@OptIn(ContextualBSApi::class)
public val RawBattle.isForTrophies: Boolean
    get() = result.type.isForTrophies && !result.type.isFriendly

/**
 * Extension property that checks if the battle is a ranked game mode.
 * A battle is considered to be in a ranked game mode if:
 * - The [BattleType] is of type 'soloRanked', 'duoRanked' or 'trioRanked',
 * - The battle does not include a [RawBattle.BattleResult.trophyChange] field,
 * indicating it's not a trophy-related match.
 */
public val RawBattle.isRankedGameMode: Boolean
    get() = result.type.isRankedGameMode && result.trophyChange == null

/**
 * Extension property that checks if the battle is friendly.
 * A battle is considered friendly if:
 * - The [BattleType] is marked as friendly.
 */
public val RawBattle.isFriendly: Boolean
    get() = result.type.isFriendly

/**
 * Extension property that checks if the battle includes bots.
 * This is determined by whether any of the teams in the battle contain bots.
 *
 * @return `true` if the battle has bots, `false` otherwise.
 */
public val RawBattle.hasBots: Boolean
    get() = result.teams?.flatten()?.any { it.tag.isBot() } == true || result.players?.any { it.tag.isBot() } == true

/**
 * Returns whether it's a team game mode (includes ranked games).
 */
public val RawBattle.isTeamsGameMode: Boolean
    get() = result.teams != null

public val RawBattle.isSoloGameMode: Boolean
    get() = result.players != null