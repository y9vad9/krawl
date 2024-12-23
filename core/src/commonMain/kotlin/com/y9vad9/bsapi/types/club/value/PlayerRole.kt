package com.y9vad9.bsapi.types.club.value

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class PlayerRole {
    @SerialName("president")
    PRESIDENT,

    @SerialName("not_member")
    NOT_MEMBER,

    @SerialName("member")
    MEMBER,

    @SerialName("vice_president")
    VICE_PRESIDENT,

    @SerialName("senior")
    SENIOR,

    @SerialName("unknown")
    UNKNOWN,
}