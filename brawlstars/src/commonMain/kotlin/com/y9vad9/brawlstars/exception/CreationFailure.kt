package com.y9vad9.brawlstars.exception

/**
 * Represents a failure that occurs during the creation of an object.
 *
 * This class extends the `TimeMatesException` class and provides additional functionality
 * specific to creation failures.
 *
 * @property message The error message associated with the creation failure.
 */
public sealed class CreationFailure(message: String) : Exception(message) {
    /**
     * Represents a creation failure due to a size range constraint.
     */
    public data class RangeFailure(public val range: ClosedRange<*>) :
        CreationFailure("Constraint failure: size/value must be in range of $range")

    /**
     * Represents a creation failure due to an exact size constraint.
     */
    public data class SizeExactFailure(public val size: Int) :
        CreationFailure("Constraint failure: size must be exactly $size")

    /**
     * Represents a creation failure due to a minimum value constraint.
     */
    public data class MinValueFailure(public val size: Int) :
        CreationFailure("Constraint failure: minimal value is $size")

    /**
     * Represents a creation failure due to a blank value constraint.
     */
    public class BlankValueFailure : CreationFailure("Constraint failure: provided value is empty")

    /**
     * Represents a creation failure due to a pattern constraint.
     */
    public data class PatternFailure(public val regex: Regex) :
        CreationFailure("Constraint failure: input should match $regex")

    public data class DoesNotAcceptSuchValueFailure(
        public val accepts: List<Any>
    ) : CreationFailure("Constraint failure: accepts only $accepts")

    public companion object {
        /**
         * Creates a [RangeFailure] object with a size constraint failure message.
         *
         * @param size The size range constraint for the creation failure.
         * @return The [RangeFailure] object with the specified size constraint failure message.
         */
        public fun ofRange(size: ClosedRange<*>): CreationFailure {
            return RangeFailure(size)
        }

        /**
         * Creates a [SizeExactFailure] with a constraint failure message based on the provided size.
         *
         * @param size The expected size that caused the constraint failure.
         * @return A [SizeExactFailure] object with the constraint failure message.
         */
        public fun ofSizeExact(size: Int): CreationFailure {
            return SizeExactFailure(size)
        }

        /**
         * Creates a [MinValueFailure] with a constraint failure message for a minimum value.
         *
         * @param size The minimal value that caused the constraint failure.
         * @return A [MinValueFailure] object with the constraint failure message.
         */
        public fun ofMin(size: Int): CreationFailure {
            return MinValueFailure(size)
        }

        /**
         * Creates a [BlankValueFailure] with a constraint failure message for a blank value.
         *
         * @return A [BlankValueFailure] object with the constraint failure message.
         */
        public fun ofBlank(): CreationFailure {
            return BlankValueFailure()
        }

        /**
         * Creates a [PatternFailure] object with a pattern constraint failure message.
         *
         * @param regex The regular expression pattern constraint for the creation failure.
         * @return The [PatternFailure] object with the specified pattern constraint failure message.
         */
        public fun ofPattern(regex: Regex): CreationFailure {
            return PatternFailure(regex)
        }

        public fun acceptsOnly(values: List<Any>): CreationFailure {
            return DoesNotAcceptSuchValueFailure(values)
        }
    }
}