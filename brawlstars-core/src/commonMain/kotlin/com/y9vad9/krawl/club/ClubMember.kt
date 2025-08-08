package com.y9vad9.krawl.club

import com.y9vad9.krawl.event.Trophies
import com.y9vad9.krawl.player.PlayerIconId
import com.y9vad9.krawl.player.PlayerName
import com.y9vad9.krawl.common.PlayerNameColor
import com.y9vad9.krawl.player.PlayerTag

/**
 * Represents an individual member within a Brawl Stars Club.
 *
 * This data class encapsulates key details about a club member, including identity,
 * performance, and their role in the club.
 *
 * @property tag The unique identifier of the player.
 * @property name The in-game name of the player.
 * @property nameColor Color in the HEX format that is used for [name].
 * @property trophies The number of trophies the player contributes to the club.
 * @property role The player’s role within the club (e.g., president, member, senior).
 * @property iconId The identifier for the player’s selected profile icon.
 */
public data class ClubMember(
    public val tag: PlayerTag,
    public val name: PlayerName,
    public val nameColor: PlayerNameColor,
    public val trophies: Trophies,
    public val role: PlayerClubRole,
    public val iconId: PlayerIconId,
)
