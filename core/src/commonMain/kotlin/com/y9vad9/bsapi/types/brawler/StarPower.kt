package com.y9vad9.bsapi.types.brawler

import com.y9vad9.bsapi.types.brawler.value.StarPowerId
import com.y9vad9.bsapi.types.brawler.value.StarPowerName
import kotlinx.serialization.Serializable

@Serializable
public data class StarPower(
    val id: StarPowerId,
    val name: StarPowerName,
)