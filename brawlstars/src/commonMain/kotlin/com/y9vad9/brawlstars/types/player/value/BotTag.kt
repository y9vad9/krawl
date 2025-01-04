package com.y9vad9.brawlstars.types.player.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.StringLengthRangeValidationRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class BotTag private constructor(public override val raw: String) : EntityTag {
    public companion object : ValueFactory<BotTag, String> by factory(
        rules = listOf(StringLengthRangeValidationRule(3..4)),
        constructor = {
            BotTag(it.replace("#", ""))
        }
    )
}