package com.y9vad9.brawlifyapi.types.common.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
public value class BrawlifyHash private constructor(public val raw: String) {
    public companion object : ValueConstructor<BrawlifyHash, String> {
        override fun create(value: String): Result<BrawlifyHash> {
            return Result.success(BrawlifyHash(value))
        }
    }
}