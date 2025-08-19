package com.y9vad9.krawl.brawlify.api.v1.event

import kotlinx.serialization.Serializable

/**
 * Represents a slot in the Brawl Stars event rotation.
 *
 * Slots define how and where an event is presented to players in the game
 * (for example, "Daily Showdown" or "Special Events"). Each slot has its
 * own ID, name, emoji, and display rules.
 *
 * ### Example
 * ```json
 * {
 *   "id": 2,
 *   "name": "Daily Showdown",
 *   "emoji": "💀",
 *   "hash": "Slot-2",
 *   "listAlone": false,
 *   "hideable": true,
 *   "hideForSlot": 5,
 *   "background": null
 * }
 * ```
 *
 * @property id Unique numeric identifier of the slot.
 * @property name Human-readable name of the slot (e.g. "Daily Showdown").
 * @property emoji Emoji associated with the slot for visual representation.
 * @property hash Unique hash string identifier for the slot.
 * @property listAlone Whether this slot should be displayed on its own in the event list.
 * @property hideable Whether this slot can be hidden from the event rotation.
 * @property hideForSlot Slot ID for which this slot should be hidden, if applicable.
 * @property background Optional background image url.
 */
@Serializable
public data class BrawlifyEventSlot(
    val id: Int,
    val name: String,
    val emoji: String,
    val hash: String,
    val listAlone: Boolean,
    val hideable: Boolean,
    val hideForSlot: Int? = null,
    val background: String? = null,
)
