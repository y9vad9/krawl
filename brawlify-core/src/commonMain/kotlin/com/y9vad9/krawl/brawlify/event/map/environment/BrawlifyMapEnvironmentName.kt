package com.y9vad9.krawl.brawlify.event.map.environment

import com.y9vad9.krawl.brawlify.event.gamemode.BrawlifyGameModeName
import kotlin.jvm.JvmInline

/**
 * Represents a human-readable name of a Brawlify map environment.
 *
 * @property rawString The raw string value of the environment name.
 */
@JvmInline
public value class BrawlifyMapEnvironmentName(
    public val rawString: String,
) : Comparable<BrawlifyGameModeName> {

    override fun compareTo(other: BrawlifyGameModeName): Int =
        rawString.compareTo(other.rawString)

    override fun toString(): String = rawString
}
