package com.y9vad9.krawl.brawlify.event.map

import com.y9vad9.krawl.brawlify.common.BrawlifyPathSegment
import com.y9vad9.krawl.brawlify.event.gamemode.BrawlifyGameMode
import com.y9vad9.krawl.brawlify.event.map.environment.BrawlifyMapEnvironment
import com.y9vad9.krawl.brawlify.event.map.statistics.BrawlifyMapBrawlerStatistics
import com.y9vad9.krawl.brawlify.event.map.statistics.BrawlifyMapBrawlerTeamStatistics
import com.y9vad9.krawl.event.EventId
import com.y9vad9.krawl.event.MapName
import com.y9vad9.krawl.player.PlayerName
import kotlin.time.Instant

/**
 * Represents a playable map in Brawl Stars, including its identity, metadata, gameplay environment,
 * and aggregated brawler performance statistics.
 *
 * This class is intended to provide a detailed view of a map within a specific event context,
 * including who created the map (if known), when it was last active, and whether it is currently disabled or new.
 *
 * @property eventId Identifier of the event slot this map is assigned to.
 * @property name Localized or canonical name of the map.
 * @property hash Unique path-friendly identifier for the map, typically used for URLs or image references.
 * @property version Internal version identifier used to track map revisions.
 * @property conceptOwner Optional name of the player who submitted or designed the map, if applicable.
 * @property gamemode The game mode this map is used for (e.g., Brawl Ball, Gem Grab).
 * @property environment The visual and thematic environment the map uses (e.g., Desert, Arcade).
 * @property statistics Aggregated brawler performance metrics on this map, such as win and use rates.
 * @property teamStatistics Aggregated brawlers teams perfomance metrics on this map, such as win and use rates.
 * @property lastActiveTime Timestamp indicating when the map was last seen in rotation or live use.
 * @property dataUpdateTime Timestamp of the last update to this map’s metadata or statistics.
 * @property isNew Whether the map is newly introduced and has not yet appeared in live rotation.
 * @property isDisabled Whether the map is currently disabled or unavailable for use in events.
 */
public data class BrawlifyMap(
    public val eventId: EventId,
    public val name: MapName,
    public val hash: BrawlifyPathSegment,
    public val version: BrawlifyMapVersion,
    public val conceptOwner: PlayerName?,
    public val gamemode: BrawlifyGameMode,
    public val environment: BrawlifyMapEnvironment,
    public val statistics: BrawlifyMapBrawlerStatistics,
    public val teamStatistics: BrawlifyMapBrawlerTeamStatistics,
    public val lastActiveTime: Instant,
    public val dataUpdateTime: Instant,
    public val isNew: Boolean,
    public val isDisabled: Boolean,
)
