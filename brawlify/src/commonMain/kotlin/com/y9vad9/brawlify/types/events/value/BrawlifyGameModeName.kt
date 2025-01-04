package com.y9vad9.brawlify.types.events.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.StringIsNotBlankRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
public value class BrawlifyGameModeName private constructor(public val raw: String) {
    public companion object : ValueFactory<BrawlifyGameModeName, String> by factory(
        rules = listOf(StringIsNotBlankRule),
        constructor = ::BrawlifyGameModeName,
    )
}