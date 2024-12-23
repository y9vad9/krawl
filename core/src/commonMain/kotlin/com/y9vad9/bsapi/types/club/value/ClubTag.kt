package com.y9vad9.bsapi.types.club.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class ClubTag private constructor(private val value: String) {
    public companion object : ValueConstructor<ClubTag, String> {
        public const val REQUIRED_SIZE: Int = 9

        override fun create(value: String): Result<ClubTag> {
            val value = value.replace("#", "")

            if (value.length != REQUIRED_SIZE)
                return Result.failure(CreationFailure.ofSizeExact(REQUIRED_SIZE))

            return Result.success(ClubTag(value))
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