package com.y9vad9.krawl.brawlify.api.v1.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a Brawl Stars game mode as provided by the API or community data sources.
 *
 * Each game mode describes a distinct type of battle ruleset, such as "Gem Grab"
 * or "Showdown". It contains both metadata and localized information used to
 * present the mode in clients and external tools.
 *
 * ### Example
 * ```json
 * {
 *   "id": 2,
 *   "scId": 48000000,
 *   "name": "Gem Grab",
 *   "hash": "Gem-Grab",
 *   "scHash": "gemGrab",
 *   "disabled": false,
 *   "color": "#d852ff",
 *   "bgColor": "#9a3df3",
 *   "version": 1,
 *   "title": "3 vs 3",
 *   "tutorial": "Collect Gems that pop out...",
 *   "description": "Collect Gems that pop out...",
 *   "shortDescription": "Grab 10 gems to win",
 *   "sort1": 1,
 *   "sort2": 1,
 *   "link": "https://brawlify.com/gamemodes/detail/Gem-Grab",
 *   "imageUrl": "https://cdn.brawlify.com/game-modes/regular/48000000.png",
 *   "imageUrl2": "https://cdn-old.brawlify.com/gamemode/header/Gem-Grab.png",
 *   "lastActive": null,
 *   "TID": "TID_GAME_MODE_0"
 * }
 * ```
 *
 * @property id Unique identifier for the game mode in community-maintained datasets.
 *              Returns an identifier of the game mode. Most of new events on Brawlify don't
 *              have 'id' field no more.
 * @property scId Supercell internal (CSV) identifier for the game mode.
 * @property name Human-readable name of the game mode (e.g., "Gem Grab").
 * @property hash URL-friendly identifier often used as a slug (e.g., "Gem-Grab").
 * @property scHash Supercell internal string identifier (e.g., "gemGrab").
 * @property disabled Whether the game mode is currently disabled/unavailable.
 * @property color Primary theme color of the game mode (hexadecimal format).
 * @property bgColor Background theme color of the game mode (hexadecimal format).
 * @property version Schema or dataset version of this game mode entry.
 * @property title Display title, typically describing player count or format (e.g., "3 vs 3").
 * @property tutorial Tutorial text shown to players, describing the gameplay objective.
 * @property description Full description of the mode, including objectives and rules.
 * @property shortDescription Concise summary of the mode’s win condition or objective.
 * @property sort1 Primary sort order used for displaying game modes.
 * @property sort2 Secondary sort order used for displaying game modes.
 * @property link External reference link to community resources about this mode.
 * @property imageUrl Primary image URL representing the game mode.
 * @property imageUrl2 Alternative image URL representing a header.
 * @property lastActive Timestamp (ISO-8601) when the game mode was last active, or `null` if unknown.
 * @property tid Translation identifier used by Supercell for localization/other lookups.
 */
@Serializable
public data class BrawlifyGameMode(
    val id: Int? = null,
    val scId: Int,
    val name: String,
    val hash: String,
    val scHash: String,
    val disabled: Boolean,
    val color: String,
    val bgColor: String,
    val version: Int,
    val title: String,
    val tutorial: String,
    val description: String,
    val shortDescription: String,
    val sort1: Int,
    val sort2: Int,
    val link: String,
    val imageUrl: String,
    val imageUrl2: String,
    val lastActive: String? = null,
    @SerialName("TID")
    val tid: String,
) {
    /**
     * An alias to [imageUrl].
     */
    public inline val iconUrl: String get() = imageUrl

    /**
     * An alias to [imageUrl2].
     */
    public inline val headerImageUrl: String get() = imageUrl2
}
