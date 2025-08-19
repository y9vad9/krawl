package com.y9vad9.krawl.brawlify.event.map.statistics

import com.y9vad9.krawl.brawler.Brawlers
import com.y9vad9.krawl.brawlify.common.BrawlifyPathSegment
import com.y9vad9.krawl.brawlify.common.Count

/**
 * Represents performance statistics for a specific team composition on a given Brawlify map.
 *
 * This includes the team's name, the brawlers that form the team, a hash uniquely identifying
 * the composition, and associated battle data such as win rate, usage rate, and match outcome counts.
 *
 * @property name The name or identifier of the team composition.
 * @property brawlers The list of brawlers forming this team composition.
 * @property pathSegment An path segment that is used to lookup related resources on Brawlify.
 * @property recordedData The statistical data associated with this team composition.
 */
public data class BrawlifyMapBrawlerTeamStatistics(
    public val name: BrawlifyTeamName,
    public val brawlers: Brawlers,
    public val pathSegment: BrawlifyPathSegment,
    public val recordedData: RecordedData,
) {
    /**
     * Encapsulates statistical data for a specific team on a map, including rates and battle outcomes.
     *
     * @property winRate The percentage of matches won by this team composition.
     * @property useRate The percentage of matches where this team composition was used.
     * @property wins The number of battles won by this team.
     * @property loses The number of battles lost by this team.
     * @property draws The number of battles that ended in a draw.
     * @property total The total number of battles recorded for this team.
     */
    public data class RecordedData(
        public val winRate: BrawlifyPercentRate,
        public val useRate: BrawlifyPercentRate,
        public val wins: Count,
        public val loses: Count,
        public val draws: Count,
        public val total: Count,
    )
}
