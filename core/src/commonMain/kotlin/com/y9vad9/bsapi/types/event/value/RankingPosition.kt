package com.y9vad9.bsapi.types.event.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class RankingPosition private constructor(public val value: Int) : Comparable<RankingPosition> {
    public companion object : ValueConstructor<RankingPosition, Int> {
        override fun create(value: Int): Result<RankingPosition> {
            if (value < 1) return Result.failure(CreationFailure.ofMin(1))
            return Result.success(RankingPosition(value))
        }
    }

    override fun compareTo(other: RankingPosition): Int {
        return value.compareTo(other.value)
    }
}