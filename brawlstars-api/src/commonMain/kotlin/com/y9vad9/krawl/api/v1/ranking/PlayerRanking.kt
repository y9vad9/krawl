package com.y9vad9.krawl.api.v1.ranking

import com.y9vad9.krawl.api.v1.player.PlayerIcon
import kotlinx.serialization.Serializable

/**
 * Represents a player's ranking information in leaderboards.
 *
 * @property trophies The number of trophies the player has.
 * @property club The club to which the player belongs.
 * @property icon The player's icon information.
 * @property tag The unique player tag.
 * @property name The display name of the player.
 * @property rank The player's position in the ranking.
 * @property nameColor The color code for the player's name.
 */
@Serializable
public data class PlayerRanking(
    public val trophies: Int,
    public val club: PlayerRankingClub,
    public val icon: PlayerIcon,
    public val tag: String,
    public val name: String,
    public val rank: Int,
    public val nameColor: String
)
