package com.y9vad9.krawl.brawler

import kotlin.jvm.JvmInline

/**
 * Represents the name of a Star Power in Brawl Stars.
 *
 * This inline value class wraps a [String] value to provide type safety and
 * lexicographic comparability between star power names.
 *
 * Star Powers are unique passive abilities unlocked for brawlers, and each has a
 * distinctive name which is represented by this class.
 *
 * @property string The raw string value of the star power's name. Used for display and comparison.
 */
@JvmInline
public value class StarPowerName(
    public val string: String
) : Comparable<StarPowerName> {

    /**
     * Compares this [StarPowerName] with [other] based on the lexicographic order of the underlying [string].
     *
     * @param other The other star power name to compare against.
     * @return A negative integer, zero, or a positive integer as this name is less than, equal to,
     * or greater than [other].
     */
    override fun compareTo(other: StarPowerName): Int = string.compareTo(other.string)

    /**
     * Returns the raw string representation of the star power name.
     */
    override fun toString(): String = string
}
