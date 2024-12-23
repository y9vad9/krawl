package com.y9vad9.bsapi.types.player.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
public value class PlayerTag private constructor(private val value: String) {
    public companion object : ValueConstructor<PlayerTag, String> {
        public const val REQUIRED_SIZE: Int = 9

        override fun create(value: String): Result<PlayerTag> {
            val value = value.replace("#", "")

            if (value.length != REQUIRED_SIZE)
                return Result.failure(CreationFailure.ofSizeExact(REQUIRED_SIZE))

            return Result.success(PlayerTag(value))
        }
    }


    override fun toString(): String {
        return value.let {
            if (it.contains("#"))
                return it
            else "#$it"
        }
    }
}