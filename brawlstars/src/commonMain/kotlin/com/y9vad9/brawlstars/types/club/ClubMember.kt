package com.y9vad9.brawlstars.types.club

import com.y9vad9.brawlstars.types.club.value.PlayerRole
import com.y9vad9.brawlstars.types.event.value.Trophies
import com.y9vad9.brawlstars.types.player.PlayerIcon
import com.y9vad9.brawlstars.types.player.value.PlayerName
import com.y9vad9.brawlstars.types.player.value.PlayerTag
import com.y9vad9.brawlstars.types.value.HexColor
import kotlinx.serialization.Serializable

@Serializable
public data class ClubMember(
    val tag: PlayerTag,
    val name: PlayerName,
    val nameColor: HexColor,
    val role: PlayerRole,
    val trophies: Trophies,
    val icon: PlayerIcon,
)