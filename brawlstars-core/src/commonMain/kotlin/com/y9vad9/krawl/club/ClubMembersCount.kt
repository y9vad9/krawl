package com.y9vad9.krawl.club

import kotlin.jvm.JvmInline

/**
 * Represents the number of members in a Brawl Stars club.
 *
 * This value class ensures the count is non-negative and typically capped at 30 in-game.
 *
 * @property int The number of members in the club.
 */
@JvmInline
public value class ClubMembersCount private constructor(public val int: Int) : Comparable<ClubMembersCount> {

    override fun compareTo(other: ClubMembersCount): Int = int.compareTo(other.int)

    public companion object {
        /** Minimum allowed member count (inclusive). */
        public const val MIN_VALUE: Int = 0

        /** Maximum number of members a club can have (as per in-game limits). */
        public const val MAX_VALUE: Int = 30

        /**
         * Returns whether the given [value] is valid as a club member count.
         *
         * Valid values are in the range `[MIN_VALUE, MAX_VALUE]`.
         */
        public fun isValid(value: Int): Boolean =
            value in MIN_VALUE..MAX_VALUE

        /**
         * Attempts to create a [ClubMembersCount] from the given [value].
         *
         * @return [Result.success] if the value is valid, [Result.failure] otherwise.
         */
        public fun create(value: Int): Result<ClubMembersCount> =
            if (isValid(value)) Result.success(ClubMembersCount(value))
            else Result.failure(
                IllegalArgumentException("Club members count must be in $MIN_VALUE..$MAX_VALUE, but was $value.")
            )

        /**
         * Creates a [ClubMembersCount], throwing an [IllegalArgumentException] if invalid.
         */
        public fun createOrThrow(value: Int): ClubMembersCount = create(value).getOrThrow()

        /**
         * Creates a [ClubMembersCount] or returns `null` if the [value] is invalid.
         */
        public fun createOrNull(value: Int): ClubMembersCount? = create(value).getOrNull()
    }
}
