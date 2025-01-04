package com.y9vad9.brawlstars.types.club.value

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ClubType {
    @SerialName("open")
    OPEN,

    @SerialName("invite_only")
    INVITE_ONLY,

    @SerialName("closed")
    CLOSED,

    @SerialName("unknown")
    UNKNOWN,
}