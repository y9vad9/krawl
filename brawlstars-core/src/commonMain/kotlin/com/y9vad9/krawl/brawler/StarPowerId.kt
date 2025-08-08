package com.y9vad9.krawl.brawler

import com.y9vad9.krawl.brawler.StarPowerId.Companion.MAX_VALUE
import com.y9vad9.krawl.brawler.StarPowerId.Companion.MIN_VALUE
import com.y9vad9.krawl.brawler.StarPowerId.Companion.VALUE_RANGE
import com.y9vad9.krawl.brawler.StarPowerId.Companion.create
import com.y9vad9.krawl.brawler.StarPowerId.Companion.createOrNull
import com.y9vad9.krawl.brawler.StarPowerId.Companion.createOrThrow

/**
 * Represents a unique identifier for a Star Power in Brawl Stars.
 *
 * This value class wraps an integer [value] that corresponds to a specific Star Power
 * and provides type safety across the domain model. Valid Star Power IDs fall within
 * the range defined by [MIN_VALUE] to [MAX_VALUE].
 *
 * Use [create], [createOrThrow], or [createOrNull] to safely construct an instance.
 *
 * @property value The underlying integer representation of the Star Power ID.
 */
@JvmInline
public value class StarPowerId private constructor(
    public val value: Int,
) : Comparable<StarPowerId> {

    /**
     * Provides constants and factory methods for [StarPowerId].
     */
    public companion object {
        /** The minimum valid Star Power ID value. */
        public const val MIN_VALUE: Int = 23_000_000

        /** The maximum valid Star Power ID value. */
        public const val MAX_VALUE: Int = 23_001_000

        /** The inclusive range of valid Star Power ID values. */
        public val VALUE_RANGE: IntRange = MIN_VALUE..MAX_VALUE

        /**
         * Checks whether the given [input] integer is a valid Star Power ID.
         *
         * @param input The integer to validate.
         * @return `true` if [input] falls within [VALUE_RANGE], `false` otherwise.
         */
        public fun isValid(input: Int): Boolean =
            input in VALUE_RANGE

        /**
         * Attempts to create a [StarPowerId] from the given [input].
         *
         * @param input The integer ID to convert.
         * @return A [Result] containing a [StarPowerId] on success,
         * or a failure with [IllegalArgumentException] if invalid.
         */
        public fun create(input: Int): Result<StarPowerId> =
            if (isValid(input)) Result.success(StarPowerId(input))
            else Result.failure(IllegalArgumentException("Invalid Star Power ID: $input"))

        /**
         * Creates a [StarPowerId] from [input], or throws [IllegalArgumentException] if invalid.
         *
         * @param input The integer ID to convert.
         * @return A valid [StarPowerId].
         * @throws IllegalArgumentException If [input] is outside [VALUE_RANGE].
         */
        public fun createOrThrow(input: Int): StarPowerId =
            create(input).getOrThrow()

        /**
         * Creates a [StarPowerId] from [input], or returns `null` if [input] is invalid.
         *
         * @param input The integer ID to convert.
         * @return A valid [StarPowerId], or `null` if invalid.
         */
        public fun createOrNull(input: Int): StarPowerId? =
            create(input).getOrNull()
    }

    /**
     * Compares this ID with another [StarPowerId] by their numeric [value].
     *
     * @param other The ID to compare against.
     * @return Result of comparing the two integer values.
     */
    override fun compareTo(other: StarPowerId): Int = value.compareTo(other.value)
}
