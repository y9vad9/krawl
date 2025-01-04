package com.y9vad9.brawlstars.types.brawler.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.StringIsNotBlankRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
public value class BrawlerName private constructor(public val value: String) {
    public companion object : ValueFactory<BrawlerName, String> by factory(
        rules = listOf(StringIsNotBlankRule),
        constructor = ::BrawlerName,
    ) {
        override fun create(value: String): Result<BrawlerName> {
            return Result.success(BrawlerName(value))
        }
    }
}