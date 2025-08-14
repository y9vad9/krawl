package com.y9vad9.krawl.event.battle

import com.y9vad9.krawl.event.Event
import com.y9vad9.krawl.event.battle.participant.duel.BattleDuelParticipants
import com.y9vad9.krawl.event.battle.participant.duel.TrophyLeagueBattleDuelPlayers
import kotlin.time.Instant
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * Marker interface for all **duel**-style battles in Brawl Stars.
 *
 * A duel battle is a 1v1 format where each player brings multiple brawlers to compete
 * in a series of rounds. The battle is represented by its [players], where
 * each participant’s brawler lineup and performance is recorded.
 *
 * This sealed interface is implemented by specific duel battle types such as:
 * - [FriendlyDuelBattle] — unranked duels in friendly rooms or friendly challenges.
 * - [TrophyLeagueDuelBattle] — ranked duels played during the trophy league season.
 *
 * > **Note**: The Brawl Stars API may sometimes return only one brawler per player,
 * > instead of multiple. Adjust your application logic accordingly.
 *
 * Common properties:
 * - [players] — participants in the duel, including their brawler rosters.
 * - [result] — the outcome of the battle from the querying player’s perspective.
 */
public sealed interface DuelBattle : Battle {
    /**
     * The participants in this duel battle.
     * Different implementations may use different participant models
     * depending on whether the duel was friendly or part of trophy league.
     */
    public val players: BattleDuelParticipants

    /**
     * The result of the battle as seen by the querying player.
     */
    public val result: BattleResult
}

/**
 * A **friendly** duel battle — an unranked 1v1 match typically played in a friendly room.
 *
 * These battles are for fun or practice and do not affect trophies.
 * They still capture full duel details such as:
 * - Player identities
 * - Brawler lineups and results
 * - Event metadata ([event])
 * - Battle timestamp ([time])
 *
 * > **Note**: The Brawl Stars API may sometimes return only one brawler per player,
 * > instead of multiple. Adjust your application logic accordingly.
 *
 * @property players The two participants and their brawler rosters.
 * @property time The timestamp when this battle occurred.
 * @property event The event (map and mode) in which this duel took place.
 * @property result The battle result for the querying player.
 */
public data class FriendlyDuelBattle(
    override val players: BattleDuelParticipants,
    override val time: Instant,
    override val event: Event,
    override val result: BattleResult,
) : DuelBattle, FriendlyBattle

/**
 * A **trophy league** duel battle — a ranked 1v1 match played during a trophy league season.
 *
 * These battles affect trophy counts and are part of the competitive ranked progression.
 * Trophy league duels typically involve matchmaking and higher stakes compared to friendly duels.
 *
 * > **Note**: The Brawl Stars API may sometimes return only one brawler per player,
 * > instead of multiple. Adjust your application logic accordingly.
 *
 * @property players The two ranked participants with trophy league–specific stats.
 * @property time The timestamp when this battle occurred.
 * @property event The event (map and mode) in which this duel took place.
 * @property result The battle result for the querying player.
 */
public data class TrophyLeagueDuelBattle(
    override val players: TrophyLeagueBattleDuelPlayers,
    override val time: Instant,
    override val event: Event,
    override val result: BattleResult,
) : DuelBattle

/**
 * Returns `true` if this duel battle is a [FriendlyDuelBattle].
 *
 * This check is contract-aware, so inside an `if (isFriendly())` block
 * the compiler smart-casts `this` to [FriendlyDuelBattle].
 *
 * @receiver The duel battle instance to check.
 * @return `true` if the duel battle is friendly, otherwise `false`.
 */
@OptIn(ExperimentalContracts::class)
public fun DuelBattle.isFriendly(): Boolean {
    contract {
        returns(true) implies (this@isFriendly is FriendlyDuelBattle)
    }
    return this is FriendlyDuelBattle
}

/**
 * Returns `true` if this duel battle is a [TrophyLeagueDuelBattle].
 *
 * This check is contract-aware, so inside an `if (isTrophyLeague())` block
 * the compiler smart-casts `this` to [TrophyLeagueDuelBattle].
 *
 * @receiver The duel battle instance to check.
 * @return `true` if the duel battle is a trophy league duel, otherwise `false`.
 */
@OptIn(ExperimentalContracts::class)
public fun DuelBattle.isTrophyLeague(): Boolean {
    contract {
        returns(true) implies (this@isTrophyLeague is TrophyLeagueDuelBattle)
    }
    return this is TrophyLeagueDuelBattle
}

/**
 * Casts this duel battle to a [FriendlyDuelBattle], throwing an [IllegalArgumentException]
 * if it is not actually a friendly duel.
 *
 * This cast is contract-aware, so if the call succeeds, the compiler will
 * treat `this` as a [FriendlyDuelBattle] without further checks.
 *
 * @receiver The duel battle to cast.
 * @throws IllegalArgumentException if the duel battle is not friendly.
 * @return This duel battle as a [FriendlyDuelBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun DuelBattle.asFriendly(): FriendlyDuelBattle {
    contract {
        returns() implies (this@asFriendly is FriendlyDuelBattle)
    }
    require(this is FriendlyDuelBattle) {
        "Expected FriendlyDuelBattle but found ${this::class.simpleName}"
    }
    return this
}

/**
 * Casts this duel battle to a [TrophyLeagueDuelBattle], throwing an [IllegalArgumentException]
 * if it is not actually a trophy league duel.
 *
 * This cast is contract-aware, so if the call succeeds, the compiler will
 * treat `this` as a [TrophyLeagueDuelBattle] without further checks.
 *
 * @receiver The duel battle to cast.
 * @throws IllegalArgumentException if the duel battle is not a trophy league duel.
 * @return This duel battle as a [TrophyLeagueDuelBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun DuelBattle.asTrophyLeague(): TrophyLeagueDuelBattle {
    contract {
        returns() implies (this@asTrophyLeague is TrophyLeagueDuelBattle)
    }
    require(this is TrophyLeagueDuelBattle) {
        "Expected TrophyLeagueDuelBattle but found ${this::class.simpleName}"
    }
    return this
}
