package com.y9vad9.krawl.brawlify.event.map

import kotlin.jvm.JvmInline

/**
 * Represents the version number of a Star Power in the Brawlify system.
 *
 * Game mode versions are represented as integers starting from [FIRST] and increasing
 * sequentially (e.g., 1, 2, ...). This value class ensures type safety and
 * avoids the use of raw integers across the codebase.
 *
 * Use the [Companion] factory methods to create and validate instances.
 *
 * @property rawInt The raw integer value representing the game mode version.
 */
@JvmInline
public value class BrawlifyMapEnvironmentVersion private constructor(
    public val rawInt: Int,
) : Comparable<BrawlifyMapEnvironmentVersion> {

    override fun compareTo(other: BrawlifyMapEnvironmentVersion): Int = rawInt.compareTo(other.rawInt)

    public companion object {
        /** The first valid game mode version. */
        public val FIRST: BrawlifyMapEnvironmentVersion =
            BrawlifyMapEnvironmentVersion(1)

        /**
         * Returns `true` if the given [value] is a valid game mode version (i.e., ≥ [FIRST]).
         */
        public fun isValid(value: Int): Boolean = value >= FIRST.rawInt

        /**
         * Attempts to create a [BrawlifyMapEnvironmentVersion] from the given [value].
         *
         * Returns a [Result] that is successful if [value] is valid (≥ [FIRST]),
         * or a failure otherwise.
         */
        public fun create(value: Int): Result<BrawlifyMapEnvironmentVersion> {
            return if (value < FIRST.rawInt)
                Result.failure(IllegalArgumentException("game mode version should at least be one"))
            else Result.success(BrawlifyMapEnvironmentVersion(value))
        }

        /**
         * Creates a [BrawlifyMapEnvironmentVersion] from the given [value],
         * or throws an [IllegalArgumentException] if the value is invalid.
         */
        public fun createOrThrow(value: Int): BrawlifyMapEnvironmentVersion =
            create(value).getOrThrow()

        /**
         * Returns a [BrawlifyMapEnvironmentVersion] if [value] is valid, or `null` otherwise.
         */
        public fun createOrNull(value: Int): BrawlifyMapEnvironmentVersion? =
            create(value).getOrNull()
    }
}
