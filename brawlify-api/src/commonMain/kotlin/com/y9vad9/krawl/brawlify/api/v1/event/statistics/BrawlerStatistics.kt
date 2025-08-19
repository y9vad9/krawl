package com.y9vad9.krawl.brawlify.api.v1.event.statistics

import kotlinx.serialization.Serializable

/**
 * Represents statistical performance metrics for a specific brawler.
 *
 * Brawler statistics are usually tied to a particular game mode or map,
 * and are computed based on aggregated battle data. They help in balancing,
 * tier lists, and understanding meta trends.
 *
 * ### Example
 * ```json
 * {
 *   "brawler": 16000044,
 *   "winRate": 69.6941,
 *   "useRate": 3.17662,
 *   "starRate": 1.71726
 * }
 * ```
 *
 * @property brawler Unique identifier of the brawler (Supercell internal ID).
 * @property winRate Average win rate of the brawler, expressed as a percentage (0–100).
 * @property useRate Usage rate of the brawler, expressed as a percentage of total battles.
 * @property starRate Star player rate – how often this brawler is awarded the "Star Player" title.
 */
@Serializable
public data class BrawlerStatistics(
    val brawler: Int,
    val winRate: Double,
    val useRate: Double,
    val starRate: Double? = null,
)