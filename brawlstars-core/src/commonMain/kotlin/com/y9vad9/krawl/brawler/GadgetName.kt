package com.y9vad9.krawl.brawler

/**
 * Represents a Brawler Gadget's name.
 *
 * This inline value class wraps a [String] and allows for lexicographic comparison
 * between brawler names. Useful for sorting or ensuring type safety across the domain.
 *
 * Instances are compared based on the wrapped string value.
 */
@JvmInline
public value class GadgetName(
    /** The raw string value of the gadget's name. */
    public val string: String,
) : Comparable<GadgetName> {

    /**
     * Compares this [GadgetName] with [other] based on lexicographic order of the underlying [string].
     */
    override fun compareTo(other: GadgetName): Int = string.compareTo(other.string)

    /**
     * Returns the string representation of the gadget name.
     */
    override fun toString(): String = string
}
