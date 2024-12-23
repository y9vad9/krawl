package com.y9vad9.brawlifyapi.types.icons

import com.y9vad9.brawlifyapi.types.common.value.BrawlifyHash
import com.y9vad9.brawlifyapi.types.events.value.BrawlifyUrl
import com.y9vad9.bsapi.types.brawler.value.BrawlerId
import com.y9vad9.bsapi.types.event.value.Trophies
import com.y9vad9.bsapi.types.player.value.IconId
import kotlinx.serialization.Serializable

@Serializable
public data class BrawlifyPlayerIcon(
    val id: IconId,
    val name: BrawlifyHash,
    val name2: BrawlifyHash,
    val imageUrl: BrawlifyUrl,
    val imageUrl2: BrawlifyUrl,
    val brawler: BrawlerId,
    val requiredTotalTrophies: Trophies,
    val isReward: Boolean,
    val isAvailableForOffers: Boolean,
)