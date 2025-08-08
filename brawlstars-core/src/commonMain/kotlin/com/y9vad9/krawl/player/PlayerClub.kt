package com.y9vad9.krawl.player

import com.y9vad9.krawl.club.ClubName
import com.y9vad9.krawl.club.ClubTag

/**
 * Represents the core details of a Brawl Stars club.
 *
 * @property tag The validated club tag, uniquely identifying the club in the Brawl Stars ecosystem.
 * @property name The human-readable name of the club.
 *
 * While club names and tags are both visible in-game, only the tag is guaranteed unique. Team names may repeat.
 * Use this class to carry club identity within application logic in a type-safe manner.
 */
public data class PlayerClub(
    public val tag: ClubTag,
    public val name: ClubName,
)
