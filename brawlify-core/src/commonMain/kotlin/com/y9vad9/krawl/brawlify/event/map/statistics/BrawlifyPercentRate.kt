package com.y9vad9.krawl.brawlify.event.map.statistics

import kotlin.jvm.JvmInline

/**
 * Represents a bounded percentage rate (e.g., use rate, win rate) within the range [0.0, 100.0].
 *
 * This is commonly used for statistical rates in Brawlify data such as pick rates or win rates.
 *
 * @property rawDouble The underlying double value representing the percentage (e.g., 42.1).
 */
@JvmInline
public value class BrawlifyPercentRate private constructor(
    public val rawDouble: Double,
) : Comparable<BrawlifyPercentRate> {

    override fun compareTo(other: BrawlifyPercentRate): Int =
        rawDouble.compareTo(other.rawDouble)

    public companion object {
        /**
         * Minimum valid rate value (0.0%).
         */
        public val MIN: BrawlifyPercentRate = BrawlifyPercentRate(0.0)

        /**
         * Maximum valid rate value (100.0%).
         */
        public val MAX: BrawlifyPercentRate = BrawlifyPercentRate(100.0)

        /**
         * Returns whether the given value is a valid rate (i.e., in range [MIN, MAX]).
         */
        public fun isValid(value: Double): Boolean =
            value in MIN.rawDouble..MAX.rawDouble

        /**
         * Attempts to create a [BrawlifyPercentRate] from the given [value], returning [Result.failure]
         * if it is not within [MIN, MAX].
         */
        public fun create(value: Double): Result<BrawlifyPercentRate> =
            if (isValid(value)) Result.success(BrawlifyPercentRate(value))
            else Result.failure(
                IllegalArgumentException("Rate must be between ${MIN.rawDouble} and ${MAX.rawDouble}: $value")
            )

        /**
         * Creates a [BrawlifyPercentRate] from the given [value], or throws an [IllegalArgumentException] if invalid.
         */
        public fun createOrThrow(value: Double): BrawlifyPercentRate =
            create(value).getOrThrow()

        /**
         * Creates a [BrawlifyPercentRate] from the given [value], or returns `null` if invalid.
         */
        public fun createOrNull(value: Double): BrawlifyPercentRate? =
            create(value).getOrNull()
    }

    override fun toString(): String = "BrawlifyPercentRate($rawDouble%)"
}
