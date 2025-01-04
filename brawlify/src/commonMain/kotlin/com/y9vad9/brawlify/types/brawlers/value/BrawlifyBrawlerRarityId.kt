package com.y9vad9.brawlify.types.brawlers.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.ValueRangeValidationRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class BrawlifyBrawlerRarityId(public val raw: Int) {
    public companion object : ValueFactory<BrawlifyBrawlerRarityId, Int> by factory(
        rules = listOf(ValueRangeValidationRule(1..6)),
        constructor = ::BrawlifyBrawlerRarityId,
    ) {
        // available from the start of the game
        public val COMMON: BrawlifyBrawlerRarityId = BrawlifyBrawlerRarityId(1)

        public val RARE: BrawlifyBrawlerRarityId = BrawlifyBrawlerRarityId(2)
        public val SUPER_RARE: BrawlifyBrawlerRarityId = BrawlifyBrawlerRarityId(3)
        public val EPIC: BrawlifyBrawlerRarityId = BrawlifyBrawlerRarityId(4)
        public val MYTHIC: BrawlifyBrawlerRarityId = BrawlifyBrawlerRarityId(5)
        public val LEGENDARY: BrawlifyBrawlerRarityId = BrawlifyBrawlerRarityId(6)
    }
}