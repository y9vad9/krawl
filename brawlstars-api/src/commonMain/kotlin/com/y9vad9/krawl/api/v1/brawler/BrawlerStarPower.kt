package com.y9vad9.krawl.api.v1.brawler

import kotlinx.serialization.Serializable

/**
 * Represents a brawler's Star Power.
 *
 * @property id The numeric ID of the Star Power (e.g., 23000000).
 * @property name The human-readable name of the Star Power.
 */
@Serializable
public data class BrawlerStarPower(
    val id: Int,
    val name: String
)
