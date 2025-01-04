package com.y9vad9.brawlstars.types.player

import com.y9vad9.brawlstars.annotations.ExperimentalBSLibApi
import com.y9vad9.brawlstars.internal.DurationFromSecondsSerializer
import com.y9vad9.brawlstars.types.brawler.Brawler
import com.y9vad9.brawlstars.types.club.Club
import com.y9vad9.brawlstars.types.club.ClubMember
import com.y9vad9.brawlstars.types.club.value.PlayerRole
import com.y9vad9.brawlstars.types.event.value.RankingPosition
import com.y9vad9.brawlstars.types.event.value.Trophies
import com.y9vad9.brawlstars.types.player.value.PlayerName
import com.y9vad9.brawlstars.types.player.value.PlayerTag
import com.y9vad9.brawlstars.types.value.Count
import com.y9vad9.brawlstars.types.value.HexColor
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration

@Serializable
public data class Player(
    val tag: PlayerTag,
    val name: PlayerName,
    val nameColor: HexColor,
    val icon: PlayerIcon,
    val trophies: Trophies,
    val highestTrophies: Trophies,
    val expLevel: Count,
    val expPoints: Count,
    val isQualifiedFromChampionshipChallenge: Boolean,
    @SerialName("3vs3Victories") val threeVsThreeVictories: Count,
    val soloVictories: Count,
    val duoVictories: Count,
    @Serializable(with = DurationFromSecondsSerializer::class)
    val bestRoboRumbleTime: Duration,
    @Serializable(with = DurationFromSecondsSerializer::class)
    val bestTimeAsBigBrawler: Duration,
    val club: Club.View? = null,
    val brawlers: List<Brawler>,
) {
    @Serializable
    public data class Ranking(
        val tag: PlayerTag,
        val name: PlayerName,
        val icon: PlayerIcon,
        val trophies: Trophies,
        val rank: RankingPosition,
        val club: Club.View? = null,
    )
}

@ExperimentalBSLibApi
public fun Player.toClubMember(clubRole: PlayerRole = PlayerRole.UNKNOWN): ClubMember {
    return ClubMember(
        tag = tag,
        name = name,
        role = clubRole,
        trophies = trophies,
        icon = icon,
        nameColor = nameColor,
    )
}