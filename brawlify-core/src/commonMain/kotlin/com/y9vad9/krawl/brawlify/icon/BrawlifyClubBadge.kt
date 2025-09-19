package com.y9vad9.krawl.brawlify.icon

import com.y9vad9.krawl.brawlify.api.v1.icon.RawBrawlifyClubBadge
import com.y9vad9.krawl.brawlify.BrawlifyUrl
import com.y9vad9.krawl.club.ClubBadgeId

/**
 * Represents a club badge in Brawl Stars.
 *
 * @property id Unique identifier of the badge.
 * @property imageUrl URL pointing to the badge image.
 */
public data class BrawlifyClubBadge(
    public val id: ClubBadgeId,
    public val imageUrl: BrawlifyUrl,
)

/**
 * Converts this [RawBrawlifyClubBadge] into a strongly-typed [BrawlifyClubBadge].
 *
 * The [RawBrawlifyClubBadge.id] and [RawBrawlifyClubBadge.imageUrl] fields are validated and wrapped
 * in their respective domain-specific value types:
 * - [ClubBadgeId] via [ClubBadgeId.createOrThrow]
 * - [BrawlifyUrl] via [BrawlifyUrl.createOrThrow]
 *
 * @throws IllegalArgumentException if the [RawBrawlifyClubBadge.id] or [RawBrawlifyClubBadge.imageUrl] are invalid
 */
public fun RawBrawlifyClubBadge.toTypedOrThrow(): BrawlifyClubBadge {
    return BrawlifyClubBadge(
        id = ClubBadgeId.createOrThrow(id),
        imageUrl = BrawlifyUrl.createOrThrow(imageUrl),
    )
}

/**
 * Converts this [RawBrawlifyClubBadge] into a strongly-typed [BrawlifyClubBadge], or returns `null`
 * if the conversion fails.
 *
 * This function is a safe alternative to [toTypedOrThrow], catching and suppressing any exceptions
 * that may occur during the conversion process (e.g., invalid ID or URL).
 *
 * @return the corresponding [BrawlifyClubBadge], or `null` if the conversion is not possible
 */
public fun RawBrawlifyClubBadge.toTypedOrNull(): BrawlifyClubBadge? =
    try { toTypedOrThrow() } catch (_: Throwable) { null }
