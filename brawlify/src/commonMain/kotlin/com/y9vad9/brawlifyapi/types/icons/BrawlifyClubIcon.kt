package com.y9vad9.brawlifyapi.types.icons

import com.y9vad9.brawlifyapi.types.events.value.BrawlifyUrl
import com.y9vad9.bsapi.types.club.value.ClubBadgeId
import kotlinx.serialization.Serializable

@Serializable
public data class BrawlifyClubIcon(
    val id: ClubBadgeId,
    val imageUrl: BrawlifyUrl,
)