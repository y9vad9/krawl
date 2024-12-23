package com.y9vad9.bsapi.types.player

import com.y9vad9.bsapi.types.player.value.IconId
import kotlinx.serialization.Serializable

@Serializable
public data class PlayerIcon(
    val id: IconId,
)