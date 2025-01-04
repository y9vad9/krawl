package com.y9vad9.brawlstars.types.brawler.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.MinValueValidationRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class GadgetId private constructor(public val raw: Int) : Comparable<GadgetId> {
    public companion object : ValueFactory<GadgetId, Int> by factory(
        rules = listOf(MinValueValidationRule(23000000)),
        constructor = ::GadgetId,
    )

    override fun compareTo(other: GadgetId): Int {
        return raw.compareTo(other.raw)
    }
}