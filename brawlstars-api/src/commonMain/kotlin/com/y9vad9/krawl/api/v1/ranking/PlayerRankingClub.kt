package com.y9vad9.krawl.api.v1.ranking

import kotlinx.serialization.Serializable

/**
 * Represents a club associated with a player in ranking data.
 *
 * @property name The name of the club.
 */
@Serializable
public data class PlayerRankingClub(
    public val name: String,
)
