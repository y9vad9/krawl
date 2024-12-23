package com.y9vad9.brawlifyapi.types.stats

import com.y9vad9.brawlifyapi.types.common.value.BrawlifyRate
import com.y9vad9.bsapi.types.brawler.value.BrawlerId
import kotlinx.serialization.Serializable

@Serializable
public data class BrawlifyBrawlerStat(
    val brawler: BrawlerId,
    val winRate: BrawlifyRate,
    val useRate: BrawlifyRate,
    // star player rate
    val starRate: BrawlifyRate,
)