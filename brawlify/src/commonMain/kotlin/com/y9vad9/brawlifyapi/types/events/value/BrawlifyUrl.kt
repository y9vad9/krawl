package com.y9vad9.brawlifyapi.types.events.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
public value class BrawlifyUrl private constructor(public val raw: String) {
    public companion object : ValueConstructor<BrawlifyUrl, String> {
        public val REGEX: Regex = Regex("(http|https)://")

        override fun create(value: String): Result<BrawlifyUrl> {
            if (value.isBlank()) return Result.failure(CreationFailure.ofBlank())
            if (!value.contains(REGEX)) return Result.failure(CreationFailure.ofPattern(REGEX))
            return Result.success(BrawlifyUrl(value))
        }
    }
}