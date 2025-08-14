package com.y9vad9.krawl.event.battle

import kotlin.jvm.JvmInline

/**
 * Represents a change in trophies resulting from a Brawl Stars battle.
 *
 * The change may be:
 * - Positive: trophies were gained
 * - Negative: trophies were lost
 * - Zero: no trophies were awarded
 *
 * This type encapsulates raw trophy delta as provided by the API and offers
 * semantic helpers for checking the outcome.
 *
 * @property rawInt The raw integer delta representing the trophy change.
 */
@JvmInline
public value class TrophyChange(public val rawInt: Int) : Comparable<TrophyChange> {

    /**
     * Compares this [TrophyChange] with another.
     *
     * @param other The other [TrophyChange] instance to compare with.
     * @return A negative integer, zero, or a positive integer as this instance
     *         is less than, equal to, or greater than [other].
     */
    override fun compareTo(other: TrophyChange): Int = rawInt.compareTo(other.rawInt)

    /**
     * Returns the string representation of the trophy delta.
     *
     * @return The trophy delta as a string.
     */
    override fun toString(): String = rawInt.toString()
}

/**
 * Returns `true` if trophies were gained.
 */
public val TrophyChange.isGained: Boolean
    get() = rawInt > 0

/**
 * Returns `true` if trophies were lost.
 */
public val TrophyChange.isLost: Boolean
    get() = rawInt < 0

/**
 * Returns `true` if the trophy count remained unchanged.
 */
public val TrophyChange.isUnchanged: Boolean
    get() = rawInt == 0
