package com.y9vad9.krawl.api.v1.pagination

import kotlinx.serialization.Serializable

/**
 * Represents pagination cursors used for navigating through paginated API results.
 *
 * @property before Optional cursor pointing to the item **before** the current page.
 * @property after Optional cursor pointing to the item **after** the current page.
 */
@Serializable
public data class PaginationCursors(
    public val before: String? = null,
    public val after: String? = null,
)
