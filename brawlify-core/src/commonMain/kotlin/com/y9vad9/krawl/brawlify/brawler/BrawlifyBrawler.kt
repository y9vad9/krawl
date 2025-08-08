package com.y9vad9.krawl.brawlify.brawler

import com.y9vad9.krawl.brawler.BrawlerId
import com.y9vad9.krawl.brawler.BrawlerName
import com.y9vad9.krawl.brawlify.brawler.classification.BrawlifyBrawlerClass
import com.y9vad9.krawl.brawlify.brawler.gadget.BrawlifyBrawlerGadget
import com.y9vad9.krawl.brawlify.brawler.rarity.BrawlifyBrawlerRarity
import com.y9vad9.krawl.brawlify.brawler.starpower.BrawlifyBrawlerStarPower
import com.y9vad9.krawl.brawlify.common.BrawlifyDescription

/**
 * Represents a Brawler entity in the Brawlify data model.
 *
 * This model encapsulates core information about a specific Brawler, including metadata,
 * classification, availability, and available abilities (Gadgets and Star Powers).
 *
 * @property id Unique identifier of the Brawler.
 * @property name Display name of the Brawler.
 * @property isReleased Indicates whether the Brawler is currently released in the game.
 * @property description Description or lore text about the Brawler.
 * @property image Image asset representing the Brawler, typically used in UI or thumbnails.
 * @property classification Gameplay class of the Brawler (e.g., Damage Dealer, Support).
 * @property rarity Rarity level of the Brawler, used to convey how difficult it is to unlock.
 * @property gadgets List of gadgets available for this Brawler, each representing an active ability.
 * @property starPowers List of star powers available for this Brawler, representing passive abilities.
 */
public data class BrawlifyBrawler(
    public val id: BrawlerId,
    public val name: BrawlerName,
    public val isReleased: Boolean,
    public val description: BrawlifyDescription,
    public val image: BrawlerImage,
    public val classification: BrawlifyBrawlerClass,
    public val rarity: BrawlifyBrawlerRarity,
    public val gadgets: List<BrawlifyBrawlerGadget>,
    public val starPowers: List<BrawlifyBrawlerStarPower>,
)
