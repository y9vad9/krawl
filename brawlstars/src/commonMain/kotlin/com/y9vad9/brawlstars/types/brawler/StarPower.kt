package com.y9vad9.brawlstars.types.brawler

import com.y9vad9.brawlstars.types.brawler.value.StarPowerId
import com.y9vad9.brawlstars.types.brawler.value.StarPowerName
import kotlinx.serialization.Serializable

@Serializable
public data class StarPower(
    val id: StarPowerId,
    val name: StarPowerName,
)