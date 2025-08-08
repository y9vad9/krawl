@file:OptIn(ExperimentalTime::class)

package com.y9vad9.krawl.event

import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * Represents a scheduled Brawl Stars event instance with a fixed start and end time,
 * assigned to a specific event slot, and linked to the official event details.
 *
 * @property startTime The timestamp when the event begins.
 * @property endTime The timestamp when the event ends.
 * @property slotId The identifier of the event slot this event occupies.
 * @property details The official event details (mode, map, ID).
 *
 * Validation:
 * - [startTime] must be less than or equal to [endTime].
 */
@ConsistentCopyVisibility
public data class ScheduledEvent private constructor(
    public val startTime: Instant,
    public val endTime: Instant,
    public val slotId: EventSlotId,
    public val details: OfficialEvent,
) {
    public companion object {
        private const val ERROR = "startTime must not be after endTime"

        /**
         * Creates a [ScheduledEvent] if the inputs are valid.
         *
         * @param startTime The start time of the event.
         * @param endTime The end time of the event.
         * @param slotId The event slot ID.
         * @param details The official event details.
         * @return A [Result] containing the [ScheduledEvent] or an [IllegalArgumentException] if validation fails.
         */
        public fun create(
            startTime: Instant,
            endTime: Instant,
            slotId: EventSlotId,
            details: OfficialEvent
        ): Result<ScheduledEvent> =
            if (startTime <= endTime) {
                Result.success(ScheduledEvent(startTime, endTime, slotId, details))
            } else {
                Result.failure(IllegalArgumentException(ERROR))
            }

        /**
         * Creates a [ScheduledEvent] or throws [IllegalArgumentException] if validation fails.
         */
        public fun createOrThrow(
            startTime: Instant,
            endTime: Instant,
            slotId: EventSlotId,
            details: OfficialEvent
        ): ScheduledEvent = create(startTime, endTime, slotId, details).getOrThrow()

        /**
         * Creates a [ScheduledEvent] or returns `null` if validation fails.
         */
        public fun createOrNull(
            startTime: Instant,
            endTime: Instant,
            slotId: EventSlotId,
            details: OfficialEvent
        ): ScheduledEvent? = create(startTime, endTime, slotId, details).getOrNull()
    }
}
