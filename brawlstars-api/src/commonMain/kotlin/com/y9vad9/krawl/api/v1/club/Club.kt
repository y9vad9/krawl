package com.y9vad9.krawl.api.v1.club

import kotlinx.serialization.Serializable

@Serializable
public data class Club(
    public val tag: String,
    public val name: String,
    public val description: String,
    public val trophies: Int,
    public val requiredTrophies: Int,
    public val members: List<ClubMember>,
    public val type: String,
    public val badgeId: Int,
)