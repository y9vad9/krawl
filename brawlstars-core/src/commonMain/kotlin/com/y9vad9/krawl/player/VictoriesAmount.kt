package com.y9vad9.krawl.player

import com.y9vad9.krawl.player.VictoriesAmount.Companion.create
import com.y9vad9.krawl.player.VictoriesAmount.Companion.createOrNull
import com.y9vad9.krawl.player.VictoriesAmount.Companion.createOrThrow
import kotlin.jvm.JvmInline

/**
 * Represents the number of victories a Brawl Stars player has achieved.
 *
 * Victories are accumulated through successful battles in various game modes.
 * This value class ensures the count is always non-negative.
 *
 * Use the [create], [createOrThrow], or [createOrNull] methods to construct valid instances.
 *
 * @property int The raw integer value of victories (guaranteed to be ≥ 0).
 */
@JvmInline
public value class VictoriesAmount private constructor(public val int: Int) : Comparable<VictoriesAmount> {

    public companion object {
        private const val ERROR = "Victory count must be zero or greater."

        /**
         * Checks whether the given victory count is valid.
         *
         * A valid victory count is a non-negative integer.
         *
         * @param input The number of victories to validate.
         * @return `true` if the input is valid, `false` otherwise.
         */
        public fun isValid(input: Int): Boolean = input >= 0

        /**
         * Creates a [VictoriesAmount] if the [input] is valid (non-negative).
         *
         * @param input The number of victories to wrap.
         * @return [Result.success] with [VictoriesAmount], or [Result.failure]
         * with [IllegalArgumentException] if invalid.
         */
        public fun create(input: Int): Result<VictoriesAmount> =
            if (isValid(input)) Result.success(VictoriesAmount(input))
            else Result.failure(IllegalArgumentException(ERROR))

        /**
         * Creates a [VictoriesAmount] or throws [IllegalArgumentException] if the input is invalid.
         *
         * @param input The number of victories to wrap.
         * @return A valid [VictoriesAmount] instance.
         * @throws IllegalArgumentException if [input] is negative.
         */
        public fun createOrThrow(input: Int): VictoriesAmount =
            create(input).getOrThrow()

        /**
         * Creates a [VictoriesAmount], or returns `null` if the input is invalid.
         *
         * @param input The number of victories to wrap.
         * @return A valid [VictoriesAmount], or `null` if [input] is negative.
         */
        public fun createOrNull(input: Int): VictoriesAmount? =
            create(input).getOrNull()
    }

    /**
     * Compares this [VictoriesAmount] with another by numeric value.
     */
    override fun compareTo(other: VictoriesAmount): Int = int.compareTo(other.int)

    /**
     * Adds another [VictoriesAmount] to this one.
     *
     * @param other The amount to add.
     * @return A new [VictoriesAmount] representing the sum.
     * @throws IllegalArgumentException if the result is negative (overflow).
     */
    public operator fun plus(other: VictoriesAmount): VictoriesAmount =
        createOrThrow(this.int + other.int)

    /**
     * Subtracts another [VictoriesAmount] from this one.
     *
     * @param other The amount to subtract.
     * @return A new [VictoriesAmount] representing the difference.
     * @throws IllegalArgumentException if the result is negative.
     */
    public operator fun minus(other: VictoriesAmount): VictoriesAmount =
        createOrThrow(this.int - other.int)

    /**
     * Returns the string representation of the victory count.
     */
    override fun toString(): String = int.toString()
}
