package com.y9vad9.krawl.brawlify.gamedata

/**
 * Marks declarations that are part of the experimental Brawlify Game Data API.
 *
 * APIs annotated with this marker are considered unstable and may change or be removed at any time without notice.
 * Use of these APIs requires explicit opt-in, acknowledging the risk of future breakage.
 *
 * This is typically used for functionality based on evolving or unofficial game data formats,
 * or for features under active development within the Brawlify integration layer.
 *
 * @see RequiresOptIn
 */
@RequiresOptIn(
    message = "This API is considered experimental, therefore can be removed or changed at any time.",
    level = RequiresOptIn.Level.ERROR,
)
public annotation class ExperimentalBrawlifyGameDataApi
