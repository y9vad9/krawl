package com.y9vad9.brawlify.types.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.StringIsNotBlankRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class BrawlifyDescriptionHtml(public val raw: String) {
    public companion object : ValueFactory<BrawlifyDescriptionHtml, String> by factory(
        rules = listOf(StringIsNotBlankRule),
        constructor = ::BrawlifyDescriptionHtml,
    )
}