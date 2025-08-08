package com.y9vad9.krawl.brawlify.brawler.starpower

import com.y9vad9.krawl.brawler.StarPowerId
import com.y9vad9.krawl.brawler.StarPowerName
import com.y9vad9.krawl.brawlify.common.BrawlifyDescription
import com.y9vad9.krawl.brawlify.common.BrawlifyUrl

/**
 * Represents a Star Power ability of a Brawler in Brawlify's data model.
 *
 * Star Powers are special passive abilities that enhance a brawler's capabilities
 * and are typically unlocked after reaching a specific level.
 *
 * @property id Unique identifier of the Star Power.
 * @property name Human-readable name of the Star Power.
 * @property description Text description explaining the effect of the Star Power.
 * @property imageUrl URL pointing to the visual icon of the Star Power.
 * @property isReleased Whether the Star Power is currently available in the game.
 */
public data class BrawlifyBrawlerStarPower(
    public val id: StarPowerId,
    public val name: StarPowerName,
    public val description: BrawlifyDescription,
    public val imageUrl: BrawlifyUrl,
    public val isReleased: Boolean,
)
