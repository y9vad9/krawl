package com.y9vad9.brawlify.types.stats

import com.y9vad9.brawlify.types.stats.value.BrawlifyTeamName
import com.y9vad9.brawlify.types.value.BrawlifyHash
import com.y9vad9.brawlify.types.value.BrawlifyRate
import com.y9vad9.brawlstars.types.brawler.value.BrawlerId
import com.y9vad9.brawlstars.types.value.Count
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
public data class BrawlifyTeamStat(
    val name: BrawlifyTeamName,
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