package com.y9vad9.bsapi.types.brawler.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * Power-level of the brawler. Might be negative if it's a friendly match.
 */
@Serializable
@JvmInline
public value class PowerLevel private constructor(private val value: Int) : Comparable<PowerLevel> {
    public companion object : ValueConstructor<PowerLevel, Int> {
        public val VALUE_RANGE: IntRange = -1..11

        /**
         * Undefined power level occurs in the friendly matches.
         */
        public val UNDEFINED: PowerLevel = PowerLevel(-1)

        /**
         * Normal minimum of the [PowerLevel] level. Don't use
         * for validation for the input of battle log – if it's a friendly match
         * it will be [UNDEFINED] of value `-1`.
         */
        public val MIN: PowerLevel = PowerLevel(1)
        public val MAX: PowerLevel = PowerLevel(11)

        override fun create(value: Int): Result<PowerLevel> {
            if (value !in VALUE_RANGE) return Result.failure(CreationFailure.ofRange(VALUE_RANGE))
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