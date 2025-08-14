package com.y9vad9.krawl.brawler

import kotlin.jvm.JvmInline

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
    public val rawString: String,
) : Comparable<GadgetName> {

    /**
     * Compares this [GadgetName] with [other] based on lexicographic order of the underlying [rawString].
     */
    override fun compareTo(other: GadgetName): Int = rawString.compareTo(other.rawString)

    /**
     * Returns the string representation of the gadget name.
     */
    override fun toString(): String = rawString
}
