package com.y9vad9.krawl.ranking

import kotlin.jvm.JvmInline

/**
 * Represents a 1-based position in a Brawl Stars ranking.
 *
 * This value class ensures that the internal integer is strictly positive (starting from 1).
 *
 * @property rawInt The underlying ranking position as a positive integer.
 */
@JvmInline
public value class RankingPosition private constructor(public val rawInt: Int) : Comparable<RankingPosition> {
    override fun compareTo(other: RankingPosition): Int = rawInt.compareTo(other.rawInt)

    public companion object {
        /** The minimal valid position in rankings. */
        public val FIRST: RankingPosition = RankingPosition(1)

        /**
         * Checks whether the given [value] is a valid [RankingPosition] (≥ 1).
         */
        public fun isValid(value: Int): Boolean = value >= FIRST.rawInt

        /**
         * Creates a [RankingPosition] if the input [value] is valid.
         *
         * @return A [Result] containing a [RankingPosition] or [IllegalArgumentException] on failure.
         */
        public fun create(value: Int): Result<RankingPosition> =
            if (isValid(value)) Result.success(RankingPosition(value))
            else Result.failure(IllegalArgumentException("Ranking position must be ≥ $FIRST."))

        /**
         * Creates a [RankingPosition] or throws [IllegalArgumentException] if invalid.
         */
        public fun createOrThrow(value: Int): RankingPosition = create(value).getOrThrow()

        /**
         * Creates a [RankingPosition] or returns `null` if the [value] is invalid.
         */
        public fun createOrNull(value: Int): RankingPosition? = create(value).getOrNull()
    }
}

/**
 * Checks whether the ranking position is first.
 */
public fun RankingPosition.isFirst(): Boolean = rawInt == 1
