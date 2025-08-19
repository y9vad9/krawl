package com.y9vad9.krawl.api.v1.club

import kotlinx.serialization.Serializable

/**
 * Represents a Brawl Stars club as returned by the official API.
 *
 * @property tag Unique tag identifier of the club (e.g., "#ABC123").
 * @property name Display name of the club.
 * @property description Free-form description written by the club’s leader.
 * @property trophies Total number of trophies accumulated by all club members.
 * @property requiredTrophies Minimum number of trophies a player must have to join the club.
 * @property members List of current members in the club.
 * @property type Join type of the club (e.g., "open", "inviteOnly", "closed").
 * @property badgeId Identifier of the club’s badge (used for visual representation).
 */
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
