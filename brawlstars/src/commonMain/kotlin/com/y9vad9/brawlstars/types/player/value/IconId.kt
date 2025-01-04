package com.y9vad9.brawlstars.types.player.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.MinValueValidationRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class IconId private constructor(public val raw: Int) : Comparable<IconId> {
    public companion object : ValueFactory<IconId, Int> by factory(
        rules = listOf(MinValueValidationRule(28000000)),
        constructor = ::IconId,
    )

    override fun compareTo(other: IconId): Int {
        return raw.compareTo(other.raw)
    }
}