package com.y9vad9.brawlstars.types.event.value

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class BattleResultKind {
    @SerialName("victory")
    VICTORY,

    @SerialName("defeat")
    DEFEAT,

    @SerialName("draw")
    DRAW,
}