package com.y9vad9.krawl.event

import com.y9vad9.krawl.event.EventSlotId.Companion.MIN_VALUE
import com.y9vad9.krawl.event.EventSlotId.Companion.create
import com.y9vad9.krawl.event.EventSlotId.Companion.createOrNull
import com.y9vad9.krawl.event.EventSlotId.Companion.createOrThrow
import com.y9vad9.krawl.event.EventSlotId.Companion.isValid
import kotlin.jvm.JvmInline

/**
 * Represents the unique identifier for an event slot in Brawl Stars.
 *
 * Event slot IDs are used to distinguish between concurrent game events such as
 * Showdown, Team Events, Power League, and limited-time modes. Each slot corresponds
 * to a position in the game's event rotation schedule.
 *
 * A valid [EventSlotId] is any integer greater than or equal to [MIN_VALUE], where
 * `1` typically represents the first standard slot (e.g. Solo Showdown), and subsequent
 * values represent other slots in the rotation (e.g. Duo Showdown, 3v3, Challenges).
 *
 * Use one of the provided factory methods to safely create instances:
 * - [create] returns a [Result] encapsulating success or failure.
 * - [createOrNull] returns `null` if the value is invalid.
 * - [createOrThrow] throws an [IllegalArgumentException] on invalid input.
 *
 * Use [isValid] to check whether a given value is allowed.
 *
 * @property rawInt The underlying integer representing the event slot ID.
 */
@JvmInline
public value class EventSlotId private constructor(public val rawInt: Int) {
    public companion object {
        /** The minimum valid event slot ID. */
        public const val MIN_VALUE: Int = 1

        /**
         * Checks whether the given [value] is a valid [EventSlotId].
         *
         * @return `true` if the value is greater than or equal to [MIN_VALUE], otherwise `false`.
         */
        public fun isValid(value: Int): Boolean = value >= MIN_VALUE

        /**
         * Attempts to create a valid [EventSlotId] from the given [value].
         *
         * @return The resulting [EventSlotId] if valid, or `null` if the value is invalid.
         */
        public fun createOrNull(value: Int): EventSlotId? =
            if (isValid(value)) EventSlotId(value) else null

        /**
         * Creates a valid [EventSlotId] from the given [value].
         *
         * @return A [Result] containing the [EventSlotId] if valid,
         *         or an [IllegalArgumentException] if the input is invalid.
         */
        public fun create(value: Int): Result<EventSlotId> =
            if (isValid(value)) Result.success(EventSlotId(value))
            else Result.failure(IllegalArgumentException("Invalid EventSlotId: $value"))

        /**
         * Forces the creation of an [EventSlotId] from the given [value].
         *
         * @throws IllegalArgumentException if the input is invalid.
         * @return A valid [EventSlotId] instance.
         */
        @Throws(IllegalStateException::class)
        public fun createOrThrow(value: Int): EventSlotId =
            create(value).getOrThrow()
    }
}
