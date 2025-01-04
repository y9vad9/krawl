package com.y9vad9.brawlstars.types.event

import com.y9vad9.brawlstars.internal.InstantInternalSerializer
import com.y9vad9.brawlstars.types.event.value.EventSlotId
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
public data class ScheduledEvent(
    @Serializable(with = InstantInternalSerializer::class)
    val startTime: Instant,
    @Serializable(with = InstantInternalSerializer::class)
    val endTime: Instant,
    val slotId: EventSlotId,
    val event: Event,
)