package com.y9vad9.krawl.api.battle

import kotlinx.serialization.Serializable

@Serializable
public data class BattleDetails(
    val mode: String,
    val type: String,
    val result: String? = null,
    val duration: Int? = null,
    val starPlayer: BattlePlayer? = null,
    val teams: List<List<BattlePlayer>>? = null,
    val players: List<BattlePlayer>? = null,
)