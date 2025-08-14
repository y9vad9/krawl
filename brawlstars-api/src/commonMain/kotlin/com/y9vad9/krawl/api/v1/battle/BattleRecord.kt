package com.y9vad9.krawl.api.v1.battle

import kotlinx.serialization.json.JsonObject

/**
 * Represents a single battle record as returned by the API.
 *
 * @property battleTime The timestamp of when the battle occurred, as a raw string.
 * @property event The event metadata associated with this battle.
 * @property battle The detailed battle data including participants, results, and other info.
 * @property rawJsonObject The raw JSON object of the entire battle record, allowing access to
 *   any additional or unexpected data fields not modeled explicitly.
 */
public data class BattleRecord(
    public val battleTime: String,
    public val event: BattleEvent,
    public val battle: BattleDetails,
    public val rawJsonObject: JsonObject,
)
