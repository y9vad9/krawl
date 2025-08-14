package com.y9vad9.krawl.club

import com.y9vad9.krawl.club.ClubType.Companion.UNKNOWN
import kotlin.jvm.JvmInline

/**
 * Represents the type of a Brawl Stars Club (Open / Invite-only / Closed).
 *
 * This value class wraps the raw API string, while providing constants and
 * type-safe checks for supported club types. Any unrecognised raw value is
 * preserved via [UNKNOWN].
 *
 * @property raw The raw string value exactly as returned by the Brawl Stars API.
 */
@JvmInline
public value class ClubType private constructor(
    public val raw: String
) : Comparable<ClubType> {

    /**
     * Compares club types lexicographically by their raw string values.
     */
    public override fun compareTo(other: ClubType): Int =
        raw.compareTo(other.raw, ignoreCase = true)

    /**
     * Returns the textual club type as used by the API or for display.
     */
    public override fun toString(): String = raw

    /**
     * Factory and predefined constants for well‑known club types.
     */
    public companion object {
        /**
         * Club is open — any player may join without approval.
         */
        public val OPEN: ClubType = ClubType("open")

        /**
         * Club requires approval — players must request membership to join.
         */
        public val INVITE_ONLY: ClubType = ClubType("invite_only")

        /**
         * Club is closed — players can only join if explicitly invited.
         */
        public val CLOSED: ClubType = ClubType("closed")

        /**
         * Represents an unrecognised club type string from the API.
         * Note: this value is used only if the incoming value is explicitly marked as
         * unknown. In case if any other value that is not enumerated in [ClubType] is entered,
         * it will not fall under this category.
         */
        public val UNKNOWN: ClubType = ClubType("unknown")

        /**
         * Parses the raw club type string (case-insensitive) into a known constant or
         * wraps it into [UNKNOWN] if it does not match one of the known types.
         *
         * @param rawType The raw string value from the Brawl Stars API.
         * @return Matching [ClubType] constant or new instance for unknown raw value.
         */
        public fun from(rawType: String): ClubType {
            return when (rawType.lowercase()) {
                OPEN.raw -> OPEN
                INVITE_ONLY.raw -> INVITE_ONLY
                CLOSED.raw -> CLOSED
                UNKNOWN.raw -> UNKNOWN
                else -> ClubType(rawType)
            }
        }
    }
}

/**
 * Returns `true` if the club is open to all players without requiring approval.
 */
public inline val ClubType.isOpen: Boolean get() = this == ClubType.OPEN

/**
 * Returns `true` if the club requires players to request approval to join.
 */
public inline val ClubType.isInviteOnly: Boolean get() = this == ClubType.INVITE_ONLY

/**
 * Returns `true` if the club only accepts invited players and does not show a join request option.
 */
public inline val ClubType.isClosed: Boolean get() = this == ClubType.CLOSED

/**
 * Returns `true` if the club may accept the player directly without any prior action.
 */
public inline val ClubType.canJoinDirectly: Boolean
    get() = isOpen

/**
 * Returns `true` if new membership requires an invitation—either explicitly or via joining permission.
 */
public inline val ClubType.requiresInvite: Boolean get() = isClosed || isInviteOnly
