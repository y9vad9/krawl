package com.y9vad9.brawlstars.types.brawler.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.StringIsNotBlankRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
public value class GadgetName private constructor(public val raw: String) {
    public companion object : ValueFactory<GadgetName, String> by factory(
        rules = listOf(StringIsNotBlankRule),
        constructor = ::GadgetName,
    ) {
        override fun create(value: String): Result<GadgetName> {
            return Result.success(GadgetName(value))
        }
    }
}