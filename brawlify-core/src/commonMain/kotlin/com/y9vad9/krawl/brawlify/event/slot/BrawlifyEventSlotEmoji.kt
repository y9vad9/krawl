package com.y9vad9.krawl.brawlify.event.slot

import kotlin.jvm.JvmInline

/**
 * Represents a single emoji used for identifying or decorating Brawlify event slots.
 *
 * This value class wraps a [String] that must be a single emoji (grapheme cluster).
 *
 * Use the companion object factory methods to safely create instances with validation.
 *
 * @property rawString The raw emoji string representing this event slot emoji.
 */
@JvmInline
public value class BrawlifyEventSlotEmoji private constructor(
    public val rawString: String,
) {
    public companion object {
        // Regex to match a single grapheme cluster, which can represent an emoji.
        private val emojiRegex = Regex("""^\X$""", RegexOption.IGNORE_CASE)

        /**
         * Checks if the provided [value] is a valid single emoji.
         *
         * Validation requires:
         * - Exactly one or two Unicode code points (to allow for combined emojis).
         * - Matches a single grapheme cluster.
         * - Contains characters that are emoji-like in Unicode ranges.
         *
         * @param value The string to validate.
         * @return `true` if [value] is a single emoji, `false` otherwise.
         */
        public fun isValid(value: String): Boolean {
            return emojiRegex.matches(value) &&
                value.all { it.isEmojiLike() }
        }

        /**
         * Attempts to create a [BrawlifyEventSlotEmoji] from the given [value].
         *
         * @param value The candidate emoji string.
         * @return [Result.success] wrapping the [BrawlifyEventSlotEmoji] if valid,
         * or [Result.failure] with [IllegalArgumentException] if invalid.
         */
        public fun create(value: String): Result<BrawlifyEventSlotEmoji> {
            return if (isValid(value)) {
                Result.success(BrawlifyEventSlotEmoji(value))
            } else {
                Result.failure(IllegalArgumentException("Not a valid single emoji: '$value'"))
            }
        }

        /**
         * Creates a [BrawlifyEventSlotEmoji] from [value] or throws if invalid.
         *
         * @param value The emoji string to wrap.
         * @throws IllegalArgumentException if [value] is not a valid single emoji.
         * @return A valid [BrawlifyEventSlotEmoji] instance.
         */
        public fun createOrThrow(value: String): BrawlifyEventSlotEmoji =
            create(value).getOrThrow()

        /**
         * Creates a [BrawlifyEventSlotEmoji] from [value] or returns `null` if invalid.
         *
         * @param value The emoji string to wrap.
         * @return A [BrawlifyEventSlotEmoji] if valid, or `null` otherwise.
         */
        public fun createOrNull(value: String): BrawlifyEventSlotEmoji? =
            create(value).getOrNull()
    }
}

/**
 * Checks whether the character [this] falls within typical Unicode ranges used for emoji symbols.
 *
 * This helper extension supports the emoji validation logic in [BrawlifyEventSlotEmoji].
 *
 * @receiver The character to test.
 * @return `true` if the character is emoji-like, `false` otherwise.
 */
@Suppress("detekt.MagicNumber")
private fun Char.isEmojiLike(): Boolean {
    val codePoint = this.code
    return when (codePoint) {
        in 0x2190..0x21FF,     // Arrows
        in 0x2600..0x27BF,     // Misc symbols
        in 0x1F300..0x1F6FF,   // Emoji symbols
        in 0x1F900..0x1F9FF,   // Supplemental symbols
        in 0x1FA70..0x1FAFF,   // Symbols & pictographs
        in 0x1F1E6..0x1F1FF    // Flags (regional indicators)
        -> true
        else -> false
    }
}
