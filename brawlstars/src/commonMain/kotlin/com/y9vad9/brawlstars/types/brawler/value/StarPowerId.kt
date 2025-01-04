package com.y9vad9.brawlstars.types.brawler.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.MinValueValidationRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class StarPowerId private constructor(public val value: Int) : Comparable<StarPowerId> {
    public companion object : ValueFactory<StarPowerId, Int> by factory(
        rules = listOf(MinValueValidationRule(23000000)),
        constructor = ::StarPowerId,
    )

    override fun compareTo(other: StarPowerId): Int {
        return value.compareTo(other.value)
    }
}