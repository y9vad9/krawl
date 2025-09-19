package com.y9vad9.krawl.brawlify.brawler

import com.y9vad9.krawl.brawler.BrawlerId
import com.y9vad9.krawl.brawler.BrawlerName
import com.y9vad9.krawl.brawlify.api.v1.brawler.RawBrawlifyBrawler as RawBrawlifyBrawler
import com.y9vad9.krawl.brawlify.BrawlifyDescription
import com.y9vad9.krawl.brawlify.BrawlifyHtmlDescription
import com.y9vad9.krawl.brawlify.BrawlifyRegularDescription
import com.y9vad9.krawl.brawlify.BrawlifyUrl

/**
 * Represents a Brawler entity in the Brawlify data model.
 *
 * This model encapsulates core information about a specific Brawler, including metadata,
 * classification, availability, and available abilities (Gadgets and Star Powers).
 *
 * @property id Unique identifier of the Brawler.
 * @property name Display name of the Brawler.
 * @property isReleased Indicates whether the Brawler is currently released in the game.
 * @property description Description or lore text about the Brawler.
 * @property image Image asset representing the Brawler, typically used in UI or thumbnails.
 * @property classification Gameplay class of the Brawler (e.g., Damage Dealer, Support).
 * @property rarity Rarity level of the Brawler, used to convey how difficult it is to unlock.
 * @property gadgets List of gadgets available for this Brawler, each representing an active ability.
 * @property starPowers List of star powers available for this Brawler, representing passive abilities.
 */
public data class BrawlifyBrawler(
    public val id: BrawlerId,
    public val name: BrawlerName,
    public val isReleased: Boolean,
    public val description: BrawlifyDescription,
    public val image: BrawlifyBrawlerImage,
    public val classification: BrawlifyBrawlerClass,
    public val rarity: BrawlifyBrawlerRarity,
    public val gadgets: List<BrawlifyBrawlerGadget>,
    public val starPowers: List<BrawlifyBrawlerStarPower>,
)

/**
 * Converts this [RawBrawlifyBrawler] into its validated and typed counterpart [BrawlifyBrawler].
 *
 * @return the corresponding [BrawlifyBrawler] instance
 * @throws IllegalArgumentException if any validation fails or contract is broken
 */
public fun RawBrawlifyBrawler.toTypedOrThrow(): BrawlifyBrawler =
    BrawlifyBrawler(
        id = BrawlerId.createOrThrow(id),
        name = BrawlerName(name),
        isReleased = released,
        description = BrawlifyDescription(
            regular = BrawlifyRegularDescription(description),
            html = BrawlifyHtmlDescription(descriptionHtml),
        ),
        image = BrawlifyBrawlerImage(
            border = BrawlifyUrl.createOrThrow(imageUrl),
            borderless = BrawlifyUrl.createOrThrow(borderlessImageUrl),
            emoji = BrawlifyUrl.createOrThrow(fankitImageUrl),
        ),
        classification = classInfo.toTypedOrThrow(),
        rarity = rarity.toTypedOrThrow(),
        gadgets = gadgets.map { it.toTypedOrThrow() },
        starPowers = starPowers.map { it.toTypedOrThrow() },
    )

/**
 * Attempts to convert this [RawBrawlifyBrawler] into its typed counterpart [BrawlifyBrawler].
 *
 * @return the validated [BrawlifyBrawler], or `null` if conversion fails
 */
public fun RawBrawlifyBrawler.toTypedOrNull(): BrawlifyBrawler? =
    try { toTypedOrThrow() } catch (_: Throwable) { null }
