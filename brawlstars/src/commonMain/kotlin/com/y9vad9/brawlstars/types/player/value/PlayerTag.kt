package com.y9vad9.brawlstars.types.player.value

import com.y9vad9.brawlstars.annotations.ContextualBSApi
import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.StringLengthRangeValidationRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@OptIn(ContextualBSApi::class)
@Serializable
@JvmInline
public value class PlayerTag private constructor(public override val raw: String) : EntityTag {
    public companion object : ValueFactory<PlayerTag, String> by factory(
        rules = listOf(StringLengthRangeValidationRule(3..14)),
        constructor = {
            PlayerTag(it.replace("#", ""))
        }
    )
}