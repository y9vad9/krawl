package com.y9vad9.krawl.club

import com.y9vad9.krawl.club.ClubMembers.Companion.MAX_CLUB_MEMBERS
import com.y9vad9.krawl.event.Trophies

/**
 * Represents the collection of members currently in a Brawl Stars club.
 *
 * This includes the total combined trophy count of all members and a list
 * of individual [ClubMember] entries.
 *
 * This model reflects a snapshot of the club’s current composition and
 * competitive standing.
 *
 * @property totalTrophies The total sum of trophies held by all members of the club.
 * This is often used to evaluate the club’s overall performance or standing in leaderboards.
 *
 * @property list A list of individual [ClubMember] entries representing each player's
 * current status within the club.
 */
public data class ClubMembers(
    /**
     * The total sum of trophies held by all members of the club.
     */
    public val totalTrophies: Trophies,

    /**
     * A list of all individual members currently part of the club.
     */
    public val list: List<ClubMember>,
) {
    public companion object {
        /**
         * Max amount of member that can be in club. We don't validate it while creating a class,
         * in case something changes or possible anomalies that have already occured in the past.
         */
        public const val MAX_CLUB_MEMBERS: Int = 30
    }
}

/**
 * Checks if the club has any free seats available.
 *
 * @return `true` if the club has fewer than $MAX_CLUB_MEMBERS members, `false` otherwise.
 */
public fun ClubMembers.hasFreeSeats(): Boolean =
    list.size < MAX_CLUB_MEMBERS

/**
 * Returns the number of free seats left in the club.
 *
 * @return The count of remaining free seats. Returns 0 if the club is full.
 */
public val ClubMembers.freeSeatsCount: Int
    get() =
        (MAX_CLUB_MEMBERS - list.size).coerceAtLeast(0)

/**
 * Returns amount of club members.
 */
public val ClubMembers.count: ClubMembersCount
    get() = ClubMembersCount.createOrThrow(list.size)
