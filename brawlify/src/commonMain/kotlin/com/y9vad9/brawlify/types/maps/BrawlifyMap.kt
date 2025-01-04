package com.y9vad9.brawlify.types.maps

import com.y9vad9.brawlify.internal.InstantFromUnixMillisecondsSerializer
import com.y9vad9.brawlify.types.events.BrawlifyGameMode
import com.y9vad9.brawlify.types.events.value.BrawlifyUrl
import com.y9vad9.brawlify.types.maps.value.BrawlifyEnvironmentId
import com.y9vad9.brawlify.types.maps.value.BrawlifyEnvironmentName
import com.y9vad9.brawlify.types.stats.BrawlifyBrawlerStat
import com.y9vad9.brawlify.types.stats.BrawlifyTeamStat
import com.y9vad9.brawlify.types.value.BrawlifyHash
import com.y9vad9.brawlify.types.value.BrawlifyVersion
import com.y9vad9.brawlstars.types.event.value.EventId
import com.y9vad9.brawlstars.types.event.value.MapName
import com.y9vad9.brawlstars.types.player.value.PlayerName
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
public data class BrawlifyMap(
    val id: EventId,
    val new: Boolean,
    val disabled: Boolean,
    val name: MapName,
    val version: BrawlifyVersion,
    /**
     * The link pointing to the information page on [brawlify](https://brawlify.com).
     */
    val link: BrawlifyUrl,
    /**
     * The link pointing to the image of the in-game map.
     */
    val imageUrl: BrawlifyUrl,
    val credit: PlayerName? = null,
    val environment: Environment,
    val gameMode: BrawlifyGameMode,
    @Serializable(with = InstantFromUnixMillisecondsSerializer::class)
    val dataUpdated: Instant,
    @Serializable(with = InstantFromUnixMillisecondsSerializer::class)
    val lastActive: Instant?,
    val stats: List<BrawlifyBrawlerStat> = emptyList(),
    val teamStats: List<BrawlifyTeamStat> = emptyList(),
) {
    @Serializable
    public data class Environment(
        val id: BrawlifyEnvironmentId,
        val name: BrawlifyEnvironmentName,
        val hash: BrawlifyHash,
        val version: BrawlifyVersion,
        /**
         * The link pointing environmental specific image that
         * represents [Environment] in-game.
         */
        val imageUrl: BrawlifyUrl,
    )
}