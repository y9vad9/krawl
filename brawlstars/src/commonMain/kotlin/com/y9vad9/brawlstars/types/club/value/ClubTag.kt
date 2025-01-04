package com.y9vad9.brawlstars.types.club.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.StringLengthRangeValidationRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class ClubTag private constructor(private val value: String) {

    public companion object : ValueFactory<ClubTag, String> by factory(
        rules = listOf(StringLengthRangeValidationRule(3..14)),
        constructor = ::ClubTag,
    )

    override fun toString(): String {
        return value.let {
            if (it.contains("#"))
                return it
            else "#$it"
        }
    }
}