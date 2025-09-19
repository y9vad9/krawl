package com.y9vad9.krawl.brawlify.api.v1.event

import kotlinx.serialization.Serializable

/**
 * Represents a map environment in Brawl Stars.
 *
 * Environments define the visual theme and setting applied to
 * maps and game modes, such as Showdown deserts, Gem Grab mines,
 * or special event arenas. They include identifiers, assets, and
 * metadata for rendering.
 *
 * ### Example
 * ```json
 * {
 *   "id": 6,
 *   "name": "Defaultshowdown",
 *   "hash": "event_stormvalley_banner",
 *   "path": "Defaultshowdown",
 *   "version": 1,
 *   "imageUrl": "https://cdn-old.brawlify.com/gamemode/header/Solo-Showdown.png"
 * }
 * ```
 *
 * @property id Unique identifier for the environment (Supercell internal ID).
 * @property scId Unique identifier in internal game files.
 * @property name Human-readable name of the environment (e.g., "Defaultshowdown").
 * @property hash Internal hashed identifier string used by Supercell assets.
 * @property path Path or folder name used for the environment's asset references.
 * @property version Version number of the environment definition (incremented when updated).
 * @property imageUrl URL pointing to the environment’s preview/banner image.
 */
@Serializable
public data class RawBrawlifyMapEnvironment(
    val id: Int,
    val scId: Int,
    val name: String,
    val hash: String,
    val path: String,
    val version: Int,
    val imageUrl: String,
)
