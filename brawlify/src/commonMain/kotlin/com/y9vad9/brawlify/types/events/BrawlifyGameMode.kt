package com.y9vad9.brawlify.types.events

import com.y9vad9.brawlify.types.events.value.BrawlifyGameModeId
import com.y9vad9.brawlify.types.events.value.BrawlifyGameModeName
import com.y9vad9.brawlify.types.events.value.BrawlifyUrl
import com.y9vad9.brawlify.types.value.BrawlifyHash
import com.y9vad9.brawlify.types.value.BrawlifyScId
import com.y9vad9.brawlify.types.value.BrawlifyVersion
import com.y9vad9.brawlstars.types.value.HexColor
import kotlinx.serialization.Serializable

@Serializable
public data class BrawlifyGameMode(
    val id: BrawlifyGameModeId? = null,
    val scId: BrawlifyScId,
    val name: BrawlifyGameModeName,
    val hash: BrawlifyHash,
    val version: BrawlifyVersion,
    val color: HexColor,
    val bgColor: HexColor,
    /**
     * The link pointing to the informational page on Brawlify.
     */
    val link: BrawlifyUrl,
    /**
     * The link pointing to the image that represents game mode.
     */
    val imageUrl: BrawlifyUrl,
)