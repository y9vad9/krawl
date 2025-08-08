package com.y9vad9.krawl.brawlify.brawler.gadget

import com.y9vad9.krawl.brawler.GadgetId
import com.y9vad9.krawl.brawler.GadgetName
import com.y9vad9.krawl.brawlify.common.BrawlifyDescription
import com.y9vad9.krawl.brawlify.common.BrawlifyPathSegment

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
    public val path: BrawlifyPathSegment,

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
