package com.y9vad9.bsapi.types.brawler.value

import com.y9vad9.bsapi.types.ValueConstructor
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
public value class GearName private constructor(public val raw: String) {
    public companion object : ValueConstructor<GearName, String> {
        override fun create(value: String): Result<GearName> {
            return Result.success(GearName(value))
        }
    }
}