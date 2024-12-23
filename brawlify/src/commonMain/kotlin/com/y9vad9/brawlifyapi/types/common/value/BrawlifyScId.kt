package com.y9vad9.brawlifyapi.types.common.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * Brawlify-specific identifier of resources.
 *
 * Most likely represents a path or an representative of a resource
 * in Brawl Stars API (like scId).
 */
@Serializable
@JvmInline
public value class BrawlifyScId private constructor(public val raw: Int) {
    public companion object : ValueConstructor<BrawlifyScId, Int> {
        override fun create(value: Int): Result<BrawlifyScId> {
            return Result.success(BrawlifyScId(value))
        }
    }
}