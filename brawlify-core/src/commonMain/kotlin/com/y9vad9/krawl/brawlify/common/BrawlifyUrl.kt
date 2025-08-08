package com.y9vad9.krawl.brawlify.common

/**
 * URL that is pointing to the brawlify website with a regular page.
 *
 * @property rawString Underlying string containing url.
 */
@JvmInline
public value class BrawlifyUrl private constructor(
    public val rawString: String,
) {
    public companion object {
        /**
         * Regular expression to validate supported Brawlify URLs.
         * Matches `https://brawlify.com/...` and `https://cdn.brawlify.com/...`.
         */
        public val format: Regex =
            Regex("""^https://([a-zA-Z0-9-]+\.)*brawlify\.com/.*$""")

        /**
         * Checks if the provided [value] is a valid Brawlify URL.
         * A valid URL starts with `https://brawlify.com/` or `https://cdn.brawlify.com/`.
         *
         * @return `true` if [value] matches the [format]; `false` otherwise.
         */
        public fun isValid(value: String): Boolean =
            format.matches(value)

        /**
         * Attempts to create a [BrawlifyUrl] from the given [value].
         *
         * @return [Result.success] if the [value] is a valid Brawlify URL,
         * or [Result.failure] with an [IllegalArgumentException] otherwise.
         */
        public fun create(value: String): Result<BrawlifyUrl> =
            if (isValid(value)) Result.success(BrawlifyUrl(value))
            else Result.failure(IllegalArgumentException("Invalid Brawlify URL: $value"))

        /**
         * Attempts to create a [BrawlifyUrl] from the given [value],
         * or returns `null` if the input is invalid.
         */
        public fun createOrNull(value: String): BrawlifyUrl? =
            create(value).getOrNull()

        /**
         * Attempts to create a [BrawlifyUrl] from the given [value],
         * or throws an [IllegalArgumentException] if the input is invalid.
         */
        public fun createOrThrow(value: String): BrawlifyUrl =
            create(value).getOrThrow()
    }
}
