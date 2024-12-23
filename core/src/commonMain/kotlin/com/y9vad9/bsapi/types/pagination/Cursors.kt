package com.y9vad9.bsapi.types.pagination

import kotlinx.serialization.Serializable

@Serializable
public data class Cursors(
    val before: BrawlStarsCursor?,
    val after: BrawlStarsCursor?,
)