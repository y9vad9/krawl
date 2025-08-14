package com.y9vad9.krawl.api.v1.player

import kotlinx.serialization.Serializable

/**
 * Represents a player's club affiliation in Brawl Stars.
 *
 * Contains basic information about the club the player belongs to.
 *
 * @property tag The unique club tag identifier, used for referencing the club.
 * @property name The display name of the club.
 */
@Serializable
public data class PlayerClub(
    val tag: String,
    val name: String,
)
