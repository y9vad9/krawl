package com.y9vad9.krawl.common

import kotlin.jvm.JvmInline

/**
 * Represents the hexadecimal color assigned to a player's name in Brawl Stars.
 *
 * The color is typically displayed in the player's profile or club list. It is defined
 * using a 3- or 6-digit hexadecimal string, optionally prefixed with `#` (e.g. `#FF0000` or `FFF`).
 *
 * @property rawString The raw hexadecimal string representing the color, possibly with a leading `#`.
 */
@JvmInline
public value class HexColor private constructor(public val rawString: String) {
    public companion object {
        /**
         * Regex used to validate a valid color string (with optional `#`).
         */
        public val FORMAT: Regex = Regex("^#?(?:[A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$")

        /**
         * Checks whether the given color string is valid.
         *
         * @param value The raw string to check.
         * @return `true` if it matches the [FORMAT], `false` otherwise.
         */
        public fun isValid(value: String): Boolean = FORMAT.matches(value)

        /**
         * Creates a [HexColor] instance if the provided [value] is valid.
         *
         * @param value The raw string to validate and wrap.
         * @return [Result.success] with a [HexColor], or [Result.failure] if invalid.
         */
        public fun create(value: String): Result<HexColor> =
            if (isValid(value)) Result.success(HexColor(value))
            else Result.failure(IllegalArgumentException("Invalid HexColor: '$value'"))

        /**
         * Creates a [HexColor] or returns `null` if the string is invalid.
         *
         * @param value The raw string to validate and wrap.
         * @return A [HexColor] or `null`.
         */
        public fun createOrNull(value: String): HexColor? =
            create(value).getOrNull()

        /**
         * Creates a [HexColor] or throws [IllegalArgumentException] if the string is invalid.
         *
         * @param value The raw string to validate and wrap.
         * @return A [HexColor] instance.
         * @throws IllegalArgumentException if [value] is not valid.
         */
        public fun createOrThrow(value: String): HexColor =
            create(value).getOrThrow()
    }
}
