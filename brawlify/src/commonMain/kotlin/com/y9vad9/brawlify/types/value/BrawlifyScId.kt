package com.y9vad9.brawlify.types.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.MinValueValidationRule
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
    public companion object : ValueFactory<BrawlifyScId, Int> by factory(
        rules = listOf(MinValueValidationRule(0)),
        constructor = ::BrawlifyScId,
    )
}