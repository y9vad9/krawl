package com.y9vad9.krawl.player

import com.y9vad9.krawl.player.PlayerName.Companion.LENGTH_RANGE
import com.y9vad9.krawl.player.PlayerName.Companion.MAX_LENGTH
import com.y9vad9.krawl.player.PlayerName.Companion.MIN_LENGTH
import com.y9vad9.krawl.player.PlayerName.Companion.create
import com.y9vad9.krawl.player.PlayerName.Companion.createOrNull
import com.y9vad9.krawl.player.PlayerName.Companion.createOrThrow
import kotlin.jvm.JvmInline

/**
 * Represents a Brawl Stars player name, as shown in-game.
 *
 * A valid player name:
 * - Must be at least [MIN_LENGTH] character long.
 * - Must not exceed [MAX_LENGTH] characters.
 * - Can contain any character (including emojis, symbols, etc.), as long as the length is valid.
 *
 * Use [create], [createOrNull], or [createOrThrow] to safely construct a [PlayerName] instance.
 */
@JvmInline
public value class PlayerName private constructor(
    /** The validated player name string, as accepted by the Brawl Stars API. */
    public val rawString: String,
) {
    /** Constants with constraints and validation */
    public companion object {
        /** The minimum allowed length of a player name. */
        public const val MIN_LENGTH: Int = 1

        /** The maximum allowed length of a player name. */
        public const val MAX_LENGTH: Int = 15

        /** The valid range of length for a player name. */
        public val LENGTH_RANGE: IntRange = MIN_LENGTH..MAX_LENGTH

        /**
         * Returns `true` if the given [input] string is a valid Brawl Stars player name,
         * based on [LENGTH_RANGE].
         */
        public fun isValid(input: String): Boolean =
            input.length in LENGTH_RANGE

        /**
         * Attempts to create a [PlayerName] from the given [input] string.
         *
         * Returns a [Result.success] if valid, or a [Result.failure] containing an [IllegalArgumentException]
         * if the input is invalid.
         */
        public fun create(input: String): Result<PlayerName> =
            if (isValid(input)) Result.success(PlayerName(input))
            else Result.failure(IllegalArgumentException("Invalid player name length: $input"))

        /**
         * Creates a [PlayerName] from [input] or throws [IllegalArgumentException] if invalid.
         */
        public fun createOrThrow(input: String): PlayerName =
            create(input).getOrThrow()

        /**
         * Creates a [PlayerName] from [input] or returns `null` if invalid.
         */
        public fun createOrNull(input: String): PlayerName? =
            create(input).getOrNull()
    }

    /**
     * Returns the raw string representation of this player name.
     */
    override fun toString(): String = rawString
}
