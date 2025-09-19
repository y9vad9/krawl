package com.y9vad9.krawl.event

import com.y9vad9.krawl.event.EventId.Companion.VALUE_RANGE
import com.y9vad9.krawl.event.EventId.Companion.create
import com.y9vad9.krawl.event.EventId.Companion.createOrNull
import com.y9vad9.krawl.event.EventId.Companion.createOrThrow
import kotlin.jvm.JvmInline

/**
 * Represents the unique identifier of a Brawl Stars event (e.g., for maps or game modes).
 *
 * This is a lightweight wrapper around an [Int], providing type safety and validation against known
 * valid event ID ranges. It can be constructed using [create], [createOrThrow], or [createOrNull],
 * and compared using standard operators.
 *
 * @property rawInt The raw integer ID as returned by the Brawl Stars API.
 */
@JvmInline
public value class EventId(public val rawInt: Int) : Comparable<EventId> {
    override fun compareTo(other: EventId): Int = rawInt.compareTo(other.rawInt)

    public companion object {
        /**
         * Minimum valid event ID observed in the official Brawl Stars API.
         */
        public const val MIN_VALUE: Int = 15_000_000

        /**
         * Maximum valid event ID observed in the official Brawl Stars API.
         */
        public const val MAX_VALUE: Int = 15_100_000

        /**
         * The inclusive range of known valid event IDs.
         */
        public val VALUE_RANGE: IntRange = MIN_VALUE..MAX_VALUE

        /**
         * Attempts to construct an [EventId] from the given integer.
         *
         * Returns a [Result.success] if the input is within the valid range.
         * Otherwise, returns a [Result.failure] with [IllegalArgumentException].
         *
         * This is the preferred way to construct an [EventId] when working with untrusted input.
         *
         * @param int The raw integer to wrap.
         * @return [Result] containing either a valid [EventId] or a failure.
         */
        public fun create(int: Int): Result<EventId> = if (isValid(int)) {
            Result.success(EventId(int))
        } else {
            Result.failure(IllegalArgumentException("Event ID $int is out of range: $VALUE_RANGE"))
        }

        /**
         * Constructs an [EventId] from the given integer, or throws if invalid.
         *
         * This function throws an [IllegalArgumentException] if the input is outside
         * the known [VALUE_RANGE]. Use this only when input validity is guaranteed.
         *
         * @throws IllegalArgumentException if [int] is not within [VALUE_RANGE].
         */
        public fun createOrThrow(int: Int): EventId = create(int).getOrThrow()

        /**
         * Attempts to construct an [EventId] or returns `null` if the input is invalid.
         *
         * @param int The integer to attempt wrapping.
         * @return A valid [EventId] or `null` if the value is out of range.
         */
        public fun createOrNull(int: Int): EventId? = create(int).getOrNull()

        /**
         * Checks whether the provided integer is a valid [EventId].
         *
         * @param int The integer to validate.
         * @return `true` if the integer is within [VALUE_RANGE], otherwise `false`.
         */
        public fun isValid(int: Int): Boolean = int in VALUE_RANGE
    }
}
