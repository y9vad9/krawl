package com.y9vad9.krawl.brawler

/**
 * Represents a Brawler in Brawl Stars.
 *
 * Contains all relevant data about a specific brawler, including identifiers,
 * progression stats, and available equipment or abilities.
 *
 * @property id The unique identifier of the brawler.
 * @property name The display name of the brawler.
 * @property level The current power level of the brawler.
 * @property rank The current rank of the brawler.
 * @property trophies The trophy counts associated with this brawler.
 * @property gadgets The list of gadgets unlocked or equipped by the brawler.
 * @property gears The list of gears the brawler has equipped.
 * @property starPowers The list of star powers unlocked for the brawler.
 */
public data class Brawler(
    public val id: BrawlerId,
    public val name: BrawlerName,
    public val level: BrawlerPowerLevel,
    public val rank: BrawlerRank,
    public val trophies: BrawlerTrophies,
    public val gadgets: List<Gadget>,
    public val gears: List<Gear>,
    public val starPowers: List<StarPower>,
)
