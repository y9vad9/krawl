package com.y9vad9.bsapi.types.brawler.value

import com.y9vad9.bsapi.types.ValueConstructor
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
public value class GearId private constructor(public val raw: Int) : Comparable<GearId> {
    public companion object : ValueConstructor<GearId, Int> {
        override fun create(value: Int): Result<GearId> {
            return Result.success(GearId(value))
        }
    }

    override fun compareTo(other: GearId): Int {
        return raw.compareTo(other.raw)
    }
}