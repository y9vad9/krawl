package com.y9vad9.bsapi.types.brawler.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
public value class PowerLevel private constructor(private val value: Int) : Comparable<PowerLevel> {
    public companion object : ValueConstructor<PowerLevel, Int> {
        // we accept 12 for forward-compatibility as such rumors going on in the community
        public val VALUE_RANGE: IntRange = 1..12

        override fun create(value: Int): Result<PowerLevel> {
            if (value !in VALUE_RANGE) return Result.failure(CreationFailure.ofSizeRange(VALUE_RANGE))
            return Result.success(PowerLevel(value))
        }
    }


    override fun toString(): String {
        return "#$value"
    }

    override fun compareTo(other: PowerLevel): Int {
        return value.compareTo(other.value)
    }
}