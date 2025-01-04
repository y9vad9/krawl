package com.y9vad9.brawlify.types.events

import com.y9vad9.brawlify.types.events.value.BrawlifyEventEmoji
import com.y9vad9.brawlify.types.events.value.BrawlifyEventName
import com.y9vad9.brawlify.types.maps.BrawlifyMap
import com.y9vad9.brawlstars.types.event.value.EventSlotId
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
public data class BrawlifyEvent(
    val slot: Slot,
    val predicted: Boolean,
    val startTime: Instant,
    val endTime: Instant,
    val map: BrawlifyMap,
) {
    @Serializable
    public data class Slot(
        val id: EventSlotId,
        val name: BrawlifyEventName,
        val emoji: BrawlifyEventEmoji,
        val listAlone: Boolean,
        val hideable: Boolean,
        val hideForSlot: EventSlotId? = null,
    )
}