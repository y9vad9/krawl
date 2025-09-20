package com.y9vad9.krawl.brawlify.common

import com.y9vad9.krawl.brawlify.BrawlifyUrl
import java.net.URI
import java.net.URL

/**
 * Converts this [com.y9vad9.krawl.brawlify.BrawlifyUrl] into a [URI] instance using the underlying
 * [com.y9vad9.krawl.brawlify.BrawlifyUrl.rawString].
 *
 * This is useful when working with Java APIs that require [URI], or for validation purposes.
 *
 * @return a [URI] created from the raw string of this URL.
 */
public fun BrawlifyUrl.toJavaURI(): URI = URI.create(rawString)

/**
 * Converts this [BrawlifyUrl] into a [URL] instance via its [URI] representation.
 *
 * This method first converts the underlying string into a [URI], then to a [URL].
 * It provides better validation than directly using [URL]'s constructor.
 *
 * @return a [URL] created from this Brawlify URL.
 */
public fun BrawlifyUrl.toJavaURL(): URL = toJavaURI().toURL()
