package com.y9vad9.krawl.event.battle

import com.y9vad9.krawl.event.Event
import com.y9vad9.krawl.event.battle.participant.BattleParticipants
import com.y9vad9.krawl.event.battle.participant.BattleTeamsParticipants
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract
import kotlin.time.Instant

/**
 * Represents a generic battle in Brawl Stars.
 *
 * All battle types contain a [time] of occurrence and an associated [event].
 */
public sealed interface Battle {
    /** The timestamp at which the battle took place. */
    public val time: Instant

    /** The in-game event associated with this battle. */
    public val event: Event
}

/**
 * Marker interface for battles that occurred in the Friendly Game mode.
 *
 * Friendly battles include those created through friendly rooms and do not affect trophies or progression.
 */
public sealed interface FriendlyBattle : Battle

/**
 * Marker interface for battles that occurs in solo game modes.
 */
public sealed interface SoloBattle : Battle {
    /**
     * The list of participant that can be either bot (if battle is friendly) or
     * a real player.
     */
    public val participants: BattleParticipants
}

/**
 * Marker interface for battles that occurs in team game modes.
 */
public sealed interface TeamsBattle : Battle {
    /**
     * The teams that are participating in given battle.
     */
    public val teams: BattleTeamsParticipants
    /**
     * The star player of the battle.
     */
    public val starPlayer: BattleStarPlayer
}

/**
 * Returns `true` if this [Battle] is a [FriendlyBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun Battle.isFriendlyBattle(): Boolean {
    contract {
        returns(true) implies (this@isFriendlyBattle is FriendlyBattle)
    }
    return this is FriendlyBattle
}

/**
 * Returns `true` if this [Battle] is a [TeamsBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun Battle.isTeamsBattle(): Boolean {
    contract {
        returns(true) implies (this@isTeamsBattle is TeamsBattle)
    }
    return this is TeamsBattle
}

/**
 * Returns `true` if this [Battle] is a [RankedBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun Battle.isRankedBattle(): Boolean {
    contract {
        returns(true) implies (this@isRankedBattle is RankedBattle)
    }
    return this is RankedBattle
}

/**
 * Returns `true` if this [Battle] is a [RankingBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun Battle.isRankingBattle(): Boolean {
    contract {
        returns(true) implies (this@isRankingBattle is RankingBattle)
    }
    return this is RankingBattle
}

/**
 * Returns `true` if this [Battle] is a [TeamRankingBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun Battle.isTeamRankingBattle(): Boolean {
    contract {
        returns(true) implies (this@isTeamRankingBattle is TeamRankingBattle)
    }
    return this is TeamRankingBattle
}
