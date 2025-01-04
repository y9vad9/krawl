package com.y9vad9.brawlstars.types.event.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.MinValueValidationRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class RankingPosition private constructor(public val value: Int) : Comparable<RankingPosition> {
    public companion object : ValueFactory<RankingPosition, Int> by factory(
        rules = listOf(MinValueValidationRule(1)),
        constructor = ::RankingPosition,
    )

    override fun compareTo(other: RankingPosition): Int {
        return value.compareTo(other.value)
    }
}