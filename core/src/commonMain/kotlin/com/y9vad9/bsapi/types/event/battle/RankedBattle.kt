package com.y9vad9.bsapi.types.event.battle

import com.y9vad9.bsapi.types.event.*
import com.y9vad9.bsapi.types.event.value.BattleResultKind
import com.y9vad9.bsapi.types.event.value.BattleTeams
import com.y9vad9.bsapi.types.event.value.BattleType
import com.y9vad9.bsapi.types.player.value.EntityTag
import com.y9vad9.bsapi.types.player.value.PlayerTag
import kotlinx.datetime.Instant
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/**
 * Represents a ranked game battle, including its metadata, teams, and rounds.
 */
public sealed interface RankedBattle : Battle {
    /**
     * The time when the battle occurred.
     */
    override val battleTime: Instant

    /**
     * The event information for the battle, including mode and map details.
     */
    override val event: Event

    /**
     * The star player of the match, providing details about the player and their brawler.
     */
    public val starPlayer: StarPlayer<out EntityTag, out RankedOrFriendlyBrawlerView>?

    /**
     * The list of rounds played during the battle, each with its result and duration.
     */
    public val rounds: List<Round>

    /**
     * The teams participating in the battle, including their players and brawler details.
     */
    public val teams: BattleTeams<out EntityTag, out BrawlerView>

    /**
     * The type of the battle (e.g., solo, duo).
     */
    public val type: BattleType

    /**
     * Tells whether the ranked game was overall won by player. Might be
     * null if the game is not finished.
     */
    public val result: BattleResultKind?

    /**
     * Indicates whether the battle is assumed based on incomplete data or explicitly recorded.
     */
    public val isAssumed: Boolean

    public val duration: Duration

    /**
     * Represents an individual round within a ranked game battle.
     *
     * @property result The result of the round (e.g., victory, defeat).
     * @property duration The duration of the round.
     */
    public data class Round(
        val result: BattleResultKind,
        val duration: Duration,
    )
}

/**
 * Represents a regular ranked game battle with explicitly recorded data.
 *
 * ## How it's inferred?
 * Apart from the straight-forward way that might tell us that particular
 * battle is ranked – some of them might be just 'rounds' for them,
 * meaning that they are not that important for the full picture.
 *
 * In the same way as [FriendlyRankedBattle] infers, we just
 * look for a previous battles from the last one with specified 'starPlayer'
 * in API (in ranked rounds there's no defined starPlayer) and then down the list
 * while there's the same mode, event, teams, map and no 'starPlayer' event.
 */
public data class RegularRankedBattle(
    override val battleTime: Instant,
    override val event: Event,
    override val starPlayer: StarPlayer<PlayerTag, RankedBrawlerView>?,
    override val rounds: List<RankedBattle.Round>,
    override val teams: BattleTeams<PlayerTag, RankedBrawlerView>,
    override val type: BattleType,
    override val result: BattleResultKind?,
) : RankedBattle {
    /**
     * Indicates that this battle is not assumed.
     */
    override val isAssumed: Boolean get() = false

    /**
     * Total duration of battle with rounds.
     */
    override val duration: Duration
        get() = rounds.fold(0.seconds) { acc, round ->
            acc + round.duration
        }
}

/**
 * Represents a friendly ranked game battle, which may be assumed based on incomplete data.
 *
 * Any friendly ranked game battle is **ASSUMED**, meaning that there's no
 * actual indicator on the Brawl Stars API side – it is inferred by other battles.
 *
 * It's for the most part reliable data, excluding very exclusive cases (when you're directly
 * trying to break the algorithm, but even in this situation, most known cases
 * are covered).
 *
 * ## How it's inferred?
 * Friendly ranked game battles are inferred by the following rules:
 * - `battle.mode` is playable ranked game (showdown, for example, is excluded)
 * - Every ranked game has last game with `battle.result == victory || defeat`
 *
 * ### How rounds are inferred?
 * Although Brawl Stars itself cannot display friendly ranked matches as one even within the game,
 * we can infer it by following rules:
 * - First game, as was mentioned before, should be victory or defeat (no draw can be, it will be finished at least by
 * bots, or it will be a specially made long-ride match).
 * - 'Battles' below should be without `starPlayer` defined (null) – it's the rule, because as was mentioned
 * there cannot be any draws or games without actions.
 * - 'Battles' events, teams, mode should be equal and its time should within a reasonable timeframe.
 *
 * ## Known limitations
 * - If it's the last battle can be obtained log, it will be marked as regular [TeamsBattle].
 * - If there's no final round, all rounds until then will be marked as [TeamsBattle].
 * - I assume that after some period of time ranked battle can be finished by force by Brawl Stars itself,
 * so better to check [rounds] count and overall [totalDuration] with some reasonable time. At our side
 * we set a 25-minute limit for friendly matches, but you may validate it yourself.
 */
public data class FriendlyRankedBattle(
    override val battleTime: Instant,
    override val event: Event,
    override val starPlayer: StarPlayer<EntityTag, FriendlyBrawlerView>?,
    override val rounds: List<RankedBattle.Round>,
    override val teams: BattleTeams<EntityTag, FriendlyBrawlerView>,
    override val type: BattleType,
    override val result: BattleResultKind?,
) : RankedBattle, FriendlyBattle {
    /**
     * Indicates that this battle is assumed based on incomplete or inferred data.
     */
    override val isAssumed: Boolean get() = true

    /**
     * Total duration of battle with rounds.
     */
    override val duration: Duration
        get() = rounds.fold(0.seconds) { acc, round ->
            acc + round.duration
        }
}

/**
 * Tells whether the battle is finished based on the result field status.
 * Works only for [RegularRankedBattle]. Why it does not work for
 * [FriendlyRankedBattle] you can learn in its documentation.
 */
public val RankedBattle.isFinished: Boolean get() = result != null