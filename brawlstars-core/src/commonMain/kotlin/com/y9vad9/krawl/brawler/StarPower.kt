package com.y9vad9.krawl.brawler

/**
 * Represents a Star Power in Brawl Stars.
 *
 * This data class holds the [id] and [name] of a specific Star Power,
 * providing type safety and structure to star power-related domain logic.
 *
 * @property id The unique identifier of the Star Power.
 * @property name The display name of the Star Power.
 */
public data class StarPower(
    public val id: StarPowerId,
    public val name: StarPowerName,
)
