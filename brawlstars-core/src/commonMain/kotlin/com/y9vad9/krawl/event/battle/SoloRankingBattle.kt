package com.y9vad9.krawl.event.battle

import com.y9vad9.krawl.event.Event
import com.y9vad9.krawl.event.battle.participant.FriendlyBattleParticipants
import com.y9vad9.krawl.event.battle.participant.TrophyLeagueBattlePlayers
import com.y9vad9.krawl.ranking.RankingPosition
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract
import kotlin.time.Instant

/**
 * Represents a solo-based ranked battle in Brawl Stars.
 *
 * This interface covers battle types where players are ranked individually,
 * such as Solo Showdown or Duels. It provides access to the participants
 * of the battle along with their brawlers.
 */
public sealed interface SoloRankingBattle : RankingBattle, SoloBattle

/**
 * Represents a solo ranked battle in the Friendly game mode.
 *
 * Friendly battles do not affect player rankings or trophies.
 */
public data class FriendlySoloRankingBattle(
    override val time: Instant,
    override val participants: FriendlyBattleParticipants,
    override val rank: RankingPosition,
    override val event: Event,
) : SoloRankingBattle, FriendlyBattle

/**
 * Represents a solo ranked battle in the Trophy League game mode.
 */
public data class TrophyLeagueSoloRankingBattle(
    override val time: Instant,
    override val participants: TrophyLeagueBattlePlayers,
    override val rank: RankingPosition,
    override val event: Event,
) : SoloRankingBattle {
    /**
     * An alias to [participants].
     */
    public inline val players: TrophyLeagueBattlePlayers get() = participants
}

/**
 * Returns `true` if this [SoloRankingBattle] is a friendly battle,
 * allowing smart casting to [FriendlySoloRankingBattle].
 *
 * This function provides Kotlin contract support to enable smart casts after
 * successful checks.
 */
@OptIn(ExperimentalContracts::class)
public fun SoloRankingBattle.isFriendly(): Boolean {
    contract {
        returns(true) implies (this@isFriendly is FriendlySoloRankingBattle)
    }
    return this is FriendlySoloRankingBattle
}

/**
 * Returns `true` if this [SoloRankingBattle] is a trophy league battle,
 * allowing smart casting to [TrophyLeagueSoloRankingBattle].
 *
 * This function provides Kotlin contract support to enable smart casts after
 * successful checks.
 */
@OptIn(ExperimentalContracts::class)
public fun SoloRankingBattle.isTrophyLeague(): Boolean {
    contract {
        returns(true) implies (this@isTrophyLeague is TrophyLeagueSoloRankingBattle)
    }
    return this is TrophyLeagueSoloRankingBattle
}
