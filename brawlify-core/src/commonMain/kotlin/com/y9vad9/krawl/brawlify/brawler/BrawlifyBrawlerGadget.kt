package com.y9vad9.krawl.brawlify.brawler

import com.y9vad9.krawl.brawler.GadgetId
import com.y9vad9.krawl.brawler.GadgetName
import com.y9vad9.krawl.brawlify.api.v1.brawler.RawBrawlifyBrawlerGadget
import com.y9vad9.krawl.brawlify.BrawlifyDescription
import com.y9vad9.krawl.brawlify.BrawlifyHtmlDescription
import com.y9vad9.krawl.brawlify.BrawlifyPathSegment
import com.y9vad9.krawl.brawlify.BrawlifyRegularDescription

/**
 * Represents a Gadget available to a Brawler in the Brawlify system.
 *
 * Gadgets are active abilities that add utility or variation to a Brawler’s kit.
 * They are unlockable and versioned, with each version reflecting a distinct release or update.
 */
public data class BrawlifyBrawlerGadget(
    /**
     * Unique identifier of the Gadget, used internally and across systems.
     */
    public val id: GadgetId,

    /**
     * Localized display name of the Gadget, e.g., `"Shell Shock"`.
     */
    public val name: GadgetName,

    /**
     * URL-safe path segment used to link to the Gadget in external systems like Brawlify.
     * Usually derived from the name.
     */
    public val pathSegment: BrawlifyPathSegment,

    /**
     * Human-readable description of the Gadget's in-game effect.
     * This field may include dynamic values represented by placeholders.
     */
    public val description: BrawlifyDescription,

    /**
     * Indicates the version of the Gadget. Starts at `1` for the original release,
     * and increments if the Gadget is reworked or reintroduced.
     */
    public val version: BrawlifyGadgetVersion,

    /**
     * Whether the Gadget is officially released and available in-game.
     */
    public val isReleased: Boolean,
)

/**
 * Converts this [RawBrawlifyBrawlerGadget] into its validated and typed counterpart [BrawlifyBrawlerGadget].
 *
 * @return the corresponding [BrawlifyBrawlerGadget] instance
 * @throws IllegalArgumentException if any of the validation rules fail
 */
public fun RawBrawlifyBrawlerGadget.toTypedOrThrow(): BrawlifyBrawlerGadget =
    BrawlifyBrawlerGadget(
        id = GadgetId.createOrThrow(id),
        name = GadgetName(name),
        pathSegment = BrawlifyPathSegment(path),
        description = BrawlifyDescription(
            regular = BrawlifyRegularDescription(description),
            html = BrawlifyHtmlDescription(descriptionHtml),
        ),
        version = BrawlifyGadgetVersion.createOrThrow(version),
        isReleased = released,
    )

/**
 * Attempts to convert this [RawBrawlifyBrawlerGadget] into its typed counterpart [BrawlifyBrawlerGadget].
 *
 * @return the validated [BrawlifyBrawlerGadget], or `null` if conversion fails
 */
public fun RawBrawlifyBrawlerGadget.toTypedOrNull(): BrawlifyBrawlerGadget? =
    try { toTypedOrThrow() } catch (_: Throwable) { null }
