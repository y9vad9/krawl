package com.y9vad9.brawlify.types.events.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.PatternValidationRule
import com.y9vad9.ktiny.kotlidator.rule.StringIsNotBlankRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
public value class BrawlifyUrl private constructor(public val raw: String) {
    public companion object : ValueFactory<BrawlifyUrl, String> by factory(
        rules = listOf(
            StringIsNotBlankRule,
            PatternValidationRule(Regex("(http|https)://"))
        ),
        constructor = ::BrawlifyUrl,
    )
}