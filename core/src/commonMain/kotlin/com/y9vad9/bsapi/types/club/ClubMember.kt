package com.y9vad9.bsapi.types.club

import com.y9vad9.bsapi.types.club.value.PlayerRole
import com.y9vad9.bsapi.types.event.value.Trophies
import com.y9vad9.bsapi.types.player.PlayerIcon
import com.y9vad9.bsapi.types.player.value.PlayerName
import com.y9vad9.bsapi.types.player.value.PlayerTag
import kotlinx.serialization.Serializable

@Serializable
public data class ClubMember(
    val tag: PlayerTag,
    val name: PlayerName,
    val role: PlayerRole,
    val trophies: Trophies,
    val icon: PlayerIcon,
)