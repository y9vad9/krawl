package com.y9vad9.krawl.api.v1.player

import com.y9vad9.krawl.api.v1.brawler.BrawlerGadget
import com.y9vad9.krawl.api.v1.brawler.BrawlerStarPower
import kotlinx.serialization.Serializable

/**
 * Represents a player's specific brawler data in Brawl Stars.
 *
 * This includes the brawler's identity, progression stats, and equipped
 * abilities and items.
 *
 * @property id The unique identifier of the brawler.
 * @property name The display name of the brawler.
 * @property power The current power level of the brawler.
 * @property rank The rank of the brawler, indicating progression.
 * @property trophies The number of trophies currently held with this brawler.
 * @property highestTrophies The highest trophy count ever achieved with this brawler.
 * @property gears The list of gears the player has equipped on this brawler.
 * @property starPowers The list of star powers unlocked and available for this brawler.
 * @property gadgets The list of gadgets unlocked and available for this brawler.
 */
@Serializable
public data class PlayerBrawler(
    val id: Int,
    val name: String,
    val power: Int,
    val rank: Int,
    val trophies: Int,
    val highestTrophies: Int,
    val gears: List<PlayerGear>,
    val starPowers: List<BrawlerStarPower>,
    val gadgets: List<BrawlerGadget>,
)
