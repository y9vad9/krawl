package com.y9vad9.krawl.api.v1.pagination

import kotlinx.serialization.Serializable

/**
 * Represents pagination information for paginated API responses.
 *
 * @property cursors The [PaginationCursors] used to navigate through pages of results.
 */
@Serializable
public data class Pagination(
    public val cursors: PaginationCursors,
)
