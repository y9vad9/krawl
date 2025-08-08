package com.y9vad9.krawl.club

import com.y9vad9.krawl.club.ClubTag.Companion.MAX_LENGTH
import com.y9vad9.krawl.club.ClubTag.Companion.MIN_LENGTH
import com.y9vad9.krawl.club.ClubTag.Companion.REGEX

/**
 * Represents a validated Brawl Stars **club tag**, used to uniquely identify clubs within the game.
 *
 * Club tags in Brawl Stars:
 * - Are typically **9 characters** long, but can range from [MIN_LENGTH] to [MAX_LENGTH] characters.
 * - May optionally start with `#`.
 * - Contain only uppercase letters (`A–Z`) and digits (`0–9`).
 *
 * This type ensures valid format using [REGEX] at construction time,
 * and provides safe factory methods to avoid invalid states.
 *
 * Internally, the tag is stored as-is (including `#` if present), and utilities
 * are available to access both the raw and normalized versions.
 */
@JvmInline
public value class ClubTag private constructor(
    private val string: String,
) {
    /**
     * Returns the tag string with a leading `#`, even if not originally present.
     *
     * Useful for display or when sending to the Brawl Stars API.
     *
     * @return The tag string prefixed with `#`.
     */
    public val stringWithTagPrefix: String
        get() = if (string.startsWith("#")) string else "#$string"

    /**
     * Returns the tag string without the leading `#`.
     *
     * Useful for comparisons, storage, or internal usage.
     *
     * @return The tag string without the `#` prefix.
     */
    public val stringWithoutTagPrefix: String
        get() = if (string.startsWith("#")) string.substring(1) else string

    /**
     * Returns the canonical display format of the tag, always prefixed with `#`.
     *
     * @return The tag string with leading `#`.
     * @see stringWithTagPrefix
     */
    override fun toString(): String = stringWithTagPrefix

    /** Constants and validation */
    public companion object {
        /** Minimum allowed length for a tag, excluding `#`. */
        public const val MIN_LENGTH: Int = 3

        /** Maximum allowed length for a tag, excluding `#`. */
        public const val MAX_LENGTH: Int = 14

        /**
         * Regular expression to validate club tags.
         *
         * Accepts optional `#`, allows only uppercase A–Z and digits 0–9,
         * with length between [MIN_LENGTH] and [MAX_LENGTH].
         * Case-insensitive.
         */
        public val REGEX: Regex = Regex(
            pattern = "^#?[A-Z0-9]{$MIN_LENGTH,$MAX_LENGTH}$",
            option = RegexOption.IGNORE_CASE,
        )

        /**
         * Validates whether the [input] string is a valid club tag.
         *
         * Case-insensitive.
         *
         * @param input The tag string to validate, with or without leading `#`.
         * @return `true` if [input] is a valid club tag, otherwise `false`.
         */
        public fun isValid(input: String): Boolean =
            REGEX.matches(input)

        /**
         * Attempts to create a [ClubTag] from the given [input].
         *
         * The input is uppercased and validated using [REGEX].
         *
         * @param input The tag string to create a [ClubTag] from.
         * @return [Result.success] with a valid [ClubTag] if input is valid,
         *         otherwise [Result.failure] with an [IllegalArgumentException].
         */
        public fun create(input: String): Result<ClubTag> {
            val normalized = input.uppercase()
            return if (isValid(normalized)) Result.success(ClubTag(normalized))
            else Result.failure(IllegalArgumentException("Invalid club tag: $input"))
        }

        /**
         * Creates a [ClubTag] from [input] or throws [IllegalArgumentException] if invalid.
         *
         * @param input The tag string to create a [ClubTag] from.
         * @return A valid [ClubTag] instance.
         * @throws IllegalArgumentException if [input] is invalid.
         */
        public fun createOrThrow(input: String): ClubTag =
            create(input).getOrThrow()

        /**
         * Creates a [ClubTag] from [input] or returns `null` if invalid.
         *
         * @param input The tag string to create a [ClubTag] from.
         * @return A valid [ClubTag], or `null` if invalid.
         */
        public fun createOrNull(input: String): ClubTag? =
            create(input).getOrNull()
    }
}
