package com.y9vad9.brawlify.types.stats

import com.y9vad9.brawlify.types.value.BrawlifyRate
import com.y9vad9.brawlstars.types.brawler.value.BrawlerId
import kotlinx.serialization.Serializable

@Serializable
public data class BrawlifyBrawlerStat(
    val brawler: BrawlerId,
    val winRate: BrawlifyRate,
    val useRate: BrawlifyRate,
    // star player rate (for teams battles)
    val starRate: BrawlifyRate? = null,
)