package com.y9vad9.krawl.api.battle

import kotlinx.serialization.Serializable

@Serializable
public data class BattleBrawler(
    val id: Int,
    val name: String,
    val power: Int,
    val trophies: Int,
)
