package com.y9vad9.krawl.brawlify.gamedata

/**
 * Marks declarations that use the [Brawlify Game Data API](https://brawlapi.com/#/endpoints/game-data),
 * which is inherently unstable and may break at any time.
 *
 * This API provides access to parsed in-game data files (typically converted from `.csv` to JSON)
 * that are useful for building tools, analytics, or game-related features.
 *
 * > ⚠️ Warning: The structure and content of these files may change **drastically** between game updates,
 * often without notice. Consumers should design their integrations to tolerate schema changes and unexpected data.
 *
 * Use of this API in production code should be done with caution, and the annotated declarations
 * should be treated as experimental or volatile. On our side, we try to run tests regularly and
 * provide the best out-of-box experience.
 *
 * **Recommendation**: ensure that anything returned via this API is immediately cached and in case of
 * parse errors in future last accessible cached version of the response is used.
 */
@RequiresOptIn(
    message = "This API relies on unstable game data endpoints and may break between updates. Use with caution.",
    level = RequiresOptIn.Level.WARNING,
)
public annotation class UnstableBrawlifyGameDataApi
