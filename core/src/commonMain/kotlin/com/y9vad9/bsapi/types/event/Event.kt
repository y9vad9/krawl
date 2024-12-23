package com.y9vad9.bsapi.types.event

import com.y9vad9.bsapi.types.event.value.EventId
import com.y9vad9.bsapi.types.event.value.EventMode
import com.y9vad9.bsapi.types.event.value.EventModifier
import com.y9vad9.bsapi.types.event.value.MapName
import kotlinx.serialization.Serializable

@Serializable
public data class Event(
    val mode: EventMode,
    val id: EventId,
    val map: MapName,
    val modifiers: List<EventModifier>? = null,
)

public val Event.isWithoutModifiers: Boolean
    get() = modifiers.isNullOrEmpty() || modifiers.singleOrNull() == EventModifier.NONE
