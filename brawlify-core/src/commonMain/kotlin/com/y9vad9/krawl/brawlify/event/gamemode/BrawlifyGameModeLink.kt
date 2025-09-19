package com.y9vad9.krawl.brawlify.event.gamemode

import com.y9vad9.krawl.brawlify.BrawlifyUrl

/**
 * Represents links related to a game mode.
 *
 * @property details A URL linking to detailed information about the game mode.
 * @property image A URL linking to an image representing the game mode.
 */
public data class BrawlifyGameModeLink(
    public val details: BrawlifyUrl,
    public val image: BrawlifyUrl,
)
