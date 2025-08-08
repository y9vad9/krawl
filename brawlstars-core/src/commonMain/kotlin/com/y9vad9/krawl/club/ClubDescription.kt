package com.y9vad9.krawl.club

/**
 * Represents a Brawl Stars club's textual description.
 *
 * This is a value class that wraps the raw string content of a club's description
 * as returned by the Brawl Stars API. The description can contain any user-provided
 * text, including rules, contact information, club goals, or emojis.
 *
 * While the API does not enforce specific formatting rules, the description may
 * be subject to moderation or length limits.
 *
 * @property string The raw string content of the club description.
 */
@JvmInline
public value class ClubDescription(public val string: String)
