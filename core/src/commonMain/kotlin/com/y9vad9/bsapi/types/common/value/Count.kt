package com.y9vad9.bsapi.types.common.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class Count private constructor(public val raw: Int) {
    public companion object : ValueConstructor<Count, Int> {
        override fun create(value: Int): Result<Count> {
            return when {
                value < 0 -> Result.failure(CreationFailure.ofMin(0))
                else -> Result.success(Count(value))
            }
        }
    }
}