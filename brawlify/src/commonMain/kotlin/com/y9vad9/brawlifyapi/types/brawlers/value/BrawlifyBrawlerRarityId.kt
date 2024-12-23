package com.y9vad9.brawlifyapi.types.brawlers.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
public value class BrawlifyBrawlerRarityId(public val raw: Int) {
    public companion object : ValueConstructor<BrawlifyBrawlerRarityId, Int> {
        public val VALUE_RANGE: IntRange = 1..6

        // available from the start of the game
        public val COMMON: BrawlifyBrawlerRarityId = BrawlifyBrawlerRarityId(1)

        public val RARE: BrawlifyBrawlerRarityId = BrawlifyBrawlerRarityId(2)
        public val SUPER_RARE: BrawlifyBrawlerRarityId = BrawlifyBrawlerRarityId(3)
        public val EPIC: BrawlifyBrawlerRarityId = BrawlifyBrawlerRarityId(4)
        public val MYTHIC: BrawlifyBrawlerRarityId = BrawlifyBrawlerRarityId(5)
        public val LEGENDARY: BrawlifyBrawlerRarityId = BrawlifyBrawlerRarityId(6)


        override fun create(value: Int): Result<BrawlifyBrawlerRarityId> {
            if (value !in VALUE_RANGE) return Result.failure(CreationFailure.ofRange(VALUE_RANGE))
            return Result.success(BrawlifyBrawlerRarityId(value))
        }
    }
}