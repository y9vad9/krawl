package com.y9vad9.brawlify.types.brawlers.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.ValueRangeValidationRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class BrawlifyBrawlerClassId(public val raw: Int) {
    public companion object : ValueFactory<BrawlifyBrawlerClassId, Int> by factory(
        rules = listOf(ValueRangeValidationRule(1..7)),
        constructor = ::BrawlifyBrawlerClassId,
    ) {
        public val DAMAGE_DEALER: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(1)
        public val TANK: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(2)
        public val MARKSMAN: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(3)
        public val ARTILLERY: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(4)
        public val CONTROLLER: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(5)
        public val ASSASIN: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(6)
        public val SUPPORT: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(7)
    }
}