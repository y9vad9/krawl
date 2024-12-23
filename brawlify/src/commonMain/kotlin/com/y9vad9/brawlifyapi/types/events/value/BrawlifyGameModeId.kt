package com.y9vad9.brawlifyapi.types.events.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
public value class BrawlifyGameModeId private constructor(public val raw: Int) {
    public companion object : ValueConstructor<BrawlifyGameModeId, Int> {
        override fun create(value: Int): Result<BrawlifyGameModeId> {
            if (value < 0) return Result.failure(CreationFailure.ofMin(0))
            return Result.success(BrawlifyGameModeId(value))
        }
    }
}