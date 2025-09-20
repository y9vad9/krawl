package com.y9vad9.krawl.brawlify.api.v1.event

import com.y9vad9.krawl.brawlify.api.v1.event.statistics.RawBrawlifyMapBrawlerStatistics
import com.y9vad9.krawl.brawlify.api.v1.event.statistics.RawBrawlifyMapTeamStatistics
import kotlinx.serialization.Serializable

/**
 * Represents a playable map in Brawl Stars.
 *
 * A map defines the arena layout for a given game mode, with metadata such as
 * its name, version, associated environment, and available statistics.
 *
 * ### Example
 * ```json
 * {
 *   "id": 15000013,
 *   "new": false,
 *   "disabled": false,
 *   "name": "Skull Creek",
 *   "hash": "Skull-Creek",
 *   "version": 1,
 *   "link": "https://brawlify.com/maps/detail/Skull-Creek",
 *   "imageUrl": "https://cdn.brawlify.com/maps/regular/15000013.png",
 *   "credit": null,
 *   "environment": { ... },
 *   "gameMode": { ... },
 *   "lastActive": 1728072000,
 *   "dataUpdated": 1728072000,
 *   "stats": [ { ... } ],
 *   "teamStats": [ { ... } ]
 * }
 * ```
 *
 * @property id Unique map identifier.
 * @property new Whether the map is newly introduced.
 * @property disabled Whether the map is currently disabled.
 * @property name Display name of the map (e.g. "Skull Creek").
 * @property hash Unique string hash identifier of the map.
 * @property version Schema version of the map.
 * @property link Brawlify link with detailed information.
 * @property imageUrl URL to the map preview image.
 * @property credit Optional creator credit for community maps.
 * @property environment The environment (theme) this map uses.
 * @property gameMode The game mode played on this map.
 * @property lastActive Epoch timestamp (seconds) of when the map was last active.
 * @property dataUpdated Epoch timestamp (seconds) when the stats were last updated.
 * @property stats List of single-brawler statistics for this map.
 * @property teamStats List of team-based statistics for this map.
 */
@Serializable
public data class RawBrawlifyMap(
    val id: Int,
    val new: Boolean,
    val disabled: Boolean,
    val name: String,
    val hash: String,
    val version: Int,
    val link: String,
    val imageUrl: String,
    val credit: String? = null,
    val environment: RawBrawlifyMapEnvironment,
    val gameMode: RawBrawlifyGameModeView,
    val lastActive: Long? = null,
    val dataUpdated: Long? = null,
    val stats: List<RawBrawlifyMapBrawlerStatistics> = emptyList(),
    val teamStats: List<RawBrawlifyMapTeamStatistics> = emptyList(),
)
