package com.y9vad9.krawl.brawlify.event.gamemode

import com.y9vad9.krawl.brawlify.api.v1.event.RawBrawlifyGameModeView
import com.y9vad9.krawl.brawlify.BrawlifyPathSegment
import com.y9vad9.krawl.brawlify.BrawlifyUrl
import com.y9vad9.krawl.common.HexColor

/**
 * Represents a game mode within Brawl Stars.
 *
 * @property id The unique identifier for the game mode.
 * @property name The human-readable name of the game mode.
 * @property pathSegment A hash string associated with the game mode, used for identification or integrity checks.
 * @property version The version number of the game mode data.
 * @property color The associated color theme for this game mode, used for UI or representation.
 * @property link A reference link providing additional information about the game mode.
 */
public data class BrawlifyGameModeView(
    public val id: BrawlifyGameModeId,
    public val name: BrawlifyGameModeName,
    public val pathSegment: BrawlifyPathSegment,
    public val version: BrawlifyGameModeVersion,
    public val color: BrawlifyGameModeColor,
    public val link: BrawlifyGameModeLink,
)

/**
 * Converts this [RawBrawlifyGameModeView] into its typed and validated counterpart [BrawlifyGameMode].
 *
 * @return the corresponding [BrawlifyGameMode] instance
 * @throws IllegalArgumentException if any validation fails or the contract is broken
 */
public fun RawBrawlifyGameModeView.toTypedOrThrow(): BrawlifyGameModeView =
    BrawlifyGameModeView(
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
    )

/**
 * Attempts to convert this [RawBrawlifyGameModeView] into its typed counterpart [BrawlifyGameMode].
 *
 * @return the validated [BrawlifyGameMode], or `null` if conversion fails
 */
public fun RawBrawlifyGameModeView.toTypedOrNull(): BrawlifyGameModeView? =
    try { toTypedOrThrow() } catch (_: Throwable) { null }
