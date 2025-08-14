package com.y9vad9.krawl.brawlify.common

import kotlin.jvm.JvmInline

/**
 * Represents a regular description string used in Brawlify metadata.
 *
 * @property rawString The raw string containing the description.
 */
@JvmInline
public value class BrawlifyRegularDescription(
    public val rawString: String,
)
