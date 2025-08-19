package com.y9vad9.krawl.brawlify.api.v1.event.statistics

import kotlinx.serialization.Serializable

/**
 * Represents statistical performance for a specific team composition
 * of 3 to 5 brawlers. These stats are typically aggregated from many matches
 * and help analyze the effectiveness of particular team setups in different
 * modes or maps.
 *
 * ### Example
 * ```json
 * {
 *   "name": "Leon, 8-Bit & Mr. P",
 *   "hash": "Leon+8-Bit+Mr.P",
 *   "brawler1": 16000023,
 *   "brawler2": 16000027,
 *   "brawler3": 16000031,
 *   "brawler4": null,
 *   "brawler5": null,
 *   "data": {
 *     "winRate": 82.10291,
 *     "useRate": 0.68099,
 *     "wins": 367,
 *     "losses": 80,
 *     "draws": 0,
 *     "total": 447
 *   }
 * }
 * ```
 *
 * @property name Human-readable team composition name (comma-separated list of brawler names).
 * @property hash Unique hash identifier for the composition.
 * @property brawler1 ID of the first brawler in the composition.
 * @property brawler2 ID of the second brawler in the composition.
 * @property brawler3 ID of the third brawler in the composition.
 * @property brawler4 ID of the optional fourth brawler (for modes that allow 4 players).
 * @property brawler5 ID of the optional fifth brawler (for modes that allow 5 players).
 * @property data Statistical data associated with this composition.
 */
@Serializable
public data class TeamStatistics(
    val name: String,
    val hash: String,
    val brawler1: Int,
    val brawler2: Int,
    val brawler3: Int,
    val brawler4: Int? = null,
    val brawler5: Int? = null,
    val data: TeamStatisticsData,
) {
    /**
     * List of wrapped brawlers that participate in the statistics.
     */
    public val brawlers: List<Int> =
        listOfNotNull(brawler1, brawler2, brawler3, brawler4, brawler5)
}
