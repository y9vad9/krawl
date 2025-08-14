package com.y9vad9.krawl.brawlify.brawler.classification

import kotlin.jvm.JvmInline

/**
 * Represents the textual class name of a Brawler in the Brawlify system, e.g. "Tank", "Marksman".
 *
 * This value class wraps a raw [String] and provides predefined constants for all known classes.
 * Use the factory methods in [Companion] to safely construct instances with validation.
 *
 * @property rawString The raw class name string, e.g., "Support".
 */
@JvmInline
public value class BrawlifyBrawlerClassName(public val rawString: String) {
    public companion object {
        /** Used in case if Brawlify doesn't know the rarity of the brawler. */
        public val UNKNOWN: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("UNKNOWN")

        /** Predefined Brawler class: Damage Dealer. */
        public val DAMAGE_DEALER: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("Damage Dealer")

        /** Predefined Brawler class: Tank. */
        public val TANK: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("Tank")

        /** Predefined Brawler class: Marksman. */
        public val MARKSMAN: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("Marksman")

        /** Predefined Brawler class: Artillery. */
        public val ARTILLERY: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("Artillery")

        /** Predefined Brawler class: Controller. */
        public val CONTROLLER: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("Controller")

        /** Predefined Brawler class: Assassin. */
        public val ASSASSIN: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("Assassin")

        /** Predefined Brawler class: Support. */
        public val SUPPORT: BrawlifyBrawlerClassName = BrawlifyBrawlerClassName("Support")

        /**
         * All well-known names.
         */
        public val WELL_KNOWN_NAMES: List<BrawlifyBrawlerClassName> = listOf(
            DAMAGE_DEALER, TANK, MARKSMAN, ARTILLERY, CONTROLLER, ASSASSIN, SUPPORT,
        )

        /**
         * Returns the matching predefined [BrawlifyBrawlerClassName] for the given [value],
         * or a new instance if no match is found.
         */
        public fun from(value: String): BrawlifyBrawlerClassName = when (value) {
            DAMAGE_DEALER.rawString -> DAMAGE_DEALER
            TANK.rawString -> TANK
            MARKSMAN.rawString -> MARKSMAN
            ARTILLERY.rawString -> ARTILLERY
            CONTROLLER.rawString -> CONTROLLER
            ASSASSIN.rawString -> ASSASSIN
            SUPPORT.rawString -> SUPPORT
            else -> BrawlifyBrawlerClassName(value)
        }
    }
}
