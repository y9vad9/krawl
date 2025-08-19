package com.y9vad9.krawl.brawlify.api.v1.brawler

import kotlinx.serialization.Serializable

/**
 * Represents the rarity of a brawler.
 *
 * @property id Unique identifier for the rarity.
 * @property name Name of the rarity (e.g., "Common").
 * @property color Hex color representing the rarity visually.
 */
@Serializable
public data class BrawlifyBrawlerRarity(
    val id: Int,
    val name: String,
    val color: String,
)
