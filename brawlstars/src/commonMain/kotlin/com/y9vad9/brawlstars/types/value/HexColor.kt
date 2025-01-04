package com.y9vad9.brawlstars.types.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.PatternValidationRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * Hex color. Accepts both literal values (0x) and with hashtag (#..).
 */
@Serializable
@JvmInline
public value class HexColor private constructor(public val raw: String) {
    public companion object : ValueFactory<HexColor, String> by factory(
        rules = listOf(PatternValidationRule(Regex("#|0x"))),
        constructor = ::HexColor,
    )

    public val isHexLiteral: Boolean get() = raw.startsWith("0x")
    public val isHexText: Boolean get() = raw.startsWith("#")
}