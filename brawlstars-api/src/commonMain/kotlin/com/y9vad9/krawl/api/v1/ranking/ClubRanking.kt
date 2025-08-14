package com.y9vad9.krawl.api.v1.ranking

import kotlinx.serialization.Serializable

/**
 * Represents a club's ranking information in leaderboards.
 *
 * @property tag The unique tag identifying the club.
 * @property name The display name of the club.
 * @property trophies The total number of trophies earned by the club.
 * @property badgeId The identifier for the club's badge icon.
 * @property rank The club's position in the ranking.
 */
@Serializable
public data class ClubRanking(
    public val tag: String,
    public val name: String,
    public val trophies: Int,
    public val badgeId: Int,
    public val rank: Int,
)
