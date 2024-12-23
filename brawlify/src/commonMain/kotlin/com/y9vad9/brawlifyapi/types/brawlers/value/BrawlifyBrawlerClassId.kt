package com.y9vad9.brawlifyapi.types.brawlers.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class BrawlifyBrawlerClassId(public val raw: Int) {
    public companion object : ValueConstructor<BrawlifyBrawlerClassId, Int> {
        public val VALUE_RANGE: IntRange = 1..7

        public val DAMAGE_DEALER: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(1)
        public val TANK: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(2)
        public val MARKSMAN: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(3)
        public val ARTILLERY: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(4)
        public val CONTROLLER: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(5)
        public val ASSASIN: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(6)
        public val SUPPORT: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(7)

        override fun create(value: Int): Result<BrawlifyBrawlerClassId> {
            if (value !in VALUE_RANGE) return Result.failure(CreationFailure.ofMin(1))
            return Result.success(BrawlifyBrawlerClassId(value))
        }
    }
}