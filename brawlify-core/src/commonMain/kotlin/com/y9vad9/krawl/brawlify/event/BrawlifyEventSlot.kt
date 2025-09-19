package com.y9vad9.krawl.brawlify.event

import com.y9vad9.krawl.brawlify.api.v1.event.RawBrawlifyEventSlot
import com.y9vad9.krawl.brawlify.BrawlifyPathSegment
import com.y9vad9.krawl.brawlify.BrawlifyUrl
import com.y9vad9.krawl.event.EventSlotId

/**
 * Represents an event slot in the Brawlify game data system.
 *
 * An event slot defines a unique location or category where specific game events are placed,
 * including metadata for display, filtering, and visuals.
 *
 * @property id Unique identifier for the event slot, must be a positive integer.
 * @property name Displayable name of the event slot, used in UIs and data listings.
 * @property emoji A single emoji representing the event slot for compact or visual display.
 * @property pathSegment An identifier for resources lookup on public CDN (?).
 * @property isListingAlone Whether this slot is typically listed as a standalone category (not grouped with others).
 * @property isHideable Whether this slot can be hidden under certain conditions (e.g. from UI or listings).
 * @property hideForSlot Reference to another event slot that, when active, causes this slot to be hidden.
 * @property backgroundUrl URL to a background image representing the slot (used for rendering or decoration).
 */
public data class BrawlifyEventSlot(
    val id: EventSlotId,
    val name: BrawlifyEventSlotName,
    val emoji: BrawlifyEventSlotEmoji,
    val pathSegment: BrawlifyPathSegment,
    val isListingAlone: Boolean,
    val isHideable: Boolean,
    val hideForSlot: EventSlotId?,
    val backgroundUrl: BrawlifyUrl?,
)

/**
 * Converts this [RawBrawlifyEventSlot] into its typed and validated counterpart [BrawlifyEventSlot].
 *
 * @return the corresponding [BrawlifyEventSlot] instance
 * @throws IllegalArgumentException if any validation fails
 */
public fun RawBrawlifyEventSlot.toTypedOrThrow(): BrawlifyEventSlot =
    BrawlifyEventSlot(
        id = EventSlotId.createOrThrow(id),
        name = BrawlifyEventSlotName(name),
        emoji = BrawlifyEventSlotEmoji.createOrThrow(emoji),
        pathSegment = BrawlifyPathSegment(hash),
        isListingAlone = listAlone,
        isHideable = hideable,
        hideForSlot = hideForSlot?.let { EventSlotId.createOrThrow(it) },
        backgroundUrl = background?.let { BrawlifyUrl.createOrThrow(it) },
    )

/**
 * Attempts to convert this [RawBrawlifyEventSlot] into its typed counterpart [BrawlifyEventSlot].
 *
 * @return the validated [BrawlifyEventSlot], or `null` if conversion fails
 */
public fun RawBrawlifyEventSlot.toTypedOrNull(): BrawlifyEventSlot? =
    try { toTypedOrThrow() } catch (_: Throwable) { null }
