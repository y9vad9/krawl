package com.y9vad9.krawl.brawlify.event

import com.y9vad9.krawl.brawlify.api.v1.event.RawBrawlifyEventsRotation

/**
 * Represents a rotation of Brawlify events, including both currently active and upcoming ones.
 *
 * @property active The list of [BrawlifyEvent]s that are currently live in the game.
 * @property upcoming The list of [BrawlifyEvent]s that are scheduled to appear next.
 */
public data class BrawlifyEventsRotation(
    public val active: List<BrawlifyEvent>,
    public val upcoming: List<BrawlifyEvent>,
)

/**
 * Converts this [RawBrawlifyEventsRotation] into its typed and validated counterpart [BrawlifyEventsRotation].
 *
 * @return the corresponding [BrawlifyEventsRotation] instance
 * @throws IllegalArgumentException if any contained event fails validation
 */
public fun RawBrawlifyEventsRotation.toTypedOrThrow(): BrawlifyEventsRotation =
    BrawlifyEventsRotation(
        active = active.map { it.toTypedOrThrow() },
        upcoming = upcoming.map { it.toTypedOrThrow() },
    )

/**
 * Attempts to convert this [RawBrawlifyEventsRotation] into its typed counterpart [BrawlifyEventsRotation].
 *
 * @return the validated [BrawlifyEventsRotation], or `null` if conversion fails
 */
public fun RawBrawlifyEventsRotation.toTypedOrNull(): BrawlifyEventsRotation? =
    try { toTypedOrThrow() } catch (_: Throwable) { null }
