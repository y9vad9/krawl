package com.y9vad9.bsapi.types.event.value

import com.y9vad9.bsapi.types.ValueConstructor
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
public value class EventId private constructor(public val raw: Int) : Comparable<EventId> {
    public companion object : ValueConstructor<EventId, Int> {
        override fun create(value: Int): Result<EventId> {
            return Result.success(EventId(value))
        }
    }

    override fun compareTo(other: EventId): Int {
        return raw.compareTo(other.raw)
    }
}