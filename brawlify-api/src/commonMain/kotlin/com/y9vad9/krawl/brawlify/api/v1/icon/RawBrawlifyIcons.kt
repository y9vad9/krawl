package com.y9vad9.krawl.brawlify.api.v1.icon

import kotlinx.serialization.Serializable

/**
 * Represents a collection of Brawlify icons for players and clubs.
 *
 * @property player Map of player icons, each represented by [RawBrawlifyPlayerIcon].
 *                  Key represents an ID of the icon.
 * @property club Map of club badges, each represented by [RawBrawlifyClubBadge].
 *                Key represents an ID of the icon.
 */
@Serializable
public data class RawBrawlifyIcons(
    public val player: Map<String, RawBrawlifyPlayerIcon>,
    public val club: Map<String, RawBrawlifyClubBadge>,
)
