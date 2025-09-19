package com.y9vad9.krawl.brawlify.api.v1.brawler

import kotlinx.serialization.Serializable

/**
 * Represents the class of a brawler, e.g., Damage Dealer.
 *
 * @property id Unique identifier for the class.
 * @property name Name of the class.
 */
@Serializable
public data class RawBrawlifyBrawlerClass(
    val id: Int,
    val name: String,
)
