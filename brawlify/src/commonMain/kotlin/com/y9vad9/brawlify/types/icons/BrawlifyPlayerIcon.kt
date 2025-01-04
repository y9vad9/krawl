package com.y9vad9.brawlify.types.icons

import com.y9vad9.brawlify.types.events.value.BrawlifyUrl
import com.y9vad9.brawlify.types.value.BrawlifyHash
import com.y9vad9.brawlstars.types.brawler.value.BrawlerId
import com.y9vad9.brawlstars.types.event.value.Trophies
import com.y9vad9.brawlstars.types.player.value.IconId
import kotlinx.serialization.Serializable

@Serializable
public data class BrawlifyPlayerIcon(
    val id: IconId,
    val name: BrawlifyHash,
    val name2: BrawlifyHash,
    val imageUrl: BrawlifyUrl,
    val imageUrl2: BrawlifyUrl,
    val brawler: BrawlerId?,
    val requiredTotalTrophies: Trophies,
    val isReward: Boolean,
    val isAvailableForOffers: Boolean,
)