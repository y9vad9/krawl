package com.y9vad9.krawl.brawlify.event

import com.y9vad9.krawl.brawlify.event.map.BrawlifyMap
import com.y9vad9.krawl.brawlify.event.slot.BrawlifyEventSlot
import kotlin.time.Instant

/**
 * Represents an event in Brawl Stars with detailed scheduling and location information.
 *
 * @property slot The event slot describing the category or type of this event.
 * @property timeline The inclusive time range during which this event is active.
 * @property map The map where the event takes place.
 * @property isPredicted Indicates if the event was predicted.
 */
public data class BrawlifyEvent(
    public val slot: BrawlifyEventSlot,
    public val timeline: ClosedRange<Instant>,
    public val map: BrawlifyMap,
    public val isPredicted: Boolean,
) {
    /**
     * The start time of the event, derived from [timeline].
     */
    public val startTime: Instant get() = timeline.start

    /**
     * The end time of the event, derived from [timeline].
     */
    public val endTime: Instant get() = timeline.endInclusive
}
