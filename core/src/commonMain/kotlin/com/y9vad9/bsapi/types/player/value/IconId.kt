package com.y9vad9.bsapi.types.player.value

import com.y9vad9.bsapi.types.ValueConstructor
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class IconId private constructor(public val raw: Int) : Comparable<IconId> {
    public companion object : ValueConstructor<IconId, Int> {
        override fun create(value: Int): Result<IconId> {
            return Result.success(IconId(value))
        }
    }

    override fun compareTo(other: IconId): Int {
        return raw.compareTo(other.raw)
    }
}