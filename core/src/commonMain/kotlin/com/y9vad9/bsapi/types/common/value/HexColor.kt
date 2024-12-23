package com.y9vad9.bsapi.types.common.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
public value class HexColor private constructor(public val raw: String) {
    public companion object : ValueConstructor<HexColor, String> {
        override fun create(value: String): Result<HexColor> {
            if (!value.startsWith('#')) return Result.failure(CreationFailure.ofPattern(Regex("#.*")))
            return Result.success(HexColor(value))
        }
    }
}