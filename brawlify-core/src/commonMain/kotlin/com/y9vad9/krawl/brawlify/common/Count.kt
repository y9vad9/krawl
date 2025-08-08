package com.y9vad9.krawl.brawlify.common

/**
 * Represents a strictly positive integer count value.
 *
 * This value class wraps an integer that must be greater than zero. It can be used to model counts
 * such as occurrences, quantities, repetitions, or any other domain concept where negative or zero
 * values are not valid.
 *
 * @property rawInt The underlying positive integer value.
 */
@JvmInline
public value class Count private constructor(public val rawInt: Int) : Comparable<Count> {

    override fun compareTo(other: Count): Int = rawInt.compareTo(other.rawInt)

    public companion object {
        /**
         * Returns `true` if the given [value] is a valid positive count (i.e., > 0).
         */
        public fun isValid(value: Int): Boolean = value > 0

        /**
         * Attempts to create a [Count] from the given [value]. Returns a [Result] containing
         * the instance if valid, or an error if the value is non-positive.
         */
        public fun create(value: Int): Result<Count> =
            if (isValid(value)) Result.success(Count(value))
            else Result.failure(IllegalArgumentException("Count must be > 0 (was $value)"))

        /**
         * Returns a [Count] from the given [value], or throws [IllegalArgumentException]
         * if the value is not strictly positive.
         */
        public fun createOrThrow(value: Int): Count =
            create(value).getOrThrow()

        /**
         * Returns a [Count] from the given [value], or `null` if the value is not strictly positive.
         */
        public fun createOrNull(value: Int): Count? =
            create(value).getOrNull()
    }
}
