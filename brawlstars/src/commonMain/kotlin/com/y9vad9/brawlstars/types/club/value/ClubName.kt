package com.y9vad9.brawlstars.types.club.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.StringIsNotBlankRule
import com.y9vad9.ktiny.kotlidator.rule.StringLengthRangeValidationRule
import com.y9vad9.ktiny.kotlidator.rule.StringLengthValidationRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class ClubName private constructor(public val value: String) {
    public companion object : ValueFactory<ClubName, String> by factory(
        rules = listOf(StringLengthRangeValidationRule(1..15)),
        constructor = ::ClubName
    ) {
        public val LENGTH_RANGE: IntRange = 1..15
    }
}