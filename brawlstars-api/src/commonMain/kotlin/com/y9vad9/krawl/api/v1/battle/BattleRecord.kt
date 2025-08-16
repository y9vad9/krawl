package com.y9vad9.krawl.api.v1.battle

import kotlinx.serialization.Serializable

/**
 * Represents a single battle record as returned by the API.
 *
 * @property battleTime The timestamp of when the battle occurred, as a raw string.
 * @property event The event metadata associated with this battle.
 * @property battle The detailed battle data including participants, results, and other info.
 */
@Serializable
public data class BattleRecord(
    public val battleTime: String,
    public val event: BattleEvent,
    public val battle: BattleDetails,
)
