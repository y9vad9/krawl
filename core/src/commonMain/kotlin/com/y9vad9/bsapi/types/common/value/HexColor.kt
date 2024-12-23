package com.y9vad9.bsapi.types.common.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable

/**
 * Hex color. Accepts both literal values (0x) and with hashtag (#..).
 */
@Serializable
@JvmInline
public value class HexColor private constructor(public val raw: String) {
    public companion object : ValueConstructor<HexColor, String> {
        override fun create(value: String): Result<HexColor> {
            if (!value.startsWith('#') || !value.startsWith("0x")) return Result.failure(CreationFailure.ofPattern(Regex("(#|0x).*")))
            return Result.success(HexColor(value))
        }
    }

    public val isHexLiteral: Boolean get() = raw.startsWith("0x")
    public val isHexText: Boolean get() = raw.startsWith("#")
}