package com.y9vad9.brawlstars.types.brawler.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.ValueRangeValidationRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * Power-level of the brawler. Might be negative if it's a friendly match.
 */
@Serializable
@JvmInline
public value class PowerLevel private constructor(private val value: Int) : Comparable<PowerLevel> {
    public companion object : ValueFactory<PowerLevel, Int> by factory(
        rules = listOf(ValueRangeValidationRule(-1..11)),
        constructor = ::PowerLevel,
    ) {
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
    }


    override fun toString(): String {
        return "#$value"
    }

    override fun compareTo(other: PowerLevel): Int {
        return value.compareTo(other.value)
    }
}