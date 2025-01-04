package com.y9vad9.brawlstars.types.club.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
public value class ClubDescription private constructor(public val raw: String) {
    public companion object : ValueFactory<ClubDescription, String> by factory(
        constructor = ::ClubDescription
    )
}