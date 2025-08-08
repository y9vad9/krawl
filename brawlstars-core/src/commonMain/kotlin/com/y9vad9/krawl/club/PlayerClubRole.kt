package com.y9vad9.krawl.club

import com.y9vad9.krawl.club.PlayerClubRole.Companion.UNKNOWN
import com.y9vad9.krawl.club.PlayerClubRole.Companion.from

/**
 * Represents a member’s role within a Brawl Stars Club.
 *
 * This value class wraps the raw role string provided by the Brawl Stars API,
 * offering a type-safe way to work with known and unknown club roles. While
 * predefined constants cover all officially documented roles, any raw string
 * value is accepted to ensure compatibility with future or undocumented roles.
 *
 * The [from] factory method can be used to resolve standard roles or fall back
 * to the raw input if it's unknown.
 *
 * @property raw The raw role string as returned by the Brawl Stars API.
 */
@JvmInline
public value class PlayerClubRole private constructor(public val raw: String) {

    /**
     * Companion object housing predefined [PlayerClubRole] constants
     * and the [from] factory method.
     */
    public companion object {
        /**
         * Represents the club president, who has full administrative permissions,
         * including managing other roles and controlling the club structure.
         */
        public val PRESIDENT: PlayerClubRole = PlayerClubRole("president")

        /**
         * Represents a vice president with elevated administrative rights, such as
         * accepting or kicking members, but with limited authority compared to the president.
         */
        public val VICE_PRESIDENT: PlayerClubRole = PlayerClubRole("vicePresident")

        /**
         * Represents a senior member who can perform limited actions, such as
         * accepting join requests or removing regular members from the club.
         */
        public val SENIOR: PlayerClubRole = PlayerClubRole("senior")

        /**
         * Represents a standard club member with no special privileges or administrative roles.
         */
        public val MEMBER: PlayerClubRole = PlayerClubRole("member")

        /**
         * Represents a player who is not currently part of any club.
         *
         * This is explicitly returned by the Brawl Stars API for users
         * without any club affiliation.
         */
        public val NOT_MEMBER: PlayerClubRole = PlayerClubRole("notMember")

        /**
         * Represents an explicitly unknown or unmapped club role.
         *
         * This is returned by the API in some edge cases and should not be
         * confused with future or invalid roles. The raw value must be `"unknown"`.
         */
        public val UNKNOWN: PlayerClubRole = PlayerClubRole("unknown")

        /**
         * Resolves a [PlayerClubRole] from the raw API-provided string.
         *
         * If the string matches a known role (case-insensitive), the corresponding
         * predefined constant is returned. Otherwise, a new [PlayerClubRole] is
         * constructed from the raw string without mapping to [UNKNOWN].
         *
         * @param raw The raw string value received from the API.
         * @return A known [PlayerClubRole] instance if recognized, or a new wrapper otherwise.
         */
        public fun from(raw: String): PlayerClubRole = when (raw.lowercase()) {
            "president" -> PRESIDENT
            "vicepresident" -> VICE_PRESIDENT
            "senior" -> SENIOR
            "member" -> MEMBER
            "notmember" -> NOT_MEMBER
            "unknown" -> UNKNOWN
            else -> PlayerClubRole(raw)
        }
    }

    /**
     * Returns the raw string representation of the club role.
     *
     * This matches the original value as returned by the Brawl Stars API.
     *
     * @return The raw string representing this role.
     */
    override fun toString(): String = raw
}

/**
 * Returns `true` if the player has full administrative control over the club.
 */
public val PlayerClubRole.isPresident: Boolean
    get() = this == PlayerClubRole.PRESIDENT

/**
 * Returns `true` if the player has elevated administrative privileges
 * (below president but above senior/member).
 */
public val PlayerClubRole.isVicePresident: Boolean
    get() = this == PlayerClubRole.VICE_PRESIDENT

/**
 * Returns `true` if the player has some limited administrative capabilities,
 * such as approving requests or kicking lower-ranked members.
 */
public val PlayerClubRole.isSenior: Boolean
    get() = this == PlayerClubRole.SENIOR

/**
 * Returns `true` if the player is a regular club member with no special privileges.
 */
public val PlayerClubRole.isMember: Boolean
    get() = this == PlayerClubRole.MEMBER

/**
 * Returns `true` if the player is not currently a member of any club.
 */
public val PlayerClubRole.isNotMember: Boolean
    get() = this == PlayerClubRole.NOT_MEMBER

/**
 * Returns `true` if the player's role is marked as explicitly unknown.
 *
 * This does not include unrecognized future values—only a role string
 * exactly equal to `"unknown"` as returned by the API.
 */
public val PlayerClubRole.isUnknown: Boolean
    get() = this == UNKNOWN

/**
 * Returns `true` if the player has *any* administrative role (president,
 * vice president, or senior).
 */
public val PlayerClubRole.isAdmin: Boolean
    get() = isPresident || isVicePresident || isSenior

/**
 * Returns `true` if the player currently belongs to a club.
 */
public val PlayerClubRole.isInClub: Boolean
    get() = this != PlayerClubRole.NOT_MEMBER

/**
 * Returns `true` if the role can kick regular members from the club.
 */
public val PlayerClubRole.canKick: Boolean
    get() = isPresident || isVicePresident || isSenior

/**
 * Returns `true` if the role can promote or demote other members.
 *
 * Only the president can promote/demote vice presidents and seniors.
 */
public val PlayerClubRole.canManageRoles: Boolean
    get() = isPresident

/**
 * Returns `true` if the role can accept new join requests.
 */
public val PlayerClubRole.canAcceptRequests: Boolean
    get() = isPresident || isVicePresident || isSenior

/**
 * Returns `true` if the role can invite players to the club.
 */
public val PlayerClubRole.canInvite: Boolean
    get() = isPresident || isVicePresident || isSenior

/**
 * Returns `true` if the role can change the club's description, type, or settings.
 */
public val PlayerClubRole.canEditClub: Boolean
    get() = isPresident || isVicePresident

/**
 * Returns `true` if the role can delete or disband the club.
 */
public val PlayerClubRole.canDisbandClub: Boolean
    get() = isPresident

/**
 * Returns `true` if the role has any administrative capabilities.
 */
public val PlayerClubRole.hasAdminPrivileges: Boolean
    get() = isPresident || isVicePresident || isSenior
