package com.y9vad9.brawlify.types.brawlers.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.StringIsNotBlankRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class BrawlifyBrawlerClassName(public val raw: String) {
    public companion object : ValueFactory<BrawlifyBrawlerClassName, String> by factory(
        rules = listOf(StringIsNotBlankRule),
        constructor = ::BrawlifyBrawlerClassName,
    ) {
        public val DAMAGE_DEALER: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("Damage Dealer")
        public val TANK: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("Tank")
        public val MARKSMAN: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("Marksman")
        public val ARTILLERY: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("Artillery")
        public val CONTROLLER: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("Controller")
        public val ASSASSIN: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("Assassin")
        public val SUPPORT: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("Support")

        override fun create(value: String): Result<BrawlifyBrawlerClassName> {
            return Result.success(BrawlifyBrawlerClassName(value))
        }
    }
}