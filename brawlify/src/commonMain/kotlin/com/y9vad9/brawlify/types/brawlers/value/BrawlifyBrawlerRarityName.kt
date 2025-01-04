package com.y9vad9.brawlify.types.brawlers.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.StringIsNotBlankRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class BrawlifyBrawlerRarityName(public val raw: String) {
    public companion object : ValueFactory<BrawlifyBrawlerRarityName, String> by factory(
        rules = listOf(StringIsNotBlankRule),
        constructor = ::BrawlifyBrawlerRarityName,
    ) {
        public val COMMON: BrawlifyBrawlerRarityName = BrawlifyBrawlerRarityName("Common")
        public val RARE: BrawlifyBrawlerRarityName = BrawlifyBrawlerRarityName("Rare")
        public val SUPER_RARE: BrawlifyBrawlerRarityName = BrawlifyBrawlerRarityName("Super Rare")
        public val EPIC: BrawlifyBrawlerRarityName = BrawlifyBrawlerRarityName("Epic")
        public val MYTHIC: BrawlifyBrawlerRarityName = BrawlifyBrawlerRarityName("Mythic")
        public val LEGENDARY: BrawlifyBrawlerRarityName = BrawlifyBrawlerRarityName("Legendary")

        public val allRarities: List<BrawlifyBrawlerRarityName> = listOf(
            COMMON, RARE, SUPER_RARE, EPIC, MYTHIC, LEGENDARY,
        )
    }
}