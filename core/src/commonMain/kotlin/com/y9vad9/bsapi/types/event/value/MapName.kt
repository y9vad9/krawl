package com.y9vad9.bsapi.types.event.value

import com.y9vad9.bsapi.types.ValueConstructor
import kotlinx.serialization.Serializable

@JvmInline
@Serializable
public value class MapName private constructor(public val raw: String) {
    public companion object : ValueConstructor<MapName, String> {
        override fun create(value: String): Result<MapName> {
            return Result.success(MapName(value))
        }
    }
}