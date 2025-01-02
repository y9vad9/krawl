package com.y9vad9.bsapi.types.player.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class BotTag private constructor(public override val raw: String) : EntityTag {
    public companion object : ValueConstructor<BotTag, String> {
        public const val REQUIRED_SIZE: Int = 3

        override fun create(value: String): Result<BotTag> {
            val value = value.replace("#", "")

            if (value.length != REQUIRED_SIZE)
                return Result.failure(CreationFailure.ofSizeExact(REQUIRED_SIZE))

            return Result.success(BotTag(value))
        }
    }
}