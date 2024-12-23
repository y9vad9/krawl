package com.y9vad9.bsapi.types.brawler.value

import com.y9vad9.bsapi.types.ValueConstructor
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
public value class StarPowerId private constructor(public val value: Int) : Comparable<StarPowerId> {
    public companion object : ValueConstructor<StarPowerId, Int> {
        override fun create(value: Int): Result<StarPowerId> {
            return Result.success(StarPowerId(value))
        }
    }

    override fun compareTo(other: StarPowerId): Int {
        return value.compareTo(other.value)
    }
}