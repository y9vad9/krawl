package com.y9vad9.brawlifyapi.types.maps.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class BrawlifyEnvironmentName private constructor(public val raw: String) {
    public companion object : ValueConstructor<BrawlifyEnvironmentName, String> {
        override fun create(value: String): Result<BrawlifyEnvironmentName> {
            if (value.isBlank()) return Result.failure(CreationFailure.ofBlank())
            return Result.success(BrawlifyEnvironmentName(value))
        }
    }
}