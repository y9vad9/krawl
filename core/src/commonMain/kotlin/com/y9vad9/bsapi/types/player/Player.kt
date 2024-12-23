package com.y9vad9.bsapi.types.player

import com.y9vad9.bsapi.annotations.ExperimentalBSLibApi
import com.y9vad9.bsapi.types.brawler.Brawler
import com.y9vad9.bsapi.types.club.Club
import com.y9vad9.bsapi.types.club.ClubMember
import com.y9vad9.bsapi.types.club.value.PlayerRole
import com.y9vad9.bsapi.types.common.value.Count
import com.y9vad9.bsapi.types.event.value.RankingPosition
import com.y9vad9.bsapi.types.event.value.Trophies
import com.y9vad9.bsapi.types.player.value.PlayerName
import com.y9vad9.bsapi.types.player.value.PlayerTag
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Player(
    val tag: PlayerTag,
    val name: PlayerName,
    val icon: PlayerIcon,
    val trophies: Trophies,
    val highestTrophies: Trophies,
    val expLevel: Count,
    val expPoints: Count,
    val isQualifiedFromChampionshipChallenge: Boolean,
    @SerialName("3vs3Victories") val threeVsThreeVictories: Count,
    val soloVictories: Count,
    val duoVictories: Count,
    val bestRoboRumbleTime: Count,
    val bestTimeAsBigBrawler: Count,
    val club: Club.View?,
    val brawlers: List<Brawler>,
) {
    @Serializable
    public data class Ranking(
        val tag: PlayerTag,
        val name: PlayerName,
        val icon: PlayerIcon,
        val trophies: Trophies,
        val rank: RankingPosition,
        val club: Club.View,
    )
}

@ExperimentalBSLibApi
public fun Player.toClubMember(): ClubMember {
    return ClubMember(
        tag = tag,
        name = name,
        role = PlayerRole.UNKNOWN,
        trophies = trophies,
        icon = icon,
    )
}