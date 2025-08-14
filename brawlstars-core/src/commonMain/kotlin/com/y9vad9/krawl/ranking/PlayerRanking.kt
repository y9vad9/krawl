package com.y9vad9.krawl.ranking

import com.y9vad9.krawl.club.ClubName
import com.y9vad9.krawl.common.HexColor
import com.y9vad9.krawl.player.PlayerIconId
import com.y9vad9.krawl.player.PlayerName
import com.y9vad9.krawl.player.PlayerTag

/**
 * ents a ranked player in a Brawl Stars leaderboard or club ranking.
 *
 * This model includes the player's identity and metadata relevant for ranking displays,
 * such as position, visual icon, and name color. It is typically used for displaying
 * top players in global, local, or club-based leaderboards.
 *
 * @property tag Unique identifier (tag) of the player (e.g. `#ABC123`).
 * @property name The display name of the player.
 * @property icon The identifier for the player's selected avatar icon.
 * @property nameColor The color used to render the player's name (hexadecimal).
 * @property rank The ranking position of the player (starting from 1).
 * @property clubName The name of the club the player currently belongs to.
 */
public data class PlayerRanking(
    public val tag: PlayerTag,
    public val name: PlayerName,
    public val icon: PlayerIconId,
    public val nameColor: HexColor,
    public val rank: RankingPosition,
    public val clubName: ClubName,
)
