package com.y9vad9.krawl.brawlify.brawler

import com.y9vad9.krawl.brawler.StarPowerId
import com.y9vad9.krawl.brawler.StarPowerName
import com.y9vad9.krawl.brawlify.api.v1.brawler.RawBrawlifyBrawlerStarPower
import com.y9vad9.krawl.brawlify.BrawlifyDescription
import com.y9vad9.krawl.brawlify.BrawlifyHtmlDescription
import com.y9vad9.krawl.brawlify.BrawlifyRegularDescription
import com.y9vad9.krawl.brawlify.BrawlifyUrl

/**
 * Represents a Star Power ability of a Brawler in Brawlify's data model.
 *
 * Star Powers are special passive abilities that enhance a brawler's capabilities
 * and are typically unlocked after reaching a specific level.
 *
 * @property id Unique identifier of the Star Power.
 * @property name Human-readable name of the Star Power.
 * @property description Text description explaining the effect of the Star Power.
 * @property imageUrl URL pointing to the visual icon of the Star Power.
 * @property isReleased Whether the Star Power is currently available in the game.
 */
public data class BrawlifyBrawlerStarPower(
    public val id: StarPowerId,
    public val name: StarPowerName,
    public val description: BrawlifyDescription,
    public val imageUrl: BrawlifyUrl,
    public val isReleased: Boolean,
)

/**
 * Converts this [RawBrawlifyBrawlerStarPower] into its validated and typed counterpart [BrawlifyBrawlerStarPower].
 *
 * @return the corresponding [BrawlifyBrawlerStarPower] instance
 * @throws IllegalArgumentException if any validation fails or contract is broken
 */
public fun RawBrawlifyBrawlerStarPower.toTypedOrThrow(): BrawlifyBrawlerStarPower =
    BrawlifyBrawlerStarPower(
        id = StarPowerId.createOrThrow(id),
        name = StarPowerName(name),
        description = BrawlifyDescription(
            regular = BrawlifyRegularDescription(description),
            html = BrawlifyHtmlDescription(descriptionHtml),
        ),
        imageUrl = BrawlifyUrl.createOrThrow(imageUrl),
        isReleased = released,
    )

/**
 * Attempts to convert this [RawBrawlifyBrawlerStarPower] into its typed counterpart [BrawlifyBrawlerStarPower].
 *
 * @return the validated [BrawlifyBrawlerStarPower], or `null` if conversion fails
 */
public fun RawBrawlifyBrawlerStarPower.toTypedOrNull(): BrawlifyBrawlerStarPower? =
    try { toTypedOrThrow() } catch (_: Throwable) { null }
