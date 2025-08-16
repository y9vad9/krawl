package com.y9vad9.krawl.api.v1.club

import com.y9vad9.krawl.api.v1.player.PlayerIcon
import kotlinx.serialization.Serializable

/**
 * Represents a member of a club.
 *
 * @property icon The player's icon.
 * @property tag The unique club tag of the member.
 * @property name The display name of the member.
 * @property trophies The number of trophies the member has.
 * @property role The member's role in the club (e.g., "Leader", "Member").
 * @property nameColor The display color of the member's name.
 */
@Serializable
public data class ClubMember(
    public val icon: PlayerIcon,
    public val tag: String,
    public val name: String,
    public val trophies: Int,
    public val role: String,
    public val nameColor: String,
)
