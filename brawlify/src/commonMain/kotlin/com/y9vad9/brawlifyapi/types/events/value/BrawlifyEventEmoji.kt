package com.y9vad9.brawlifyapi.types.events.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable

@JvmInline
@Serializable
public value class BrawlifyEventEmoji private constructor(public val raw: String) {
    public companion object : ValueConstructor<BrawlifyEventEmoji, String> {
        override fun create(value: String): Result<BrawlifyEventEmoji> {
            if (value.isBlank()) return Result.failure(CreationFailure.ofBlank())
            return Result.success(BrawlifyEventEmoji(value))
        }
    }
}