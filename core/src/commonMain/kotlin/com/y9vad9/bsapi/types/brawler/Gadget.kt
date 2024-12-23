package com.y9vad9.bsapi.types.brawler

import com.y9vad9.bsapi.types.brawler.value.GadgetId
import com.y9vad9.bsapi.types.brawler.value.GadgetName
import kotlinx.serialization.Serializable

@Serializable
public data class Gadget(
    val id: GadgetId,
    val name: GadgetName,
)