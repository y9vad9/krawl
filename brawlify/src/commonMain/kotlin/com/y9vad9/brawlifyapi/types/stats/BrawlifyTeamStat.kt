package com.y9vad9.brawlifyapi.types.stats

import com.y9vad9.brawlifyapi.types.common.value.BrawlifyHash
import com.y9vad9.brawlifyapi.types.common.value.BrawlifyRate
import com.y9vad9.bsapi.types.brawler.value.BrawlerId
import com.y9vad9.bsapi.types.common.value.Count
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
public data class BrawlifyTeamStat(
    val name: BrawlifyBrawlerStat,
    val hash: BrawlifyHash,
    val brawler1: BrawlerId,
    val brawler2: BrawlerId,
    val brawler3: BrawlerId? = null,
    val brawler4: BrawlerId? = null,
    val brawler5: BrawlerId? = null,
    val data: Data,
) {
    @Transient
    public val brawlers: List<BrawlerId> = listOfNotNull(brawler1, brawler2, brawler3, brawler4, brawler5)

    @Serializable
    public data class Data(
        val winRate: BrawlifyRate,
        val useRate: BrawlifyRate,
        val wins: Count,
        val losses: Count,
        val draws: Count,
        val total: Count,
    )
}