package com.y9vad9.brawlifyapi.types.events

import com.y9vad9.brawlifyapi.types.common.value.*
import com.y9vad9.bsapi.types.common.value.HexColor
import com.y9vad9.brawlifyapi.types.events.value.BrawlifyGameModeId
import com.y9vad9.brawlifyapi.types.events.value.BrawlifyGameModeName
import com.y9vad9.brawlifyapi.types.events.value.BrawlifyUrl
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class BrawlifyFullGameMode(
    val id: BrawlifyGameModeId? = null,
    val scId: BrawlifyScId,
    val name: BrawlifyGameModeName,
    val hash: BrawlifyHash,
    val scHash: BrawlifyHash,
    val version: BrawlifyVersion,
    val color: HexColor,
    val bgColor: HexColor,
    val description: BrawlifyDescription,
    val shortDescription: BrawlifyDescription,
    val title: BrawlifyTitle,
    /**
     * The link pointing to the informational page on Brawlify.
     */
    val link: BrawlifyUrl,
    /**
     * The link pointing to the image that represents game mode.
     */
    val imageUrl: BrawlifyUrl,
    @SerialName("imageUrl2")
    val headerImageUrl: BrawlifyUrl,
    @SerialName("TID")
    val tid: BrawlifyHash,
    val disabled: Boolean,
)