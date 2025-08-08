package com.y9vad9.krawl.club

import com.y9vad9.krawl.event.Trophies

/**
 * Represents a Brawl Stars Club with all relevant metadata and current status.
 *
 * This data class contains the tag, name, description, badge, membership, and type of the club.
 * It also exposes computed properties to help determine the club's current availability status.
 *
 * @property tag The unique tag identifier of the club.
 * @property badgeId The visual badge assigned to the club.
 * @property name The display name of the club.
 * @property description The user-defined description of the club.
 * @property members The current list of club members along with total trophy count.
 * @property type The join policy of the club (open, invite-only, or closed).
 */
public data class Club(
    public val tag: ClubTag,
    public val badgeId: ClubBadgeId,
    public val name: ClubName,
    public val description: ClubDescription,
    public val members: ClubMembers,
    public val type: ClubType,
)

/**
 * The total number of trophies held by all members of the club.
 */
public val Club.totalTrophies: Trophies
    get() = members.totalTrophies

/**
 * Returns `true` if the club currently has available member slots (less than 30 members).
 *
 * This does not take the club type (open/closed/invite-only) into account.
 */
public val Club.hasFreeMemberSlots: Boolean
    get() = members.hasFreeSeats()

/**
 * Returns `true` if the club has available slots and allows immediate joining (i.e., is open).
 */
public val Club.canBeJoinedFreelyNow: Boolean
    get() = hasFreeMemberSlots && type.isOpen

/**
 * Returns `true` if the club has available slots and is set to invite-only join mode.
 */
public val Club.canBeJoinedByInvitationNow: Boolean
    get() = hasFreeMemberSlots && type.isInviteOnly

/**
 * Returns `true` if the club has available slots and is not marked as closed to new members.
 */
public val Club.canBeJoinedUnderAnyConditionNow: Boolean
    get() = hasFreeMemberSlots && !type.isClosed

/**
 * Returns the number of remaining slots available for new members.
 *
 * Clubs can have a maximum of 30 members.
 */
public val Club.remainingMemberSlots: Int
    get() = ClubMembers.MAX_CLUB_MEMBERS - members.list.size
