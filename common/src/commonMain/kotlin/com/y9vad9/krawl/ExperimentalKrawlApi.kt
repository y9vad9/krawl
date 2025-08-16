package com.y9vad9.krawl

/**
 * Marks a Krawl API as experimental and not guaranteed to remain stable.
 *
 * Any usage of APIs marked with this annotation requires an explicit opt-in.
 * These APIs may change, break, or be removed at any time without notice or replacement.
 * Use only if you are prepared to adapt to possible future changes.
 */
@RequiresOptIn(
    level = RequiresOptIn.Level.ERROR,
    message = "This is an experimental Krawl API and may change or be removed without prior notice."
)
public annotation class ExperimentalKrawlApi