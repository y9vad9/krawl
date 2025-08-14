package com.y9vad9.krawl.brawlify.common

import kotlin.jvm.JvmInline

/**
 * Represents a hash field returned by the API.
 *
 * This value class wraps a raw string that serves as a hash or unique identifier,
 * often used to verify or reference specific entities or assets within the API.
 *
 * TODO: Investigate the exact purpose and usage of this hash in Brawlify's API responses.
 *
 * @property rawString The underlying hash string value.
 */
@JvmInline
public value class BrawlifyHash(
    public val rawString: String,
)
