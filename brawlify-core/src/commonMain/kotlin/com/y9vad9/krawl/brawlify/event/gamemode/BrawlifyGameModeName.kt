package com.y9vad9.krawl.brawlify.event.gamemode

import com.y9vad9.krawl.brawlify.event.map.environment.BrawlifyMapEnvironmentName
import kotlin.jvm.JvmInline

/**
 * Represents a human-readable name of a game mode.
 *
 * @property rawString The raw string value of the environment name.
 */
@JvmInline
public value class BrawlifyGameModeName(
    public val rawString: String,
) : Comparable<BrawlifyMapEnvironmentName> {

    override fun compareTo(other: BrawlifyMapEnvironmentName): Int =
        rawString.compareTo(other.rawString)

    override fun toString(): String = rawString
}
