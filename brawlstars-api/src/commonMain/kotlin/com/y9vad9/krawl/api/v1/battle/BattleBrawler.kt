package com.y9vad9.krawl.api.v1.battle

import kotlinx.serialization.Serializable

/**
 * Represents a minimal snapshot of a brawler as found inside battle payloads.
 *
 * @property id The numeric brawler ID (e.g., 16000000). Can be null.
 * @property name The human-readable name of the brawler. Can be null.
 * @property power The brawler's power level. Can be -1 for bots or unknown. Can be null.
 * @property trophies The number of trophies on the brawler at the time of the match.
 *                    Can be -1 if it’s a friendly battle or unknown.
 *                    In ranked game modes, this field can also represent the ranked stage.
 *                    Can be null if unknown.
 */
@Serializable
public data class BattleBrawler(
    val id: Int? = null,
    val name: String? = null,
    val power: Int? = null,
    val trophies: Int? = null,
)
