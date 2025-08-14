package com.y9vad9.krawl.brawler

import kotlin.jvm.JvmInline

/**
 * Represents the name of a Gear in Brawl Stars.
 *
 * Gears provide passive abilities to brawlers, and each gear has a display name.
 * This value class wraps a [String] and enforces strong typing for gear names,
 * enabling safer APIs and better domain modeling.
 *
 * Instances of [GearName] can be compared lexicographically.
 *
 * @property string The raw name string of the gear.
 */
@JvmInline
public value class GearName(
    /**
     * The raw name string of the gear.
     */
    public val string: String,
) : Comparable<GearName> {

    /**
     * Compares this [GearName] with another [GearName] based on lexicographic order
     * of their underlying [string] values.
     *
     * @param other The other gear name to compare to.
     * @return A negative integer, zero, or a positive integer as this name is
     * less than, equal to, or greater than the other.
     */
    override fun compareTo(other: GearName): Int = string.compareTo(other.string)

    /**
     * Returns the string representation of the gear name.
     *
     * @return The raw name string.
     */
    override fun toString(): String = string
}
