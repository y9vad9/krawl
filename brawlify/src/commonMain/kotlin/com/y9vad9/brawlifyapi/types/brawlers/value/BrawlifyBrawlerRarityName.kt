package com.y9vad9.brawlifyapi.types.brawlers.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class BrawlifyBrawlerRarityName(public val raw: String) {
    public companion object : ValueConstructor<BrawlifyBrawlerRarityName, String> {
        public val COMMON: BrawlifyBrawlerRarityName = BrawlifyBrawlerRarityName("Common")
        public val RARE: BrawlifyBrawlerRarityName = BrawlifyBrawlerRarityName("Rare")
        public val SUPER_RARE: BrawlifyBrawlerRarityName = BrawlifyBrawlerRarityName("Super Rare")
        public val EPIC: BrawlifyBrawlerRarityName = BrawlifyBrawlerRarityName("Epic")
        public val MYTHIC: BrawlifyBrawlerRarityName = BrawlifyBrawlerRarityName("Mythic")
        public val LEGENDARY: BrawlifyBrawlerRarityName = BrawlifyBrawlerRarityName("Legendary")

        public val allRarities: List<BrawlifyBrawlerRarityName> = listOf(
            COMMON, RARE, SUPER_RARE, EPIC, MYTHIC, LEGENDARY,
        )
        private val allRaritiesValues: List<String> = allRarities.map { it.raw }

        override fun create(value: String): Result<BrawlifyBrawlerRarityName> {
            if (value !in allRaritiesValues)
                return Result.failure(CreationFailure.acceptsOnly(allRaritiesValues))
            return Result.success(BrawlifyBrawlerRarityName(value))
        }
    }
}