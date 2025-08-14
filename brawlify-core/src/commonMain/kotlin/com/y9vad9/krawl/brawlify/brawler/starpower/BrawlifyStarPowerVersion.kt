package com.y9vad9.krawl.brawlify.brawler.starpower

import com.y9vad9.krawl.brawlify.event.map.BrawlifyMapVersion
import kotlin.jvm.JvmInline

/**
 * Represents the version number of a Star Power in the Brawlify system.
 *
 * Gadget versions are represented as integers starting from [FIRST] and increasing
 * sequentially (e.g., 1, 2, ...). This value class ensures type safety and
 * avoids the use of raw integers across the codebase.
 *
 * Use the [Companion] factory methods to create and validate instances.
 *
 * @property rawInt The raw integer value representing the gadget version.
 */
@JvmInline
public value class BrawlifyStarPowerVersion private constructor(
    public val rawInt: Int,
) : Comparable<BrawlifyStarPowerVersion> {

    override fun compareTo(other: BrawlifyStarPowerVersion): Int = rawInt.compareTo(other.rawInt)

    public companion object {
        /** The first valid gadget version. */
        public val FIRST: BrawlifyStarPowerVersion = BrawlifyStarPowerVersion(1)

        /**
         * Returns `true` if the given [value] is a valid gadget version (i.e., ≥ [FIRST]).
         */
        public fun isValid(value: Int): Boolean = value >= FIRST.rawInt

        /**
         * Attempts to create a [BrawlifyMapVersion] from the given [value].
         *
         * Returns a [Result] that is successful if [value] is valid (≥ [FIRST]),
         * or a failure otherwise.
         */
        public fun create(value: Int): Result<BrawlifyStarPowerVersion> {
            return if (value < FIRST.rawInt)
                Result.failure(IllegalArgumentException("Gadget version should at least be one"))
            else Result.success(BrawlifyStarPowerVersion(value))
        }

        /**
         * Creates a [BrawlifyMapVersion] from the given [value],
         * or throws an [IllegalArgumentException] if the value is invalid.
         */
        public fun createOrThrow(value: Int): BrawlifyStarPowerVersion =
            create(value).getOrThrow()

        /**
         * Returns a [BrawlifyMapVersion] if [value] is valid, or `null` otherwise.
         */
        public fun createOrNull(value: Int): BrawlifyStarPowerVersion? =
            create(value).getOrNull()
    }
}
