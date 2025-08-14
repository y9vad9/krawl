package com.y9vad9.krawl.api.v1.brawler

import kotlinx.serialization.Serializable

/**
 * Represents a brawler in Brawl Stars, detailing their abilities and equipment.
 *
 * Brawlers are the playable characters in Brawl Stars, each with unique attributes,
 * gadgets, and star powers that define their playstyle and role in battles.
 *
 * @property id The unique identifier of the brawler.
 * @property name The display name of the brawler.
 * @property starPowers A list of [BrawlerStarPower] objects representing the star powers
 *     available to this brawler. Star powers are passive abilities that enhance a brawler's
 *     performance in various ways.
 * @property gadgets A list of [BrawlerGadget] objects representing the gadgets available
 *     to this brawler. Gadgets are active abilities that provide strategic advantages during
 *     combat.
 */
@Serializable
public data class Brawler(
    val id: Int,
    val name: String,
    val starPowers: List<BrawlerStarPower>,
    val gadgets: List<BrawlerGadget>
)
