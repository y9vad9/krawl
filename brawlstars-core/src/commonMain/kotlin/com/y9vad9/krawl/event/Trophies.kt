package com.y9vad9.krawl.event

import com.y9vad9.krawl.ExperimentalKrawlApi
import com.y9vad9.krawl.event.battle.TrophyChange

/**
 * Represents the number of trophies a Brawl Stars player has.
 *
 * Trophies are a core metric representing player progress and skill
 * in various game modes. This value class provides type safety and
 * comparability based on the integer trophy count.
 *
 * Note: This class does not enforce validation on the trophy count.
 * It assumes the value is meaningful within the game's context.
 *
 * @property rawInt The raw trophy count.
 */
@JvmInline
public value class Trophies private constructor(public val rawInt: Int) : Comparable<Trophies> {

    /**
     * Compares this trophy count with another.
     *
     * @param other The other [Trophies] instance to compare to.
     * @return A negative integer, zero, or positive integer depending on comparison result.
     */
    override fun compareTo(other: Trophies): Int = rawInt.compareTo(other.rawInt)

    /**
     * Adds another trophy count to this one.
     *
     * @param other The other [Trophies] to add.
     * @return A new [Trophies] instance representing the total.
     */
    public operator fun plus(other: Trophies): Trophies = createOrThrow(this.rawInt + other.rawInt)

    /**
     * Subtracts another trophy count from this one.
     *
     * This operator is marked as _experimental_ because its behavior—throwing an exception
     * when the result is negative—may be surprising and is subject to change.
     *
     * Use with caution and ensure the result will not fall below zero, or prefer safe alternatives.
     *
     * @param other The [Trophies] value to subtract.
     * @return A new [Trophies] instance representing the non-negative difference.
     * @throws IllegalArgumentException if the result is negative.
     */
    @Throws(IllegalArgumentException::class)
    @ExperimentalKrawlApi
    public operator fun minus(other: Trophies): Trophies = createOrThrow(this.rawInt - other.rawInt)

    /**
     * Applies a trophy change (gain or loss) to the current [Trophies] value.
     *
     * This method assumes the resulting value must remain non-negative.
     * If the applied change would result in a negative trophy count, an exception is thrown.
     *
     * @param change The [TrophyChange] to apply.
     * @return A new [Trophies] instance with the change applied.
     * @throws IllegalArgumentException if the resulting trophy count would be negative.
     */
    @Throws(IllegalArgumentException::class)
    public fun withChangeOrThrow(change: TrophyChange): Trophies = createOrThrow(this.rawInt + change.rawInt)

    /**
     * Returns the trophy count as a string.
     */
    override fun toString(): String = rawInt.toString()

    public companion object {
        /** Minimum valid trophy count. */
        public const val MIN_VALUE: Int = 0

        /**
         * Returns `true` if the given [value] is valid for [Trophies].
         */
        public fun isValid(value: Int): Boolean = value >= MIN_VALUE

        /**
         * Returns a [Trophies] instance if the [value] is valid; otherwise `null`.
         */
        public fun createOrNull(value: Int): Trophies? =
            if (isValid(value)) Trophies(value) else null

        /**
         * Returns a [Result] containing a [Trophies] instance or [IllegalArgumentException].
         */
        public fun create(value: Int): Result<Trophies> =
            if (isValid(value)) Result.success(Trophies(value))
            else Result.failure(IllegalArgumentException("Invalid trophy count: $value"))

        /**
         * Returns a [Trophies] instance or throws [IllegalArgumentException] if invalid.
         */
        public fun createOrThrow(value: Int): Trophies =
            create(value).getOrThrow()
    }
}
