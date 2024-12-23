package com.y9vad9.bsapi.types.brawler.value

import com.y9vad9.bsapi.types.ValueConstructor
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class GadgetId private constructor(public val raw: Int) : Comparable<GadgetId> {
    public companion object : ValueConstructor<GadgetId, Int> {
        override fun create(value: Int): Result<GadgetId> {
            return Result.success(GadgetId(value))
        }
    }

    override fun compareTo(other: GadgetId): Int {
        return raw.compareTo(other.raw)
    }
}