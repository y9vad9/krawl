package com.y9vad9.brawlstars.types.event.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.StringIsNotBlankRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
public value class MapName private constructor(public val raw: String) {
    public companion object : ValueFactory<MapName, String> by factory(
        rules = listOf(StringIsNotBlankRule),
        constructor = ::MapName,
    )
}