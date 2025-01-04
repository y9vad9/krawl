package com.y9vad9.brawlstars.types.club.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.ValueRangeValidationRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class ClubBadgeId(public val id: Int) {
    public companion object : ValueFactory<ClubBadgeId, Int> by factory(
        rules = listOf(ValueRangeValidationRule(8000000..8100000)),
        constructor = ::ClubBadgeId,
    )
}