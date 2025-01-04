package com.y9vad9.brawlstars.pagination

import kotlinx.serialization.Serializable

@Serializable
public data class Page<T>(
    val items: List<T>? = null,
    val paging: Cursors? = null,
)