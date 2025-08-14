package com.y9vad9.krawl.club

import com.y9vad9.krawl.club.ClubBadgeId.Companion.MAX_BADGE_ID
import com.y9vad9.krawl.club.ClubBadgeId.Companion.MIN_BADGE_ID
import kotlin.jvm.JvmInline

/**
 * Represents a unique identifier for a Brawl Stars Club Badge.
 *
 * Club Badge IDs are integer values within a specific range used to identify
 * different badge designs available for clubs in Brawl Stars.
 *
 * This value class ensures that badge IDs are within the valid range at creation time.
 *
 * @property int The numeric badge ID.
 */
@JvmInline
public value class ClubBadgeId private constructor(public val int: Int) : Comparable<ClubBadgeId> {

    public companion object {
        /** The minimum valid badge ID for club badges. */
        public val MIN_BADGE_ID: ClubBadgeId = ClubBadgeId(8_000_000)

        /** The maximum valid badge ID for club badges. */
        public val MAX_BADGE_ID: ClubBadgeId = ClubBadgeId(8_100_000)

        /** The valid range of club badge IDs, inclusive. */
        public val VALID_BADGE_ID_RANGE: ClosedRange<ClubBadgeId> = MIN_BADGE_ID..MAX_BADGE_ID

        /**
         * Checks if the given [input] is a valid ClubBadgeId integer.
         *
         * @param input The badge ID to validate.
         * @return `true` if [input] is within [MIN_BADGE_ID] and [MAX_BADGE_ID], otherwise `false`.
         */
        public fun isValid(input: Int): Boolean =
            input in MIN_BADGE_ID.int..MAX_BADGE_ID.int

        /**
         * Attempts to create a [ClubBadgeId] from the given [input].
         *
         * @param input The badge ID integer.
         * @return [Result.success] with a valid [ClubBadgeId] or [Result.failure] if invalid.
         */
        public fun create(input: Int): Result<ClubBadgeId> =
            if (isValid(input)) Result.success(ClubBadgeId(input))
            else Result.failure(IllegalArgumentException("Invalid ClubBadgeId: $input"))

        /**
         * Creates a [ClubBadgeId] or throws [IllegalArgumentException] if the input is invalid.
         *
         * @param input The badge ID integer.
         * @return A valid [ClubBadgeId].
         * @throws IllegalArgumentException if [input] is outside the valid range.
         */
        public fun createOrThrow(input: Int): ClubBadgeId =
            create(input).getOrThrow()

        /**
         * Creates a [ClubBadgeId] or returns `null` if the input is invalid.
         *
         * @param input The badge ID integer.
         * @return A valid [ClubBadgeId], or `null` if invalid.
         */
        public fun createOrNull(input: Int): ClubBadgeId? =
            create(input).getOrNull()
    }

    override fun compareTo(other: ClubBadgeId): Int = int.compareTo(other.int)
}
