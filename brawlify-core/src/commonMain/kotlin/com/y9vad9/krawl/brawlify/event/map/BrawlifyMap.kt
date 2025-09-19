package com.y9vad9.krawl.brawlify.event.map

import com.y9vad9.krawl.brawlify.api.v1.event.RawBrawlifyMap
import com.y9vad9.krawl.brawlify.BrawlifyPathSegment
import com.y9vad9.krawl.brawlify.BrawlifyUrl
import com.y9vad9.krawl.brawlify.event.gamemode.BrawlifyGameModeView
import com.y9vad9.krawl.brawlify.event.gamemode.toTypedOrThrow
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
 * @property pathSegment Unique path-friendly identifier for the map, typically used for URLs or image references.
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
 * @property link Links to the Brawlify's Public CDN images / details page.
 */
public data class BrawlifyMap(
    public val eventId: EventId,
    public val name: MapName,
    public val pathSegment: BrawlifyPathSegment,
    public val version: BrawlifyMapVersion,
    public val conceptOwner: PlayerName?,
    public val gamemode: BrawlifyGameModeView,
    public val environment: BrawlifyMapEnvironment,
    public val statistics: List<BrawlifyMapBrawlerStatistics>,
    public val teamStatistics: List<BrawlifyMapBrawlerTeamStatistics>,
    public val lastActiveTime: Instant?,
    public val dataUpdateTime: Instant?,
    public val isNew: Boolean,
    public val isDisabled: Boolean,
    public val link: BrawlifyMapLink,
)

/**
 * Converts this [RawBrawlifyMap] into its typed and validated counterpart [BrawlifyMap].
 *
 * @return the corresponding [BrawlifyMap] instance
 * @throws IllegalArgumentException if any validation fails
 */
public fun RawBrawlifyMap.toTypedOrThrow(): BrawlifyMap =
    BrawlifyMap(
        eventId = EventId.createOrThrow(id),
        name = MapName(name),
        pathSegment = BrawlifyPathSegment(hash),
        version = BrawlifyMapVersion.createOrThrow(version),
        conceptOwner = credit?.let { PlayerName.createOrThrow(it) },
        gamemode = gameMode.toTypedOrThrow(),
        environment = environment.toTypedOrThrow(),
        statistics = stats.map { it.toTypedOrThrow() },
        teamStatistics = teamStats.map { it.toTypedOrThrow() },
        lastActiveTime = lastActive?.let { Instant.fromEpochSeconds(it) },
        dataUpdateTime = dataUpdated?.let { Instant.fromEpochSeconds(it) },
        isNew = new,
        isDisabled = disabled,
        link = BrawlifyMapLink(
            image = BrawlifyUrl.createOrThrow(imageUrl),
            details = BrawlifyUrl.createOrThrow(link),
        ),
    )

/**
 * Attempts to convert this [RawBrawlifyMap] into its typed counterpart [BrawlifyMap].
 *
 * @return the validated [BrawlifyMap], or `null` if conversion fails
 */
public fun RawBrawlifyMap.toTypedOrNull(): BrawlifyMap? =
    try { toTypedOrThrow() } catch (_: Throwable) { null }
