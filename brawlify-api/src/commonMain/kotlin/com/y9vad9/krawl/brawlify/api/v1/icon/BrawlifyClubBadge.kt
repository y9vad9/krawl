package com.y9vad9.krawl.brawlify.api.v1.icon

import kotlinx.serialization.Serializable

/**
 * Represents a club badge in Brawl Stars.
 *
 * Club badges are visual emblems used by clubs to represent themselves.
 * Each badge has an associated image and a unique identifier.
 *
 * ### Example
 * ```json
 * {
 *   "id": 8000000,
 *   "imageUrl": "https://cdn.brawlify.com/club-badges/regular/8000000.png"
 * }
 * ```
 *
 * @property id Unique identifier for the club badge (Supercell internal ID).
 * @property imageUrl URL pointing to the badge image asset.
 */
@Serializable
public data class BrawlifyClubBadge(
    val id: Int,
    val imageUrl: String,
)
