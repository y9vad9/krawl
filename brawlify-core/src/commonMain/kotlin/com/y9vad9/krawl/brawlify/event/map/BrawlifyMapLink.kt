package com.y9vad9.krawl.brawlify.event.map

import com.y9vad9.krawl.brawlify.common.BrawlifyUrl

/**
 * Represents external Brawlify links related to a specific Brawl Stars map.
 *
 * This includes both a direct image link of the map and a link to the map's detail page
 * on the Brawlify website, which may include additional metadata such as game mode,
 * environment, rotation, and creator.
 *
 * @property image A [BrawlifyUrl] pointing to the rendered image of the map.
 * @property details A [BrawlifyUrl] pointing to the map’s detail page on brawlify.com.
 */
public data class BrawlifyMapLink(
    public val image: BrawlifyUrl,
    public val details: BrawlifyUrl,
)
