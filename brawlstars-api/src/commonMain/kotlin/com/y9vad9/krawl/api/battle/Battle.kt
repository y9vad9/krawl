package com.y9vad9.krawl.api.battle

import com.y9vad9.krawl.api.event.BattleEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class BattleDto(
    @SerialName("battleTime")
    val battleTime: String,
    val event: BattleEvent,
    val battle: BattleDetails,
)