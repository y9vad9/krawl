package com.y9vad9.brawlstars.types.brawler.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.StringIsNotBlankRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
public value class StarPowerName private constructor(public val value: String) {
    public companion object : ValueFactory<StarPowerName, String> by factory(
        rules = listOf(StringIsNotBlankRule),
        constructor = ::StarPowerName,
    )
}