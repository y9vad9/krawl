package com.y9vad9.bsapi.types.event

import com.y9vad9.bsapi.annotations.ContextualApi
import com.y9vad9.bsapi.internal.DurationFromSecondsSerializer
import com.y9vad9.bsapi.internal.InstantInternalSerializer
import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.brawler.value.BrawlerId
import com.y9vad9.bsapi.types.brawler.value.BrawlerName
import com.y9vad9.bsapi.types.brawler.value.PowerLevel
import com.y9vad9.bsapi.types.event.value.*
import com.y9vad9.bsapi.types.exception.InvalidContextException
import com.y9vad9.bsapi.types.player.value.PlayerName
import com.y9vad9.bsapi.types.player.value.PlayerTag
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration

@Serializable
public data class Battle(
    @Serializable(with = InstantInternalSerializer::class)
    val battleTime: Instant,
    val event: Event,
    @SerialName("battle")
    val result: BattleResult,
) {
    @Serializable
    public data class BattleResult(
        val mode: EventMode,
        @Serializable(with = DurationFromSecondsSerializer::class)
        val duration: Duration,
        @SerialName("result")
        val result: BattleResultKind,
        val type: BattleType,
        /**
         * Star player might be null if it's ranked gamemode and the round is not final one.
         */
        val starPlayer: PlayerView?,
        val teams: BattleTeams,
    )

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
 * **API Note**: This API is marked as a [ContextualApi], because it works
 * only if [Battle.type] satisfies [BattleType.isRankedGameMode].
 *
 * @see BattleType.isRankedGameMode
 * @return [RankedStage] or exception if battle is not of type 'ranked'.
 */
@Throws(InvalidContextException::class)
@ContextualApi
public fun Battle.getRankedStage(playerTag: PlayerTag): RankedStage {
    if (!result.type.isRankedGameMode) throw InvalidContextException("Battle is not a ranked game.")

    @OptIn(ValueConstructor.Unsafe::class)
    return result.teams.findPlayer(playerTag)?.brawler?.trophies?.asRankedStageUnsafe()
        ?: throw NoSuchElementException("No player found with tag '$playerTag'.")
}