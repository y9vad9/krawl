package com.y9vad9.brawlifyapi.types.common.value

import com.y9vad9.bsapi.types.ValueConstructor
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
public value class BrawlifyDescriptionHtml(public val raw: String) {
    public companion object : ValueConstructor<BrawlifyDescriptionHtml, String> {
        override fun create(value: String): Result<BrawlifyDescriptionHtml> {
            return Result.success(BrawlifyDescriptionHtml(value))
        }
    }
}