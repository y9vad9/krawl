package com.y9vad9.krawl.brawlify.event.map.statistics

/**
 * Represents the name of a team in Brawlify context, typically used in ranked or competition-based events.
 *
 * This value class wraps a raw string that holds the team’s display name. Team names may appear in
 * community tournaments, map concept credits, or leaderboard data.
 *
 * @property rawString Raw name of the team, as returned by the Brawlify API or inferred from metadata.
 */
@JvmInline
public value class BrawlifyTeamName(public val rawString: String)
