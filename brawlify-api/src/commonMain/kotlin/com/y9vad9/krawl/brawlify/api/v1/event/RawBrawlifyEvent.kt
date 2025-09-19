package com.y9vad9.krawl.brawlify.api.v1.event

import kotlinx.serialization.Serializable

/**
 * Represents a single scheduled Brawl Stars event as provided by Brawlify.
 *
 * @property slot Metadata about the slot this event belongs to (e.g., Daily Showdown).
 * @property predicted Whether the event is a prediction or confirmed.
 * @property historyLength Amount of days (?) that has repeated.
 * @property startTime ISO-8601 timestamp when the event starts.
 * @property endTime ISO-8601 timestamp when the event ends.
 * @property reward Amount of tokens/points rewarded for participating.
 * @property map The map on which the event is played.
 * @property modifier Optional special event modifier (null if none).
 */
@Serializable
public data class RawBrawlifyEvent(
    val slot: RawBrawlifyEventSlot,
    val predicted: Boolean,
    val historyLength: Int? = null,
    val startTime: String,
    val endTime: String,
    val reward: Int,
    val map: RawBrawlifyMap,
    val modifier: String? = null
)
