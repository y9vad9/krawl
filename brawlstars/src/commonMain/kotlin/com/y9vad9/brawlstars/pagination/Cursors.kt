package com.y9vad9.brawlstars.pagination

import kotlinx.serialization.Serializable

@Serializable
public data class Cursors(
    val before: Cursor?,
    val after: Cursor?,
)