package com.y9vad9.brawlifyapi.types.events.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
public value class BrawlifyEventName private constructor(public val raw: String) {
    public companion object : ValueConstructor<BrawlifyEventName, String> {
        override fun create(value: String): Result<BrawlifyEventName> {
            if (value.isBlank()) return Result.failure(CreationFailure.ofBlank())
            return Result.success(BrawlifyEventName(value))
        }
    }
}