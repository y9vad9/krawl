package com.y9vad9.brawlstars.types.brawler.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.StringIsNotBlankRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
public value class GearName private constructor(public val raw: String) {
    public companion object : ValueFactory<GearName, String> by factory(
        rules = listOf(StringIsNotBlankRule),
        constructor = ::GearName,
    ) {
        override fun create(value: String): Result<GearName> {
            return Result.success(GearName(value))
        }
    }
}