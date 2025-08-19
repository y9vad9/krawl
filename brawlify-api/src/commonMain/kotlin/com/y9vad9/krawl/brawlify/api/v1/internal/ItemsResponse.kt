package com.y9vad9.krawl.brawlify.api.v1.internal

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@Serializable
internal data class ItemsResponse<T>(
    @JsonNames("items", "list")
    val items: List<T>,
)
