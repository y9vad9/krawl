package com.y9vad9.bsapi.types.event.value

import com.y9vad9.bsapi.types.ValueConstructor
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class EventSlotId private constructor(public val raw: Int) : Comparable<EventSlotId> {
    public companion object : ValueConstructor<EventSlotId, Int> {
        override fun create(value: Int): Result<EventSlotId> {
            return Result.success(EventSlotId(value))
        }
    }

    override fun compareTo(other: EventSlotId): Int {
        return raw.compareTo(other.raw)
    }
}