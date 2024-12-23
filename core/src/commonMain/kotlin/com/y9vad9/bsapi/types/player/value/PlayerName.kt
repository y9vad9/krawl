package com.y9vad9.bsapi.types.player.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable

@JvmInline
@Serializable
public value class PlayerName private constructor(public val raw: String) {
    public companion object : ValueConstructor<PlayerName, String> {
        public val SIZE_RANGE: IntRange = 1..15

        override fun create(value: String): Result<PlayerName> {
            return when (value.length) {
                in SIZE_RANGE -> Result.success(PlayerName(value))
                else -> Result.failure(CreationFailure.ofSizeRange(SIZE_RANGE))
            }
        }
    }
}