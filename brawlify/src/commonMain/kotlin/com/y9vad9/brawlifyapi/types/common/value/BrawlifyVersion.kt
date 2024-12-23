package com.y9vad9.brawlifyapi.types.common.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class BrawlifyVersion private constructor(public val raw: Int) {
    public companion object : ValueConstructor<BrawlifyVersion, Int> {
        override fun create(value: Int): Result<BrawlifyVersion> {
            if (value < 0) return Result.failure(CreationFailure.ofMin(0))
            return Result.success(BrawlifyVersion(value))
        }
    }
}