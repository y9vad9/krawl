package com.y9vad9.krawl.brawlify.common

/**
 * Represents a composite description used in Brawlify metadata that includes both a plain text
 * version and an HTML-formatted version.
 *
 * This structure allows consumers to choose between displaying a simple description or rendering
 * rich HTML content, depending on the capabilities of the UI or target platform.
 *
 * @property regular The plain text version of the description.
 * @property html The HTML-formatted version of the description.
 */
public data class BrawlifyDescription(
    public val regular: BrawlifyRegularDescription,
    public val html: BrawlifyHtmlDescription,
)
