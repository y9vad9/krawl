package com.y9vad9.bsapi.types.player.value

import com.y9vad9.bsapi.annotations.ContextualBSApi
import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@OptIn(ContextualBSApi::class)
@Serializable
@JvmInline
public value class PlayerTag private constructor(public override val raw: String) : EntityTag {
    public companion object : ValueConstructor<PlayerTag, String> {
        // length may vary from 7 to 10, add two for forward-compatibility
        public val LENGTH_RANGE: IntRange = 7..12

        override fun create(value: String): Result<PlayerTag> {
            val value = value.replace("#", "")

            if (value.length !in LENGTH_RANGE)
                return Result.failure(CreationFailure.ofRange(LENGTH_RANGE))

            return Result.success(PlayerTag(value))
        }
    }
}