package com.y9vad9.brawlstars.types.event.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class EventSlotId private constructor(public val raw: Int) : Comparable<EventSlotId> {
    public companion object : ValueFactory<EventSlotId, Int> by factory(
        constructor = ::EventSlotId,
    )

    override fun compareTo(other: EventSlotId): Int {
        return raw.compareTo(other.raw)
    }
}