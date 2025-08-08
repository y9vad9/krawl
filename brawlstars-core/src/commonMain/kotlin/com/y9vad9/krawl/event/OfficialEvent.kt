package com.y9vad9.krawl.event

/**ts a standard public event from the Brawl Stars battle log.
 *
 * These events are part of official matchmaking and played on Supercell-defined maps
 * and modes, such as Gem Grab or Brawl Ball. This type includes full metadata.
 *
 * @property id Unique event identifier provided by the Brawl Stars API.
 * @property mapName Name of the map used in the match.
 * @property mode Game mode (e.g., Heist, Bounty, Hot Zone).
 */
public data class OfficialEvent(
    public val id: EventId,
    public val mapName: MapName,
    public val mode: EventMode,
) : Event
