package com.y9vad9.bsapi.types.brawler.value

import com.y9vad9.bsapi.types.ValueConstructor
import kotlinx.serialization.Serializable

@JvmInline
@Serializable
public value class StarPowerName private constructor(public val value: String) {
    public companion object : ValueConstructor<StarPowerName, String> {
        override fun create(value: String): Result<StarPowerName> {
            return Result.success(StarPowerName(value))
        }
    }
}