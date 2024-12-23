package com.y9vad9.brawlifyapi.types.events

import com.y9vad9.brawlifyapi.types.events.value.BrawlifyEventEmoji
import com.y9vad9.brawlifyapi.types.maps.BrawlifyMap
import com.y9vad9.bsapi.types.event.value.EventId
import com.y9vad9.bsapi.types.event.value.EventSlotId
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
        val name: EventId,
        val emoji: BrawlifyEventEmoji,
        val listAlone: Boolean,
        val hideable: Boolean,
        val hideForSlot: EventSlotId,
    )
}