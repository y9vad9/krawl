package com.y9vad9.krawl.brawlify.api.v1.event

import kotlinx.serialization.Serializable

/**
 * Lightweight representation of a game mode.
 *
 * Example json:
 * ```json
 * {
 *       "id": 2,
 *       "scId": 48000000,
 *       "name": "Gem Grab",
 *       "hash": "Gem-Grab",
 *       "scHash": "gemGrab",
 *       "disabled": false,
 *       "color": "#d852ff",
 *       "bgColor": "#9a3df3",
 *       "version": 1,
 *       "title": "3 vs 3",
 *       "tutorial": "...",
 *       "description": "...",
 *       "shortDescription": "Grab 10 gems to win",
 *       "sort1": 1,
 *       "sort2": 1,
 *       "link": "https://brawlify.com/gamemodes/detail/Gem-Grab",
 *       "imageUrl": "https://cdn.brawlify.com/game-modes/regular/48000000.png",
 *       "imageUrl2": "https://cdn-misc.brawlify.com/gamemode/header/Gem-Grab.png",
 *       "lastActive": null,
 *       "TID": "TID_GAME_MODE_0"
 *     }
 * ```
 *
 * @property id Unique identifier for the game mode in community-maintained datasets.
 *              Returns an identifier of the game mode. Most of new events on Brawlify don't
 *              have 'id' field no more.
 * @property scId Supercell's internal CSV identifier for the mode.
 * @property name Display name of the mode (e.g., "Bounty").
 * @property hash Unique hash identifier for the mode.
 * @property version Schema version for this object.
 * @property color Hex color associated with game mode.
 * @property bgColor Hex background color associated with game mode.
 * @property link Link to the Brawlify page about this game mode.
 * @property imageUrl Link to the image on Public CDN representing game mode.
 */
@Serializable
public data class RawBrawlifyGameModeView(
    val id: Int? = null,
    val scId: Int,
    val name: String,
    val hash: String,
    val version: Int,
    val color: String,
    val bgColor: String,
    val link: String,
    val imageUrl: String,
)
