package com.y9vad9.brawlifyapi.types.common.value

import com.y9vad9.bsapi.types.ValueConstructor
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
public value class BrawlifyDescription(public val raw: String) {
    public companion object : ValueConstructor<BrawlifyDescription, String> {
        override fun create(value: String): Result<BrawlifyDescription> {
            return Result.success(BrawlifyDescription(value))
        }
    }
}