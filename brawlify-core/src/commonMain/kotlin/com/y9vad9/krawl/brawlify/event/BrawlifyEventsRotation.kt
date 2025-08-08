package com.y9vad9.krawl.brawlify.event

/**
 * Represents a rotation of Brawlify events, including both currently active and upcoming ones.
 *
 * @property active The list of [BrawlifyEvent]s that are currently live in the game.
 * @property upcoming The list of [BrawlifyEvent]s that are scheduled to appear next.
 */
public data class BrawlifyEventsRotation(
    public val active: List<BrawlifyEvent>,
    public val upcoming: List<BrawlifyEvent>,
)
