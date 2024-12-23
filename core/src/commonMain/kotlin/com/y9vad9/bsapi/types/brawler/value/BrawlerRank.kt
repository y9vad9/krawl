package com.y9vad9.bsapi.types.brawler.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class BrawlerRank private constructor(public val raw: Int) : Comparable<BrawlerRank> {
    public companion object : ValueConstructor<BrawlerRank, Int> {
        public val VALUE_RANGE: IntRange = 1..51

        public val MIN: BrawlerRank = BrawlerRank(1)
        public val MAX: BrawlerRank = BrawlerRank(51)

        override fun create(value: Int): Result<BrawlerRank> {
            if (value !in VALUE_RANGE) return Result.failure(CreationFailure.ofRange(VALUE_RANGE))
            return Result.success(BrawlerRank(value))
        }
    }


    override fun toString(): String {
        return raw.toString()
    }

    override fun compareTo(other: BrawlerRank): Int {
        return raw.compareTo(other.raw)
    }
}