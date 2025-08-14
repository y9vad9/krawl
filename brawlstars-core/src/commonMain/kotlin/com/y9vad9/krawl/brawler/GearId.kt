package com.y9vad9.krawl.brawler

import kotlin.jvm.JvmInline

/**
 * Represents a unique identifier for a Gear in Brawl Stars.
 *
 * Gears are passive upgrades that enhance a brawler's performance in various ways
 * (e.g., faster reload speed, healing boosts, etc.). Each gear has an associated
 * ID within a known numeric range, defined by the game.
 *
 * This value class enforces a valid ID range and provides utility methods to validate
 * or construct safe instances of [GearId].
 *
 * @property value The raw integer identifier of the gear.
 */
@JvmInline
public value class GearId private constructor(
    /**
     * The raw integer identifier of the gear.
     */
    public val value: Int,
) : Comparable<GearId> {
    /** Constants with constraints and validation */
    public companion object {
        /**
         * The minimum valid gear ID value.
         */
        public const val MIN_VALUE: Int = 23_000_000

        /**
         * The maximum valid gear ID value.
         */
        public const val MAX_VALUE: Int = 23_001_000

        /**
         * The inclusive range of valid gear ID values.
         */
        public val VALUE_RANGE: IntRange = MIN_VALUE..MAX_VALUE

        /**
         * Returns `true` if the [input] is within the valid gear ID range.
         *
         * @param input The raw ID to check.
         * @return `true` if valid, `false` otherwise.
         */
        public fun isValid(input: Int): Boolean =
            input in VALUE_RANGE

        /**
         * Attempts to create a [GearId] from the provided [input].
         *
         * @param input The raw integer gear ID.
         * @return [Result.success] if valid, [Result.failure] with [IllegalArgumentException] otherwise.
         */
        public fun create(input: Int): Result<GearId> =
            if (isValid(input)) Result.success(GearId(input))
            else Result.failure(IllegalArgumentException("Invalid gear ID: $input"))

        /**
         * Creates a [GearId] from the given [input], or throws an [IllegalArgumentException] if invalid.
         *
         * @param input The raw gear ID.
         * @return A valid [GearId] instance.
         * @throws IllegalArgumentException If the input is invalid.
         */
        public fun createOrThrow(input: Int): GearId =
            create(input).getOrThrow()

        /**
         * Creates a [GearId] from the given [input], or returns `null` if invalid.
         *
         * @param input The raw gear ID.
         * @return A valid [GearId] or `null`.
         */
        public fun createOrNull(input: Int): GearId? =
            create(input).getOrNull()
    }

    /**
     * Compares this [GearId] with another [GearId] by their raw integer values.
     *
     * @param other The other gear ID to compare against.
     * @return A negative value if this is less, zero if equal, or positive if greater.
     */
    override fun compareTo(other: GearId): Int = value.compareTo(other.value)
}
