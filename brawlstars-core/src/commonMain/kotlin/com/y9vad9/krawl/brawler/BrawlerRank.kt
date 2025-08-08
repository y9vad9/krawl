package com.y9vad9.krawl.brawler

import com.y9vad9.krawl.brawler.BrawlerRank.Companion.MAX
import com.y9vad9.krawl.brawler.BrawlerRank.Companion.MIN
import com.y9vad9.krawl.brawler.BrawlerRank.Companion.create
import com.y9vad9.krawl.brawler.BrawlerRank.Companion.createOrNull
import com.y9vad9.krawl.brawler.BrawlerRank.Companion.createOrThrow

/**
 * Represents a Brawler's rank in Brawl Stars.
 *
 * Ranks indicate a brawler's competitive progress and range from [MIN] to [MAX].
 * Use [create], [createOrThrow], or [createOrNull] to construct a valid instance.
 *
 * @property raw The underlying integer rank value.
 */
@JvmInline
public value class BrawlerRank private constructor(
    public val raw: Int
) : Comparable<BrawlerRank> {

    /** Constants with constraints and validation */
    public companion object {
        /** Minimum valid Brawler rank (inclusive). */
        public val MIN: BrawlerRank = BrawlerRank(1)

        /** Maximum valid Brawler rank (inclusive). */
        public val MAX: BrawlerRank = BrawlerRank(51)

        /** Range of allowed rank values. */
        public val VALUE_RANGE: IntRange = MIN.raw..MAX.raw

        /**
         * Checks whether the given [input] is within the valid Brawler rank range.
         */
        public fun isValid(input: Int): Boolean =
            input in VALUE_RANGE

        /**
         * Attempts to create a [BrawlerRank] from the given [input].
         *
         * Returns [Result.success] if valid, or [Result.failure] with an [IllegalArgumentException].
         */
        public fun create(input: Int): Result<BrawlerRank> =
            if (isValid(input)) Result.success(BrawlerRank(input))
            else Result.failure(IllegalArgumentException("Invalid brawler rank: $input"))

        /**
         * Creates a [BrawlerRank] from [input] or throws [IllegalArgumentException] if invalid.
         */
        public fun createOrThrow(input: Int): BrawlerRank =
            create(input).getOrThrow()

        /**
         * Creates a [BrawlerRank] from [input] or returns `null` if invalid.
         */
        public fun createOrNull(input: Int): BrawlerRank? =
            create(input).getOrNull()
    }

    /**
     * Returns the string representation of the brawler rank.
     */
    override fun toString(): String = raw.toString()

    /**
     * Compares this [BrawlerRank] with another based on their numeric value.
     */
    override fun compareTo(other: BrawlerRank): Int = raw.compareTo(other.raw)
}
