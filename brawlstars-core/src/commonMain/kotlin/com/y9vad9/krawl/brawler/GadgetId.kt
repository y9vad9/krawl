package com.y9vad9.krawl.brawler

import com.y9vad9.krawl.brawler.GadgetId.Companion.MAX_VALUE
import com.y9vad9.krawl.brawler.GadgetId.Companion.MIN_VALUE
import com.y9vad9.krawl.brawler.GadgetId.Companion.create
import com.y9vad9.krawl.brawler.GadgetId.Companion.createOrNull
import com.y9vad9.krawl.brawler.GadgetId.Companion.createOrThrow

/**
 * Represents a unique identifier for a Gadget in Brawl Stars.
 *
 * This class wraps an integer ID that identifies a specific gadget.
 * Valid IDs fall within a predefined range ([MIN_VALUE] to [MAX_VALUE]).
 * Sorting by [GadgetId] compares the underlying integer values.
 *
 * Use [create], [createOrNull], or [createOrThrow] to safely construct a [GadgetId] instance.
 */
@JvmInline
public value class GadgetId private constructor(
    /** The underlying integer value of the gadget ID. */
    public val value: Int,
) : Comparable<GadgetId> {
    /** Constants with constraints and validation */
    public companion object {
        /** Minimum valid value for a gadget ID. */
        public const val MIN_VALUE: Int = 23_000_000

        /** Maximum valid value for a gadget ID. */
        public const val MAX_VALUE: Int = 23_001_000

        /** Valid range of gadget ID values. */
        public val VALUE_RANGE: IntRange = MIN_VALUE..MAX_VALUE

        /**
         * Returns `true` if the given [input] is within the valid gadget ID range.
         *
         * This function performs a sanity check to ensure [input] falls within
         * the expected ID range for gadgets.
         */
        public fun isValid(input: Int): Boolean =
            input in VALUE_RANGE

        /**
         * Attempts to create a [GadgetId] from the given [input].
         *
         * Returns a [Result.success] containing a valid [GadgetId], or
         * a [Result.failure] with an [IllegalArgumentException] if [input] is invalid.
         */
        public fun create(input: Int): Result<GadgetId> =
            if (isValid(input)) Result.success(GadgetId(input))
            else Result.failure(IllegalArgumentException("Invalid gadget ID: $input"))

        /**
         * Creates a [GadgetId] from [input] or throws [IllegalArgumentException] if invalid.
         */
        public fun createOrThrow(input: Int): GadgetId =
            create(input).getOrThrow()

        /**
         * Creates a [GadgetId] from [input], or returns `null` if invalid.
         */
        public fun createOrNull(input: Int): GadgetId? =
            create(input).getOrNull()
    }

    /**
     * Compares this [GadgetId] with another based on their integer values.
     *
     * @param other The other [GadgetId] to compare against.
     * @return A negative integer, zero, or a positive integer as this ID
     * is less than, equal to, or greater than the other ID.
     */
    override fun compareTo(other: GadgetId): Int = value.compareTo(other.value)
}
