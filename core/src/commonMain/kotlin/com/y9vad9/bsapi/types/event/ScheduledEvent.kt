package com.y9vad9.bsapi.types.event

import com.y9vad9.bsapi.types.event.value.EventSlotId
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
public data class ScheduledEvent(
    val startTime: Instant,
    val endTime: Instant,
    val slotId: EventSlotId,
    val event: Event,
)