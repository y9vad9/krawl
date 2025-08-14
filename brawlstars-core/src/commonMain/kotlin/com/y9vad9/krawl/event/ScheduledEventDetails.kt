package com.y9vad9.krawl.event

/**
 * Event details from the Brawl Stars event rotation.
 *
 * These events are part of official matchmaking and played on Supercell-defined maps
 * and modes, such as Gem Grab or Brawl Ball. This type includes full metadata.
 *
 * @property id Unique event identifier provided by the Brawl Stars API.
 * @property mapName Name of the map used in the match.
 * @property mode Game mode (e.g., Heist, Bounty, Hot Zone).
 * @property modifiers List of modifiers applied to a battle.
 */
public data class ScheduledEventDetails(
    public val id: EventId,
    public val mapName: MapName,
    public val mode: EventMode,
    public val modifiers: EventModifiers,
) : Event
