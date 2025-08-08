package com.y9vad9.krawl.brawler

/**
 * Represents a Gear owned or known by a player in Brawl Stars.
 *
 * Gears are passive abilities that enhance a brawler's performance in specific ways,
 * such as increasing healing, movement speed, or resistance. Each gear has a unique [id]
 * and a human-readable [name].
 *
 * This data class groups these two pieces of gear identity information.
 *
 * @property id The unique identifier of the gear, as defined by [GearId].
 * Useful for internal lookups or API interaction.
 * @property name The display name of the gear, as defined by [GearName].
 * Useful for UI display and comparisons.
 */
public data class Gear(
    public val id: GearId,
    public val name: GearName,
)
