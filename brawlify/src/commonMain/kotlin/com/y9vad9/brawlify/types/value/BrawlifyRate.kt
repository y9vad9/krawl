package com.y9vad9.brawlify.types.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.ValueRangeValidationRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class BrawlifyRate private constructor(public val raw: Double) {
    public companion object : ValueFactory<BrawlifyRate, Double> by factory(
        rules = listOf(ValueRangeValidationRule(0.0..100.0)),
        constructor = ::BrawlifyRate,
    )
}