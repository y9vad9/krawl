package com.y9vad9.krawl.brawlify.api.v1.brawler

import kotlinx.serialization.Serializable

/**
 * Represents a star power of a brawler.
 *
 * @property id Unique identifier for the star power.
 * @property name Name of the star power.
 * @property path Internal path identifier.
 * @property version Schema version.
 * @property description Plain text description of the star power.
 * @property descriptionHtml HTML-formatted description of the star power.
 * @property imageUrl Image URL for the star power.
 * @property released Whether the star power has been released.
 */
@Serializable
public data class BrawlifyStarPower(
    val id: Int,
    val name: String,
    val path: String,
    val version: Int,
    val description: String,
    val descriptionHtml: String,
    val imageUrl: String,
    val released: Boolean,
)
