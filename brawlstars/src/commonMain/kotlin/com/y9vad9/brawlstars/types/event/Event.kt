package com.y9vad9.brawlstars.types.event

import com.y9vad9.brawlstars.types.event.value.*
import kotlinx.serialization.Serializable

@Serializable
public data class Event(
    /**
     * Event's mode (brawl ball, etc). Might be null,
     * if it's
     */
    val mode: EventMode? = null,
    val id: EventId,
    // if community map or it's a friendly match
    val map: MapName? = null,
    val modifiers: List<EventModifier>? = null,
)

public val Event.isWithoutModifiers: Boolean
    get() = modifiers.isNullOrEmpty() || modifiers.singleOrNull() == EventModifier.NONE

public val Event.isOfficial: Boolean get() = id.isPublic && mode != null && map != null