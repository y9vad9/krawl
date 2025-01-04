package com.y9vad9.brawlify.types.maps.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.MinValueValidationRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class BrawlifyEnvironmentId private constructor(public val raw: Int) {
    public companion object : ValueFactory<BrawlifyEnvironmentId, Int> by factory(
        rules = listOf(MinValueValidationRule(0)),
        constructor = ::BrawlifyEnvironmentId,
    )
}