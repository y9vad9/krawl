package com.y9vad9.bsapi.types.club.value

import com.y9vad9.bsapi.types.ValueConstructor
import kotlinx.serialization.Serializable

@JvmInline
@Serializable
public value class ClubDescription private constructor(public val raw: String) {
    public companion object : ValueConstructor<ClubDescription, String> {
        override fun create(value: String): Result<ClubDescription> {
            return Result.success(ClubDescription(value))
        }
    }
}