package com.y9vad9.krawl.event.battle

import com.y9vad9.krawl.event.Event
import com.y9vad9.krawl.event.battle.participant.FriendlyBattleTeamsParticipants
import com.y9vad9.krawl.event.battle.participant.TrophyLeagueBattleTeamsPlayers
import com.y9vad9.krawl.ranking.RankingPosition
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract
import kotlin.time.Instant

/**
 * Represents a [RankingBattle] that involves multiple teams.
 *
 * This sealed interface defines a shared contract for all ranking-based battles
 * that are structured around team participation.
 */
public sealed interface TeamRankingBattle : RankingBattle, TeamsBattle

/**
 * A team-based [TeamRankingBattle] that took place in a friendly match context.
 *
 * This battle does not affect trophy progression and is often used for practice or casual play.
 *
 * @property time The timestamp of when the battle occurred.
 * @property rank The player's position in the battle ranking.
 * @property event The [Event] during which the battle took place.
 * @property teams The teams that participated in the battle.
 * @property starPlayer The most valuable player of the battle.
 */
public data class FriendlyTeamRankingBattle(
    override val time: Instant,
    override val rank: RankingPosition,
    override val event: Event,
    override val teams: FriendlyBattleTeamsParticipants,
    override val starPlayer: FriendlyBattleStarPlayer,
) : TeamRankingBattle, FriendlyBattle

/**
 * A team-based [RankingBattle] that occurred as part of the trophy league.
 *
 * This battle contributes to the player's trophy progress and is part of the core competitive gameplay.
 *
 * @property time The timestamp of when the battle occurred.
 * @property rank The player's position in the battle ranking.
 * @property event The [Event] during which the battle took place.
 * @property teams The teams that participated in the battl
 * @property starPlayer The most valuable player of the battle.e.
 */
public data class TrophyLeagueTeamRankingBattle(
    override val time: Instant,
    override val rank: RankingPosition,
    override val event: Event,
    override val teams: TrophyLeagueBattleTeamsPlayers,
    override val starPlayer: TrophyLeagueBattleStarPlayer,
) : TeamRankingBattle

/**
 * Returns `true` if this [TeamRankingBattle] is a [FriendlyBattle], allowing smart casting.
 */
@OptIn(ExperimentalContracts::class)
public fun TeamRankingBattle.isFriendly(): Boolean {
    contract {
        returns(true) implies (this@isFriendly is FriendlyTeamRankingBattle)
    }
    return this is FriendlyTeamRankingBattle
}

/**
 * Returns `true` if this [TeamRankingBattle] is a [TrophyLeagueTeamRankingBattle], allowing smart casting.
 */
@OptIn(ExperimentalContracts::class)
public fun TeamRankingBattle.isTrophyLeague(): Boolean {
    contract {
        returns(true) implies (this@isTrophyLeague is TrophyLeagueTeamRankingBattle)
    }
    return this is TrophyLeagueTeamRankingBattle
}
