package com.y9vad9.krawl.brawlify.icon

import com.y9vad9.krawl.brawlify.api.v1.icon.RawBrawlifyIcons
import com.y9vad9.krawl.club.ClubBadgeId
import com.y9vad9.krawl.player.PlayerIconId

/**
 * Represents all available icons on public Brawlify CDN.
 *
 * @property player Collection of player-related icons ([BrawlifyPlayerIcons]).
 * @property club Collection of club badges ([BrawlifyClubBadges]).
 */
public data class BrawlifyIcons(
    public val player: BrawlifyPlayerIcons,
    public val club: BrawlifyClubBadges,
)

/**
 * Converts this [RawBrawlifyIcons] instance into a strongly-typed [BrawlifyIcons].
 *
 * This function validates and wraps all raw player icons and club badges:
 * - Each **player icon** key is parsed into a [PlayerIconId] and the raw value is
 *   converted into a typed [BrawlifyPlayerIcon] using [RawBrawlifyPlayerIcon.toTypedOrThrow].
 * - Each **club badge** key is parsed into a [ClubBadgeId] and the raw value is
 *   converted into a typed [BrawlifyClubBadge] using [RawBrawlifyClubBadge.toTypedOrThrow].
 *
 * @throws IllegalArgumentException if any of the IDs cannot be parsed.
 * @throws IllegalStateException if an icon or badge cannot be converted into a valid typed object.
 * @return a fully-typed [BrawlifyIcons] instance.
 */
public fun RawBrawlifyIcons.toTypedOrThrow(): BrawlifyIcons = BrawlifyIcons(
    player = BrawlifyPlayerIcons(
        buildMap {
            player.forEach { (key, icon) ->
                put(PlayerIconId.createOrThrow(key.toInt()), icon.toTypedOrThrow())
            }
        }
    ),
    club = BrawlifyClubBadges(
        buildMap {
            club.forEach { (key, badge) ->
                put(ClubBadgeId.createOrThrow(key.toInt()), badge.toTypedOrThrow())
            }
        }
    ),
)

/**
 * Attempts to convert this [RawBrawlifyIcons] into a strongly-typed [BrawlifyIcons].
 *
 * This function behaves like [toTypedOrThrow], but instead of throwing exceptions when
 * encountering invalid IDs or malformed raw objects, it returns `null`.
 *
 * This is useful when parsing data from external sources where some entries might be
 * malformed or incomplete.
 *
 * @return the converted [BrawlifyIcons] instance, or `null` if validation or conversion fails.
 */
public fun RawBrawlifyIcons.toTypedOrNull(): BrawlifyIcons? =
    try { toTypedOrThrow() } catch (_: Throwable) { null }
