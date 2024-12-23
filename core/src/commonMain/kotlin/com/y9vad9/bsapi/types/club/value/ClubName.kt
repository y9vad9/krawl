package com.y9vad9.bsapi.types.club.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class ClubName private constructor(public val value: String) {
    public companion object : ValueConstructor<ClubName, String> {
        public val SIZE_RANGE: IntRange = 1..15

        override fun create(value: String): Result<ClubName> {
            return when (value.length) {
                in SIZE_RANGE -> Result.success(ClubName(value))
                else -> Result.failure(CreationFailure.ofRange(SIZE_RANGE))
            }
        }
    }
}