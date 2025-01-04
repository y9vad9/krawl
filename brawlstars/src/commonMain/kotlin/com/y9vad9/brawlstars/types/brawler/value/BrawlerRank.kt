package com.y9vad9.brawlstars.types.brawler.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.ValueRangeValidationRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class BrawlerRank private constructor(public val raw: Int) : Comparable<BrawlerRank> {
    public companion object : ValueFactory<BrawlerRank, Int> by factory(
        rules = listOf(ValueRangeValidationRule(1..51)),
        constructor = ::BrawlerRank,
    ) {
        public val MIN: BrawlerRank = BrawlerRank(1)
        public val MAX: BrawlerRank = BrawlerRank(51)
    }


    override fun toString(): String {
        return raw.toString()
    }

    override fun compareTo(other: BrawlerRank): Int {
        return raw.compareTo(other.raw)
    }
}