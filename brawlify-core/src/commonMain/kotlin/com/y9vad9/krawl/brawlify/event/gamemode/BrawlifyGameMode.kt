package com.y9vad9.krawl.brawlify.event.gamemode

import com.y9vad9.krawl.brawlify.common.BrawlifyHash

/**
 * Represents a game mode within Brawl Stars.
 *
 * @property id The unique identifier for the game mode.
 * @property name The human-readable name of the game mode.
 * @property hash A hash string associated with the game mode, used for identification or integrity checks.
 * @property version The version number of the game mode data.
 * @property color The associated color theme for this game mode, used for UI or representation.
 * @property link A reference link providing additional information about the game mode.
 */
public data class BrawlifyGameMode(
    public val id: BrawlifyGameModeId,
    public val name: BrawlifyGameModeName,
    public val hash: BrawlifyHash,
    public val version: BrawlifyGameModeVersion,
    public val color: BrawlifyGameModeColor,
    public val link: GameModeLink,
)
