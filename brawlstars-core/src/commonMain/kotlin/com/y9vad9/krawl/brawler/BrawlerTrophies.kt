package com.y9vad9.krawl.brawler

import com.y9vad9.krawl.brawler.BrawlerTrophies.Companion.create
import com.y9vad9.krawl.brawler.BrawlerTrophies.Companion.createOrNull
import com.y9vad9.krawl.brawler.BrawlerTrophies.Companion.createOrThrow
import com.y9vad9.krawl.event.Trophies

/**
 * Represents the trophy-related progress of a Brawl Stars player's brawler.
 *
 * This value object encapsulates both the current and highest trophy counts for a single brawler.
 * Trophies are a core progression metric in Brawl Stars, and both values must be non-negative.
 *
 * Use [create], [createOrThrow], or [createOrNull] to construct validated instances.
 *
 * @property current The player's current total number of trophies for the brawler.
 * This value reflects the live multiplayer standing for that brawler.
 *
 * @property highest The highest number of trophies the player has ever achieved with
 * this brawler. This represents the peak milestone, regardless of current status.
 *
 * @see Trophies
 */
@ConsistentCopyVisibility
public data class BrawlerTrophies private constructor(
    public val current: Trophies,
    public val highest: Trophies,
) {
    public companion object {
        private const val ERROR = "Brawler highest shouldn't be lower than current."

        /**
         * Validates that both trophy values are non-negative.
         *
         * @param current Current number of trophies.
         * @param highest Highest number of trophies achieved.
         * @return `true` if both values are non-negative, `false` otherwise.
         */
        public fun isValid(current: Trophies, highest: Trophies): Boolean =
            current <= highest

        /**
         * Creates a [BrawlerTrophies] instance if both values are non-negative.
         *
         * @param current Current number of trophies.
         * @param highest Highest number of trophies achieved.
         * @return [Result.success] with [BrawlerTrophies] if valid,
         *         or [Result.failure] if any value is negative.
         */
        public fun create(current: Trophies, highest: Trophies): Result<BrawlerTrophies> =
            if (isValid(current, highest)) {
                Result.success(BrawlerTrophies(current, highest))
            } else {
                Result.failure(IllegalArgumentException(ERROR))
            }

        /**
         * Creates a [BrawlerTrophies] or throws if validation fails.
         *
         * @param current Current number of trophies.
         * @param highest Highest number of trophies achieved.
         * @return Validated [BrawlerTrophies] instance.
         * @throws IllegalArgumentException if any value is negative.
         */
        public fun createOrThrow(current: Trophies, highest: Trophies): BrawlerTrophies =
            create(current, highest).getOrThrow()

        /**
         * Creates a [BrawlerTrophies] or returns `null` if validation fails.
         *
         * @param current Current number of trophies.
         * @param highest Highest number of trophies achieved.
         * @return Valid [BrawlerTrophies] or `null` if invalid.
         */
        public fun createOrNull(current: Trophies, highest: Trophies): BrawlerTrophies? =
            create(current, highest).getOrNull()
    }
}
