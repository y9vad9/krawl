package com.y9vad9.krawl.brawlify.api.v1.event

import kotlinx.serialization.Serializable

/**
 * Lightweight representation of a game mode.
 *
 * Example json:
 * ```json
 * {
 *   "id": 15000000,
 *   "new": false,
 *   "disabled": true,
 *   "name": "Temple Ruins",
 *   "hash": "Temple-Ruins",
 *   "version": 1,
 *   "link": "https://brawlify.com/maps/detail/Temple-Ruins",
 *   "imageUrl": "https://cdn.brawlify.com/maps/regular/15000000.png",
 *   "credit": null,
 *   "environment": {
 *     "id": 1,
 *     "scId": 47000015,
 *     "name": "Default",
 *     "hash": "event_canyon_banner",
 *     "path": "Default",
 *     "version": 1,
 *     "imageUrl": "https://cdn-misc.brawlify.com/gamemode/header/Bounty.png"
 *   },
 *   "gameMode": {
 *     "id": 1,
 *     "scId": 48000003,
 *     "name": "Bounty",
 *     "hash": "Bounty",
 *     "version": 1,
 *     "color": "#24d6ff",
 *     "bgColor": "#00cfff",
 *     "link": "https://brawlify.com/gamemodes/detail/Bounty",
 *     "imageUrl": "https://cdn.brawlify.com/game-modes/regular/48000003.png"
 *   },
 *   "lastActive": null,
 *   "dataUpdated": 1755469613,
 *   "stats": [
 *     {
 *       "brawler": 16000024,
 *       "winRate": 52.1,
 *       "useRate": 0.4
 *     },
 *     ...
 *   ],
 *   "teamStats": []
 * }
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
public data class BrawlifyGameModeView(
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
