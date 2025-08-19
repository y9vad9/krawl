package com.y9vad9.krawl.brawlify.api.v1.icon

import kotlinx.serialization.Serializable

/**
 * Represents a player profile icon in Brawl Stars.
 *
 * Profile icons are visual identifiers that players can select to
 * customize their in-game appearance. They are unlocked through
 * progression, rewards, or offers.
 *
 * ### Example
 * ```json
 * {
 *   "id": 28000000,
 *   "name": "base1",
 *   "name2": "player_icon_00",
 *   "imageUrl": "https://cdn.brawlify.com/profile-icons/regular/28000000.png",
 *   "brawler": null,
 *   "requiredTotalTrophies": 0,
 *   "sortOrder": 0,
 *   "isReward": false,
 *   "isAvailableForOffers": false
 * }
 * ```
 *
 * @property id Unique identifier for the player icon (Supercell internal ID).
 * @property name Human-readable name of the icon (e.g., "base1").
 * @property name2 Internal or alternative identifier string for the icon.
 * @property imageUrl URL pointing to the icon image asset.
 * @property imageUrl2 URL pointing to the icon image asset.
 *                     Seems to be equal to [imageUrl] for most part.
 * @property brawler Identifier of a brawler if the icon is linked to one, or `null` if not.
 * @property requiredTotalTrophies Number of total trophies required to unlock the icon.
 * @property sortOrder Sort index used for displaying icons in a consistent order.
 * @property isReward Whether this icon is unlocked as a reward (e.g., from progression).
 * @property isAvailableForOffers Whether this icon is available for purchase in shop offers.
 */
@Serializable
public data class BrawlifyPlayerIcon(
    val id: Int,
    val name: String,
    val name2: String,
    val imageUrl: String,
    val imageUrl2: String = imageUrl,
    val brawler: Int?,
    val requiredTotalTrophies: Int,
    val sortOrder: Int,
    val isReward: Boolean,
    val isAvailableForOffers: Boolean,
)
