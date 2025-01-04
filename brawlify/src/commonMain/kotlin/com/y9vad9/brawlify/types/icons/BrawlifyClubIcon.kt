package com.y9vad9.brawlify.types.icons

import com.y9vad9.brawlify.types.events.value.BrawlifyUrl
import com.y9vad9.brawlstars.types.club.value.ClubBadgeId
import kotlinx.serialization.Serializable

@Serializable
public data class BrawlifyClubIcon(
    val id: ClubBadgeId,
    val imageUrl: BrawlifyUrl,
)