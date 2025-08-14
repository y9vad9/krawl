package com.y9vad9.krawl.api.v1.player

import kotlinx.serialization.Serializable

/**
 * Represents a player's icon in Brawl Stars.
 *
 * Icons are visual badges players can display alongside their profile.
 *
 * @property id The unique identifier of the icon.
 */
@Serializable
public data class PlayerIcon(
    val id: Int,
)
