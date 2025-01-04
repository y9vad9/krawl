package com.y9vad9.brawlstars.types.player.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.StringIsNotBlankRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
public value class PlayerName private constructor(public val raw: String) {
    public companion object : ValueFactory<PlayerName, String> by factory(
        rules = listOf(StringIsNotBlankRule),
        constructor = ::PlayerName,
    )
}