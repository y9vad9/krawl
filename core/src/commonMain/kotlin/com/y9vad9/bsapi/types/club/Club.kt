package com.y9vad9.bsapi.types.club

import com.y9vad9.bsapi.types.club.value.ClubBadgeId
import com.y9vad9.bsapi.types.club.value.ClubName
import com.y9vad9.bsapi.types.club.value.ClubTag
import com.y9vad9.bsapi.types.club.value.ClubType
import com.y9vad9.bsapi.types.event.value.RankingPosition
import com.y9vad9.bsapi.types.event.value.Trophies
import kotlinx.serialization.Serializable

@Serializable
public data class Club(
    val tag: ClubTag,
    val name: ClubName,
    val description: String,
    val requiredTrophies: Trophies,
    val badgeId: ClubBadgeId,
    val trophies: Trophies,
    val type: ClubType,
    val members: List<ClubMember>,
) {
    @Serializable
    public data class View(
        // not exist only in the top ranking list
        val tag: ClubTag? = null,
        val name: ClubName,
    )

    @Serializable
    public data class Ranking(
        val clubTag: ClubTag,
        val name: ClubName,
        val trophies: Trophies,
        val rank: RankingPosition,
    )
}

public val Club.hasFreeSeats: Boolean get() = members.size < 30

public fun Club.toView(): Club.View {
    return Club.View(
        tag = tag,
        name = name,
    )
}
