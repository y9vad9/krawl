package com.y9vad9.krawl.api.v1.pagination

import kotlinx.serialization.Serializable

/**
 * Represents a paginated list of items returned by the API.
 *
 * Provides the items as a read-only [List] and includes pagination information
 * through the [paging] property.
 *
 * @param T The type of items contained in the list.
 * @param items The list of items for the current page.
 * @property paging The [Pagination] information containing cursors for navigating pages.
 */
@Serializable
public data class PaginatedList<T>(
    private val items: List<T>,
    public val paging: Pagination = Pagination(),
) : List<T> by items
