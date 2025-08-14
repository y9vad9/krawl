package com.y9vad9.krawl.brawlify.common

import kotlin.jvm.JvmInline

/**
 * A value class representing an HTML-formatted description string from Brawlify.
 *
 * This type is used to wrap raw HTML description content retrieved from Brawlify game data,
 * such as descriptions for brawlers, gadgets, or abilities.
 *
 * Consumers should treat this as preformatted HTML suitable for display in UI elements that support HTML rendering.
 * Use [fromPlainText] to safely convert plain user-generated text into an HTML-safe description.
 *
 * @property rawString The raw HTML string content.
 */
@JvmInline
public value class BrawlifyHtmlDescription(
    public val rawString: String,
) {
    public companion object {
        /**
         * Escapes special characters in the given [text] to produce a safe HTML-encoded [BrawlifyHtmlDescription].
         *
         * This ensures that the input is safe to include in HTML content by replacing special characters like:
         * - `&` → `&amp;`
         * - `<` → `&lt;`
         * - `>` → `&gt;`
         * - `"` → `&quot;`
         * - `'` → `&#39;`
         *
         * @param text Plain input text that may contain unsafe HTML characters.
         * @return An instance of [BrawlifyHtmlDescription] containing escaped content safe for HTML rendering.
         */
        public fun fromPlainText(text: String): BrawlifyHtmlDescription {
            val escaped = buildString(text.length) {
                for (ch in text) {
                    when (ch) {
                        '&' -> append("&amp;")
                        '<' -> append("&lt;")
                        '>' -> append("&gt;")
                        '"' -> append("&quot;")
                        '\'' -> append("&#39;")
                        else -> append(ch)
                    }
                }
            }
            return BrawlifyHtmlDescription(escaped)
        }
    }
}
