package com.y9vad9.bsapi.types.club.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class ClubBadgeId(public val id: Int) {
    public companion object : ValueConstructor<ClubBadgeId, Int> {
        private val VALUE_RANGE: IntRange = 8000000..8100000
        override fun create(value: Int): Result<ClubBadgeId> {
            if (value !in VALUE_RANGE)
                return Result.failure(CreationFailure.ofRange(VALUE_RANGE))
            return Result.success(ClubBadgeId(value))
        }
    }
}