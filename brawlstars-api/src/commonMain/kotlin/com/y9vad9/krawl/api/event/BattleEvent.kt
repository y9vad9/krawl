package com.y9vad9.krawl.api.event

import kotlinx.serialization.Serializable

@Serializable
public data class BattleEvent(
    val id: Long,
    val mode: String? = null,
    val map: String? = null,
)
