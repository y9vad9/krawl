package com.y9vad9.brawlifyapi.types.common.value

import com.y9vad9.bsapi.types.ValueConstructor
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
public value class BrawlifyTitle(public val raw: String) {
    public companion object : ValueConstructor<BrawlifyTitle, String> {
        override fun create(value: String): Result<BrawlifyTitle> {
            return Result.success(BrawlifyTitle(value))
        }
    }
}