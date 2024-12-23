package com.y9vad9.brawlifyapi.types.brawlers.value

import com.y9vad9.bsapi.types.ValueConstructor
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class BrawlifyBrawlerClassName(public val raw: String) {
    public companion object : ValueConstructor<BrawlifyBrawlerClassName, String> {
        public val DAMAGE_DEALER: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("Damage Dealer")
        public val TANK: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("Tank")
        public val MARKSMAN: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("Marksman")
        public val ARTILLERY: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("Artillery")
        public val CONTROLLER: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("Controller")
        public val ASSASIN: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("Assassin")
        public val SUPPORT: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("Support")

        override fun create(value: String): Result<BrawlifyBrawlerClassName> {
            return Result.success(BrawlifyBrawlerClassName(value))
        }
    }
}