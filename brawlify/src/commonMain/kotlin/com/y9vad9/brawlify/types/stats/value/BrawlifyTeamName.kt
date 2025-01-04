package com.y9vad9.brawlify.types.stats.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.StringIsNotBlankRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class BrawlifyTeamName private constructor(public val raw: String) {
    public companion object : ValueFactory<BrawlifyTeamName, String> by factory(
        rules = listOf(StringIsNotBlankRule),
        constructor = ::BrawlifyTeamName,
    )
}