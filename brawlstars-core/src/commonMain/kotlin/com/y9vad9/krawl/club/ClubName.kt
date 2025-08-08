package com.y9vad9.krawl.club

import com.y9vad9.krawl.club.ClubName.Companion.LENGTH_RANGE
import com.y9vad9.krawl.club.ClubName.Companion.create

/**
 * Represents a Brawl Stars club name, as displayed in-game.
 *
 * A valid club name:
 * - Must be at least [Companion.MIN_LENGTH] character long.
 * - Must not exceed [Companion.MAX_LENGTH] characters.
 * - Can contain any characters, including emojis and symbols, as long as the length is within the valid range.
 *
 * @property rawString The raw representation of the club name.
 *
 * Use [Companion.create], [Companion.createOrNull], or [Companion.createOrThrow]
 * to safely construct a [ClubName] instance.
 */
@JvmInline
public value class ClubName private constructor(
    /** The validated club name string, as accepted by the Brawl Stars API. */
    public val rawString: String,
) : Comparable<ClubName> {
    /** Companion object containing validation logic and factory methods. */
    public companion object {
        /** The minimum allowed length of a club name. */
        public const val MIN_LENGTH: Int = 1

        /** The maximum allowed length of a club name. */
        public const val MAX_LENGTH: Int = 15

        /** The valid range of length for a club name. */
        public val LENGTH_RANGE: IntRange = MIN_LENGTH..MAX_LENGTH

        /**
         * Returns `true` if the given [input] string is a valid Brawl Stars club name,
         * according to the length constraints in [LENGTH_RANGE].
         *
         * @param input The club name string to validate.
         * @return `true` if valid, otherwise `false`.
         */
        public fun isValid(input: String): Boolean =
            input.length in LENGTH_RANGE

        /**
         * Attempts to create a [ClubName] from the given [input].
         *
         * @param input The club name string to validate and wrap.
         * @return [Result.success] containing a valid [ClubName] if the input passes validation,
         * or [Result.failure] with an [IllegalArgumentException] if invalid.
         */
        public fun create(input: String): Result<ClubName> =
            if (isValid(input)) Result.success(ClubName(input))
            else Result.failure(IllegalArgumentException("Invalid club name length: $input"))

        /**
         * Creates a [ClubName] from [input] or throws [IllegalArgumentException] if invalid.
         *
         * This is a convenience wrapper around [create].
         *
         * @param input The club name string to validate and wrap.
         * @return A valid [ClubName].
         * @throws IllegalArgumentException if [input] is invalid.
         */
        public fun createOrThrow(input: String): ClubName =
            create(input).getOrThrow()

        /**
         * Creates a [ClubName] from [input] or returns `null` if invalid.
         *
         * This is a convenience wrapper around [create].
         *
         * @param input The club name string to validate and wrap.
         * @return A valid [ClubName] or `null` if invalid.
         */
        public fun createOrNull(input: String): ClubName? =
            create(input).getOrNull()
    }

    /**
     * Compares this instance of [ClubName] to the [other] of type [ClubName].
     * Returns result of underlying [rawString] being compared.
     */
    override fun compareTo(other: ClubName): Int = rawString.compareTo(other.rawString)

    /**
     * Returns the raw string representation of this club name.
     *
     * @return The validated club name string.
     */
    override fun toString(): String = rawString
}
