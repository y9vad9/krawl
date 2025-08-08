package com.y9vad9.krawl.brawlify.brawler.rarity

/**
 * Represents the rarity classification of a Brawler in Brawlify's data model.
 *
 * Rarity indicates how difficult a brawler is to obtain, ranging from common
 * to ultra legendary and special rarities.
 *
 * @property id Unique identifier for the rarity type.
 * @property name Human-readable name of the rarity (e.g., "Epic", "Mythic").
 */
public data class BrawlifyBrawlerRarity(
    public val id: BrawlifyBrawlerRarityId,
    public val name: BrawlifyBrawlerRarityName,
)
