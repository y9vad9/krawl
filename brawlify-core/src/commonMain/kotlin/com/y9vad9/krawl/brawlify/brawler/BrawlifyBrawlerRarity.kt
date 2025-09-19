package com.y9vad9.krawl.brawlify.brawler

import com.y9vad9.krawl.brawlify.api.v1.brawler.RawBrawlifyBrawlerRarity
import com.y9vad9.krawl.common.HexColor

/**
 * Represents the rarity classification of a Brawler in Brawlify's data model.
 *
 * Rarity indicates how difficult a brawler is to obtain, ranging from common
 * to ultra legendary and special rarities.
 *
 * @property id Unique identifier for the rarity type.
 * @property name Human-readable name of the rarity (e.g., "Epic", "Mythic").
 * @property color Color that represents this rarity.
 */
public data class BrawlifyBrawlerRarity(
    public val id: BrawlifyBrawlerRarityId,
    public val name: BrawlifyBrawlerRarityName,
    public val color: HexColor,
)

/**
 * Converts this [RawBrawlifyBrawlerRarity] into its validated and
 * typed counterpart [BrawlifyBrawlerRarity].
 */
public fun RawBrawlifyBrawlerRarity.toTypedOrThrow(): BrawlifyBrawlerRarity {
    return BrawlifyBrawlerRarity(
        id = BrawlifyBrawlerRarityId(id),
        name = BrawlifyBrawlerRarityName.from(name),
        color = HexColor.createOrThrow(color),
    )
}

/**
 * Converts this [RawBrawlifyBrawlerRarity] into its validated and
 * typed counterpart [BrawlifyBrawlerRarity] or returns null if it has failed.
 */
public fun RawBrawlifyBrawlerRarity.toTypedOrNull(): BrawlifyBrawlerRarity? =
    try { toTypedOrThrow() } catch (_: Throwable) { null }

/** Returns `true` if this rarity is common. */
public val BrawlifyBrawlerRarity.isCommon: Boolean
    get() = id.isCommon

/** Returns `true` if this rarity is rare. */
public val BrawlifyBrawlerRarity.isRare: Boolean
    get() = id.isRare

/** Returns `true` if this rarity is super rare. */
public val BrawlifyBrawlerRarity.isSuperRare: Boolean
    get() = id.isSuperRare

/** Returns `true` if this rarity is epic. */
public val BrawlifyBrawlerRarity.isEpic: Boolean
    get() = id.isEpic

/** Returns `true` if this rarity is mythic. */
public val BrawlifyBrawlerRarity.isMythic: Boolean
    get() = id.isMythic

/** Returns `true` if this rarity is legendary. */
public val BrawlifyBrawlerRarity.isLegendary: Boolean
    get() = id.isLegendary

/** Returns `true` if this rarity is ultra legendary. */
public val BrawlifyBrawlerRarity.isUltraLegendary: Boolean
    get() = id.isUltraLegendary
