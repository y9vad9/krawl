package com.y9vad9.krawl.api.battle

import kotlinx.serialization.Serializable

@Serializable
public data class BattlePlayer(
    val tag: String,
    val name: String,
    val brawler: BattleBrawler,
)