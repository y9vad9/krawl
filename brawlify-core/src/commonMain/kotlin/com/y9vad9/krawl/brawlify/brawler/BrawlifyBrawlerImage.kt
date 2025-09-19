package com.y9vad9.krawl.brawlify.brawler

import com.y9vad9.krawl.brawlify.BrawlifyUrl

/**
 * Represents the set of Brawlify-hosted images used to visually identify a Brawler.
 *
 * This includes different visual formats of a Brawler's icon, typically used in UI displays:
 *
 * - [border]: Image with decorative borders, typically used in detailed views.
 * - [borderless]: Clean icon without borders, suitable for compact or embedded usage.
 * - [emoji]: Emoji-style icon, often used in chat or lightweight representations.
 *
 * All images are hosted by Brawlify and are represented as validated [BrawlifyUrl]s.
 *
 * @property border Brawler icon image with a decorative border.
 * @property borderless Brawler icon image without a border.
 * @property emoji Emoji-style image representation of the Brawler.
 */
public data class BrawlifyBrawlerImage(
    public val border: BrawlifyUrl,
    public val borderless: BrawlifyUrl,
    public val emoji: BrawlifyUrl,
)
