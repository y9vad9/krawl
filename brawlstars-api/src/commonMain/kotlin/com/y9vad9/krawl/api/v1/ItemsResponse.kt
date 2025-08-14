package com.y9vad9.krawl.api.v1

import kotlinx.serialization.Serializable

@Serializable
internal data class ItemsResponse<T>(
    val items: List<T>,
)