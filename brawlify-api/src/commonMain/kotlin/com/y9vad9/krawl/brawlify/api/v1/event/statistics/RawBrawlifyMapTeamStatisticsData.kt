package com.y9vad9.krawl.brawlify.api.v1.event.statistics

import kotlinx.serialization.Serializable

/**
 * Encapsulates aggregated statistics for a given team composition.
 *
 * @property winRate Average win rate of the team composition (0–100).
 * @property useRate Usage rate of the composition as a percentage of all matches.
 * @property wins Number of wins achieved by this composition.
 * @property losses Number of losses suffered by this composition.
 * @property draws Number of draws recorded for this composition.
 * @property total Total number of matches recorded for this composition.
 */
@Serializable
public data class RawBrawlifyMapTeamStatisticsData(
    val winRate: Double,
    val useRate: Double,
    val wins: Int,
    val losses: Int,
    val draws: Int,
    val total: Int,
)
