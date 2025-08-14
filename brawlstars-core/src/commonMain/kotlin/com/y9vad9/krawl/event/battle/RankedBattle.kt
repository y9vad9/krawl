package com.y9vad9.krawl.event.battle

import com.y9vad9.krawl.event.Event
import com.y9vad9.krawl.event.battle.participant.FriendlyBattleTeamsParticipants
import com.y9vad9.krawl.event.battle.participant.RankedBattleTeamsPlayers
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlin.time.Instant

/**
 * Represents a ranked battle in Brawl Stars.
 *
 * Learn more on [Brawl Stars Fandom](https://brawlstars.fandom.com/wiki/Ranked).
 */
public sealed interface RankedBattle : TeamsBattle {
    /**
     * The list of battle rounds (inferred or actual).
     */
    public val rounds: List<Round>

    /**
     * The result of the battle.
     *
     * Might be null if the game is unfinished (can be either in progress or just left through the exit button
     * in case of friendly battles).
     */
    public val result: BattleResult?

    /**
     * The matchmaking type (solo/duo/trio).
     */
    public val matchmakingType: RankedMatchmakingType

    /**
     * Represents a single round within a battle.
     *
     * A round contains the outcome (win/draw/loss) and its duration.
     *
     * @property result The outcome of the round for the team, represented by [BattleResult].
     * @property duration The time the round lasted, as a [Duration].
     */
    public data class Round(
        public val result: BattleResult,
        public val duration: Duration,
    )
}

/**
 * Returns true if this ranked battle has a recorded result.
 */
public val RankedBattle.isFinished: Boolean get() = result != null

/**
 * Computes the total duration of the ranked battle by summing round durations.
 */
public val RankedBattle.totalDuration: Duration
    get() = rounds.fold(0.seconds) { acc, round ->
        acc + round.duration
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
    override val time: Instant,
    override val event: Event,
    override val rounds: List<RankedBattle.Round>,
    override val teams: FriendlyBattleTeamsParticipants,
    override val starPlayer: FriendlyBattleStarPlayer,
    override val result: BattleResult?,
    override val matchmakingType: RankedMatchmakingType,
) : RankedBattle, FriendlyBattle

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
public data class LeagueRankedBattle(
    override val time: Instant,
    override val event: Event,
    override val rounds: List<RankedBattle.Round>,
    override val teams: RankedBattleTeamsPlayers,
    override val starPlayer: RankedBattleStarPlayer,
    override val result: BattleResult?,
    override val matchmakingType: RankedMatchmakingType,
) : RankedBattle

/**
 * Returns true if this [RankedBattle] is a [FriendlyRankedBattle].
 * Supports smart-casting.
 */
@OptIn(ExperimentalContracts::class)
public fun RankedBattle.isFriendly(): Boolean {
    contract {
        returns(true) implies (this@isFriendly is FriendlyRankedBattle)
    }
    return this is FriendlyRankedBattle
}

/**
 * Returns true if this [RankedBattle] is a [LeagueRankedBattle].
 * Supports smart-casting.
 */
@OptIn(ExperimentalContracts::class)
public fun RankedBattle.isLeague(): Boolean {
    contract {
        returns(true) implies (this@isLeague is LeagueRankedBattle)
    }
    return this is LeagueRankedBattle
}

/**
 * Returns `true` if this battle was queued in solo.
 *
 * @see RankedMatchmakingType.isSolo
 */
public val RankedBattle.isSoloMatchmaking: Boolean
    get() = matchmakingType.isSolo

/**
 * Returns `true` if this battle was queued in lobby of two people.
 *
 * @see RankedMatchmakingType.isDuo
 */
public val RankedBattle.isDuoMatchmaking: Boolean
    get() = matchmakingType.isDuo

/**
 * Returns `true` if this battle was queued in lobby of three people.
 *
 * @see RankedMatchmakingType.isTrio
 */
public val RankedBattle.isTrioMatchmaking: Boolean
    get() = matchmakingType.isTrio
