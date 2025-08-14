package com.y9vad9.krawl.brawlify.common

import kotlin.jvm.JvmInline

/**
 * Represents a single segment of a path, typically used in URLs or file paths.
 *
 * @property rawString The raw string value of the path segment.
 */
@JvmInline
public value class BrawlifyPathSegment(
    public val rawString: String,
)
