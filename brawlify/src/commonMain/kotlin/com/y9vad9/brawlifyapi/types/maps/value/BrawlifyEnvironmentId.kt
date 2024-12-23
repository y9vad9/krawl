package com.y9vad9.brawlifyapi.types.maps.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class BrawlifyEnvironmentId private constructor(public val raw: Int) {
    public companion object : ValueConstructor<BrawlifyEnvironmentId, Int> {
        override fun create(value: Int): Result<BrawlifyEnvironmentId> {
            if (value < 0) return Result.failure(CreationFailure.ofMin(0))
            return Result.success(BrawlifyEnvironmentId(value))
        }
    }
}