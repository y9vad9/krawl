package com.y9vad9.bsapi.types.event.battle

import com.y9vad9.bsapi.types.event.BrawlerView
import com.y9vad9.bsapi.types.event.Event
import com.y9vad9.bsapi.types.event.FriendlyBrawlerView
import com.y9vad9.bsapi.types.event.TrophiesBrawlerView
import com.y9vad9.bsapi.types.event.value.BattleTeams
import com.y9vad9.bsapi.types.event.value.RankingPosition
import com.y9vad9.bsapi.types.event.value.Trophies
import com.y9vad9.bsapi.types.player.value.EntityTag
import com.y9vad9.bsapi.types.player.value.PlayerTag
import kotlinx.datetime.Instant
import kotlin.time.Duration

/**
 * Represents a base interface for showdown battles.
 * A showdown battle involves either individual players or teams competing until one remains.
 *
 * **Other showdown-like battle modes might be considered as Showdown matches (that have [rank]) and not treated
 * differently.**
 */
public sealed interface ShowdownBattle : Battle {
    /**
     * The time when the battle occurred.
     */
    override val battleTime: Instant

    /**
     * The event information for the battle, including mode and map details.
     */
    override val event: Event

    /**
     * The player's or team's rank achieved in the battle.
     */
    public val rank: RankingPosition
}

/**
 * Represents a showdown battle where each player competes individually (Solo Showdown).
 *
 * **Other showdown-like battle modes might be considered as Showdown matches (that have [rank]) and not treated
 * differently.**
 */
public sealed interface SoloShowdownBattle : ShowdownBattle {
    /**
     * The list of all players who participated in the battle.
     */
    public val players: List<Battle.PlayerView<out EntityTag, out BrawlerView>>
}

/**
 * Represents a team-based showdown battle (Duo or Trio Showdown).
 *
 * **Other showdown-like battle modes might be considered as Showdown matches (that have [rank]) and not treated
 * differently.**
 */
public sealed interface TeamShowdownBattle : ShowdownBattle {
    /**
     * The teams participating in the battle, including their players and brawler details.
     */
    public val teams: BattleTeams<out EntityTag, out BrawlerView>
}


public val TeamShowdownBattle.isDuo: Boolean get() = !isTrio
public val TeamShowdownBattle.isTrio: Boolean get() = teams.firstTeam.size == 3


/**
 * Represents a friendly solo showdown battle.
 * Friendly battles do not affect trophies or rankings.
 *
 * **Other showdown-like battle modes might be considered as Showdown matches (that have [rank]) and not treated
 * differently.**
 */
public data class FriendlySoloShowdownBattle(
    override val battleTime: Instant,
    override val event: Event,
    override val rank: RankingPosition,
    override val players: List<Battle.PlayerView<EntityTag, FriendlyBrawlerView>>
) : SoloShowdownBattle, FriendlyBattle

/**
 * Represents a solo showdown battle where trophies are gained or lost.
 *
 * **Other showdown-like battle modes might be considered as Showdown matches (that have [rank]) and not treated
 * differently.**
 */
public data class TrophiesSoloShowdownBattle(
    override val battleTime: Instant,
    override val event: Event,
    override val rank: RankingPosition,
    /**
     * The change in trophies resulting from the battle.
     */
    public val trophyChange: Trophies,
    override val players: List<Battle.PlayerView<PlayerTag, TrophiesBrawlerView>>
) : SoloShowdownBattle

/**
 * Represents a friendly team showdown battle.
 * Friendly battles do not affect trophies or rankings.
 *
 * **Other showdown-like battle modes might be considered as Showdown matches (that have [rank]) and not treated
 * differently.**
 */
public data class FriendlyTeamShowdownBattle(
    override val battleTime: Instant,
    override val event: Event,
    override val rank: RankingPosition,
    override val teams: BattleTeams<EntityTag, FriendlyBrawlerView>,
) : TeamShowdownBattle, FriendlyBattle

/**
 * Represents a team showdown battle where trophies are gained or lost.
 *
 * **Other showdown-like battle modes might be considered as Showdown matches (that have [rank]) and not treated
 * differently.**
 */
public data class TrophiesTeamShowdownBattle(
    override val battleTime: Instant,
    override val event: Event,
    override val rank: RankingPosition,
    /**
     * The change in trophies resulting from the battle.
     */
    public val trophyChange: Trophies,
    override val teams: BattleTeams<PlayerTag, TrophiesBrawlerView>
) : TeamShowdownBattle