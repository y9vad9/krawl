package com.y9vad9.krawl.brawlify.api.v1.brawler

import kotlinx.serialization.Serializable

/**
 * Represents a gadget of a brawler.
 *
 * @property id Unique identifier for the gadget.
 * @property name Name of the gadget.
 * @property path Internal path identifier.
 * @property version Schema version.
 * @property description Plain text description of the gadget.
 * @property descriptionHtml HTML-formatted description of the gadget.
 * @property imageUrl Image URL for the gadget.
 * @property released Whether the gadget has been released.
 */
@Serializable
public data class RawBrawlifyBrawlerGadget(
    val id: Int,
    val name: String,
    val path: String,
    val version: Int,
    val description: String,
    val descriptionHtml: String,
    val imageUrl: String,
    val released: Boolean,
)
