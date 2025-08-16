package com.y9vad9.krawl.brawlify.common

import kotlin.jvm.JvmInline

/**
 * Represents an internal Supercell identifier used in Brawlify metadata.
 *
 * This ID likely maps to a backend representation of a Brawler, map, or event
 * in Supercell's internal systems. It is typically not displayed directly to end users.
 *
 * @property rawInt Raw integer value of the Supercell ID.
 *
 * TODO: Verify the exact purpose and scope of this identifier.
 */
@JvmInline
public value class BrawlStarsCSVId(
    public val rawInt: Int,
)
