package com.y9vad9.krawl.ranking

import com.y9vad9.krawl.club.ClubBadgeId
import com.y9vad9.krawl.club.ClubMembersCount
import com.y9vad9.krawl.club.ClubName
import com.y9vad9.krawl.club.ClubTag
import com.y9vad9.krawl.player.PlayerTrophies

/**
 * Represents the ranking details of a club on a Brawl Stars leaderboard.
 *
 * This includes identity and cosmetic information (e.g. name, tag, badge), performance metrics
 * (e.g. trophies and ranking position), and size (member count).
 *
 * This model is commonly used in club leaderboards at global or regional scopes.
 *
 * @property tag The unique identifier of the club, prefixed with '#'.
 * @property badgeId The cosmetic badge ID representing the club’s emblem.
 * @property name The display name of the club.
 * @property trophies The total number of trophies accumulated by the club.
 * @property rank The position of the club on the leaderboard (1-based).
 * @property membersCount The current number of members in the club.
 */
public data class ClubRanking(
    public val tag: ClubTag,
    public val badgeId: ClubBadgeId,
    public val name: ClubName,
    public val trophies: PlayerTrophies,
    public val rank: RankingPosition,
    public val membersCount: ClubMembersCount,
)
