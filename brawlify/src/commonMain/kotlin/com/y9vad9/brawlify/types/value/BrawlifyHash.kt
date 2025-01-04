package com.y9vad9.brawlify.types.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.StringIsNotBlankRule
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
public value class BrawlifyHash private constructor(public val raw: String) {
    public companion object : ValueFactory<BrawlifyHash, String> by factory(
        rules = listOf(StringIsNotBlankRule),
        constructor = ::BrawlifyHash,
    )
}