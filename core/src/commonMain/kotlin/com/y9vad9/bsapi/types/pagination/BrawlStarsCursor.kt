package com.y9vad9.bsapi.types.pagination

import com.y9vad9.bsapi.types.ValueConstructor
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
public value class BrawlStarsCursor private constructor(public val value: String) {
    public companion object : ValueConstructor<BrawlStarsCursor, String> {
        override fun create(value: String): Result<BrawlStarsCursor> {
            return Result.success(BrawlStarsCursor(value))
        }
    }
}