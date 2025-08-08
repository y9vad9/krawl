package com.y9vad9.krawl.brawlify.event.map.environment

import com.y9vad9.krawl.brawlify.common.BrawlifyHash
import com.y9vad9.krawl.brawlify.common.BrawlifyPathSegment
import com.y9vad9.krawl.brawlify.common.BrawlifyUrl
import com.y9vad9.krawl.brawlify.event.gamemode.BrawlifyGameModeVersion
import com.y9vad9.krawl.brawlify.event.gamemode.BrawlifyGameModeId
import com.y9vad9.krawl.brawlify.event.gamemode.BrawlifyGameModeName

/**
 * Represents an environment or map setting within the game,
 * associated with a specific game mode.
 *
 * @property id The unique identifier of the game mode environment.
 * @property name The human-readable name of the game mode environment.
 * @property hash A hash string associated with the environment, possibly for integrity or identification.
 * @property path The path segment representing this environment, used in URLs or resource identification.
 * @property version The version number of the environment data.
 * @property imageUrl A URL pointing to an image representing this environment.
 */
public data class BrawlifyMapEnvironment(
    public val id: BrawlifyGameModeId,
    public val name: BrawlifyGameModeName,
    public val hash: BrawlifyHash,
    public val path: BrawlifyPathSegment,
    public val version: BrawlifyGameModeVersion,
    public val imageUrl: BrawlifyUrl,
)
