package com.y9vad9.brawlstars.pagination

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.StringIsNotBlankRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
public value class Cursor private constructor(public val value: String) {
    public companion object : ValueFactory<Cursor, String> by factory(
        rules = listOf(StringIsNotBlankRule),
        constructor = ::Cursor,
    )
}