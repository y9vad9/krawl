package com.y9vad9.krawl.brawlify.icon

import com.y9vad9.krawl.club.ClubBadgeId
import kotlin.jvm.JvmInline

/**
 * Wrapper for a collection of [BrawlifyClubBadge]s, providing convenient access methods.
 *
 * @property rawMap Map of badge IDs to their corresponding [BrawlifyClubBadge] instances.
 */
@JvmInline
public value class BrawlifyClubBadges(
    public val rawMap: Map<ClubBadgeId, BrawlifyClubBadge>,
) {
    /** Returns all badges as a list. */
    public fun asList(): List<BrawlifyClubBadge> = rawMap.values.toList()

    /** Returns a sequence of all badges. */
    public fun asSequence(): Sequence<BrawlifyClubBadge> = rawMap.values.asSequence()

    /** Returns the badge with the specified [id], or `null` if not found. */
    public operator fun get(id: ClubBadgeId): BrawlifyClubBadge? = rawMap[id]

    /** Returns the badge with the specified [id], or throws an [IllegalArgumentException] if not found. */
    public fun getOrThrow(id: ClubBadgeId): BrawlifyClubBadge = this[id] ?: error("No badge found with id $id")
}
