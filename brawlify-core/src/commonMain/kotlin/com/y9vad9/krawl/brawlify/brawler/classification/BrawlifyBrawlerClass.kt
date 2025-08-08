package com.y9vad9.krawl.brawlify.brawler.classification

/**
 * Represents a brawler class in Brawlify's data model.
 *
 * A brawler class groups brawlers by shared roles or attributes, such as "Assassin", "Tank", or "Support".
 * This class contains a unique identifier and a display name for the class.
 *
 * @property id Unique identifier for the brawler class.
 * @property name Human-readable name of the brawler class.
 */
public data class BrawlifyBrawlerClass(
    public val id: BrawlifyBrawlerClassId,
    public val name: BrawlifyBrawlerClassName,
)
