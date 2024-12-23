package com.y9vad9.bsapi.types.event.value

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class BattleResult {
    @SerialName("victory")
    VICTORY,

    @SerialName("defeat")
    DEFEAT
}