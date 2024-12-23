package com.y9vad9.bsapi.types.brawler.value

import com.y9vad9.bsapi.types.ValueConstructor
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
public value class BrawlerName private constructor(public val value: String) {
    public companion object : ValueConstructor<BrawlerName, String> {
        override fun create(value: String): Result<BrawlerName> {
            return Result.success(BrawlerName(value))
        }
    }
}