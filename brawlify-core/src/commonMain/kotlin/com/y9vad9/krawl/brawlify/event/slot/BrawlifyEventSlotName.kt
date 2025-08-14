package com.y9vad9.krawl.brawlify.event.slot

import kotlin.jvm.JvmInline

/**
 * Represents the name of an event slot within the game events screen.
 *
 * This value class encapsulates the raw string identifier used to denote
 * specific slots or positions related to game events on maps.
 *
 * @property rawString The raw string value of the event slot name.
 */
@JvmInline
public value class BrawlifyEventSlotName(
    public val rawString: String,
)
