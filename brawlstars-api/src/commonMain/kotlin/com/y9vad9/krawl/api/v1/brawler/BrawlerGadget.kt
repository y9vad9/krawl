package com.y9vad9.krawl.api.v1.brawler

import kotlinx.serialization.Serializable

/**
 * Represents a Gadget equipped by a brawler.
 *
 * @property id The unique numeric identifier for the Gadget (e.g., 23_000_000).
 * @property name The display name of the Gadget as shown in-game.
 */
@Serializable
public data class BrawlerGadget(
    val id: Int,
    val name: String
)
