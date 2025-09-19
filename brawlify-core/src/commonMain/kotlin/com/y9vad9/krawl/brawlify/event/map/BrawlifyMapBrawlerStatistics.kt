package com.y9vad9.krawl.brawlify.event.map

import com.y9vad9.krawl.brawler.BrawlerId
import com.y9vad9.krawl.brawlify.api.v1.event.statistics.RawBrawlifyMapBrawlerStatistics

/**
 * Represents the performance statistics of a specific Brawler on a particular map.
 *
 * This data class includes both the win rate and use rate of the Brawler,
 * typically derived from analytics or leaderboard data for a given map in Brawl Stars.
 *
 * @property brawlerId Unique identifier of the Brawler the statistics refer to.
 * @property winRate The win rate percentage of the Brawler on this map.
 * @property useRate The usage rate percentage indicating how frequently this Brawler is picked on this map.
 * @property starRate The star player rate percentage indicating how frequently player with that Brawler is chosen as
 *                    "star player" on this map.
 */
public data class BrawlifyMapBrawlerStatistics(
    /**
     * Unique identifier of the Brawler the statistics refer to.
     */
    public val brawlerId: BrawlerId,

    /**
     * The win rate percentage of the Brawler on this map.
     *
     * This value represents how often this Brawler wins matches when played on the given map.
     * It is typically expressed as a percentage (0.0 to 100.0).
     */
    public val winRate: BrawlifyPercentRate,

    /**
     * The usage rate percentage of the Brawler on this map.
     *
     * This value indicates how frequently this Brawler is chosen by players for matches on this map.
     * Also expressed as a percentage (0.0 to 100.0).
     */
    public val useRate: BrawlifyPercentRate,

    /**
     * The star player rate percentage of the Brawler on this map.
     *
     * This value indicates how frequently this Brawler is chosen as star player in matches on this map.
     * Also expressed as a percentage (0.0 to 100.0).
     */
    public val starRate: BrawlifyPercentRate? = null,
)

/**
 * Converts this [RawBrawlifyMapBrawlerStatistics] into its typed and validated
 * counterpart [BrawlifyMapBrawlerStatistics].
 *
 * @return the corresponding [BrawlifyMapBrawlerStatistics] instance
 * @throws IllegalArgumentException if any validation fails
 */
public fun RawBrawlifyMapBrawlerStatistics.toTypedOrThrow(): BrawlifyMapBrawlerStatistics =
    BrawlifyMapBrawlerStatistics(
        brawlerId = BrawlerId.createOrThrow(brawler),
        winRate = BrawlifyPercentRate.createOrThrow(winRate),
        useRate = BrawlifyPercentRate.createOrThrow(useRate),
        starRate = starRate?.let { BrawlifyPercentRate.createOrThrow(it) },
    )

/**
 * Attempts to convert this [RawBrawlifyMapBrawlerStatistics] into its typed counterpart [BrawlifyMapBrawlerStatistics].
 *
 * @return the validated [BrawlifyMapBrawlerStatistics], or `null` if conversion fails
 */
public fun RawBrawlifyMapBrawlerStatistics.toTypedOrNull(): BrawlifyMapBrawlerStatistics? =
    try { toTypedOrThrow() } catch (_: Throwable) { null }
