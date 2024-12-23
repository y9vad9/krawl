package com.y9vad9.bsapi.types.event.value

import com.y9vad9.bsapi.types.ValueConstructor
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

@Serializable
@JvmInline
public value class Seconds private constructor(public val raw: Int) : Comparable<Seconds> {
    public companion object : ValueConstructor<Seconds, Int> {
        override fun create(value: Int): Result<Seconds> {
            return Result.success(Seconds(value))
        }
    }

    override fun compareTo(other: Seconds): Int {
        return raw.compareTo(other.raw)
    }
}

public fun Seconds.toDuration(): Duration {
    return raw.seconds
}