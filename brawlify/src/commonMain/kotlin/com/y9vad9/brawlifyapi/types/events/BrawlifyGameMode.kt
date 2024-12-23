package com.y9vad9.brawlifyapi.types.events

import com.y9vad9.brawlifyapi.types.common.value.BrawlifyHash
import com.y9vad9.brawlifyapi.types.common.value.BrawlifyHexColor
import com.y9vad9.brawlifyapi.types.common.value.BrawlifyVersion
import com.y9vad9.brawlifyapi.types.events.value.BrawlifyGameModeId
import com.y9vad9.brawlifyapi.types.events.value.BrawlifyGameModeName
import com.y9vad9.brawlifyapi.types.events.value.BrawlifyUrl
import kotlinx.serialization.Serializable

@Serializable
public data class BrawlifyGameMode(
    val id: BrawlifyGameModeId,
    val name: BrawlifyGameModeName,
    val hash: BrawlifyHash,
    val version: BrawlifyVersion,
    val color: BrawlifyHexColor,
    val bgColor: BrawlifyHexColor,
    /**
     * The link pointing to the informational page on Brawlify.
     */
    val link: BrawlifyUrl,
    /**
     * The link pointing to the image that represents game mode.
     */
    val imageUrl: BrawlifyUrl,
)