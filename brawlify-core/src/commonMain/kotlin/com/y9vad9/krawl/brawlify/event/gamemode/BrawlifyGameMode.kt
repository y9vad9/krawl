package com.y9vad9.krawl.brawlify.event.gamemode

import com.y9vad9.krawl.brawlify.api.v1.event.RawBrawlifyGameMode
import com.y9vad9.krawl.brawlify.api.v1.event.RawBrawlifyGameModeView
import com.y9vad9.krawl.brawlify.BrawlStarsTID
import com.y9vad9.krawl.brawlify.BrawlifyPathSegment
import com.y9vad9.krawl.brawlify.BrawlifyUrl
import com.y9vad9.krawl.common.HexColor
import kotlin.time.Instant

/**
 * Represents a game mode within Brawl Stars.
 *
 * @property id The unique identifier for the game mode.
 * @property name The human-readable name of the game mode.
 * @property pathSegment A hash string associated with the game mode, used for identification or integrity checks.
 * @property version The version number of the game mode data.
 * @property color The associated color theme for this game mode, used for UI or representation.
 * @property link A reference link providing additional information about the game mode.
 * @property lastActiveTime The last time the Game Mode appeared in events.
 * @property tid The internal Brawl Stars game identifier of the game mode.
 */
public data class BrawlifyGameMode(
    public val id: BrawlifyGameModeId,
    public val name: BrawlifyGameModeName,
    public val pathSegment: BrawlifyPathSegment,
    public val version: BrawlifyGameModeVersion,
    public val color: BrawlifyGameModeColor,
    public val link: BrawlifyGameModeLink,
    public val lastActiveTime: Instant?,
    public val tid: BrawlStarsTID,
)

/**
 * Converts this [RawBrawlifyGameModeView] into its typed and validated counterpart [BrawlifyGameMode].
 *
 * @return the corresponding [BrawlifyGameMode] instance
 * @throws IllegalArgumentException if any validation fails or the contract is broken
 */
public fun RawBrawlifyGameMode.toTypedOrThrow(): BrawlifyGameMode =
    BrawlifyGameMode(
        id = BrawlifyGameModeId.createOrThrow(scId),
        name = BrawlifyGameModeName(name),
        pathSegment = BrawlifyPathSegment(hash),
        version = BrawlifyGameModeVersion.createOrThrow(version),
        color = BrawlifyGameModeColor(
            background = HexColor.createOrThrow(bgColor),
            primary = HexColor.createOrThrow(color),
        ),
        link = BrawlifyGameModeLink(
            details = BrawlifyUrl.createOrThrow(link),
            image = BrawlifyUrl.createOrThrow(imageUrl),
        ),
        lastActiveTime = lastActive?.let { Instant.parse(it) },
        tid = BrawlStarsTID(tid),
    )

/**
 * Attempts to convert this [RawBrawlifyGameModeView] into its typed counterpart [BrawlifyGameMode].
 *
 * @return the validated [BrawlifyGameMode], or `null` if conversion fails
 */
public fun RawBrawlifyGameMode.toTypedOrNull(): BrawlifyGameMode? =
    try { toTypedOrThrow() } catch (_: Throwable) { null }
