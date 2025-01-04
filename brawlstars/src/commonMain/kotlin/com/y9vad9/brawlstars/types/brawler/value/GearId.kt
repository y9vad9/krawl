package com.y9vad9.brawlstars.types.brawler.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.ValueRangeValidationRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class GearId private constructor(public val raw: Int) : Comparable<GearId> {
    public companion object : ValueFactory<GearId, Int> by factory(
        rules = listOf(ValueRangeValidationRule(62000000..62001000)),
        constructor = ::GearId,
    ) {
        override fun create(value: Int): Result<GearId> {
            return Result.success(GearId(value))
        }
    }

    override fun compareTo(other: GearId): Int {
        return raw.compareTo(other.raw)
    }
}