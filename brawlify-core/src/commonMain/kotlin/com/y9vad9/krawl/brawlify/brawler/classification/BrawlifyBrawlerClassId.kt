package com.y9vad9.krawl.brawlify.brawler.classification

/**
 * Represents a brawler class identifier as used in Brawlify.
 *
 * This is a lightweight inline wrapper around an integer value that maps to a specific
 * brawler role (e.g., tank, support, assassin).
 *
 * Use [from] to safely retrieve a known class constant or preserve unknown values.
 *
 * @property rawInt The raw integer representation of the class.
 */
@JvmInline
public value class BrawlifyBrawlerClassId(public val rawInt: Int) {
    public companion object {
        /** Brawlers that are yet to be released. */
        public val UNKNOWN: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(0)

        /** Brawlers focused on dealing consistent damage. */
        public val DAMAGE_DEALER: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(1)

        /** Durable brawlers with high health designed to absorb damage. */
        public val TANK: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(2)

        /** Brawlers with long-range precision attacks. */
        public val MARKSMAN: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(3)

        /** Brawlers that control space using ranged splash damage. */
        public val ARTILLERY: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(4)

        /** Brawlers designed to control areas and influence enemy movement. */
        public val CONTROLLER: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(5)

        /** Agile and burst-heavy brawlers that excel at flanking. */
        public val ASSASSIN: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(6)

        /** Brawlers that provide healing, buffs, or utility for their team. */
        public val SUPPORT: BrawlifyBrawlerClassId = BrawlifyBrawlerClassId(7)
    }
}

/** Returns `true` if this class ID represents a damage dealer. */
public val BrawlifyBrawlerClassId.isDamageDealer: Boolean
    get() = this == BrawlifyBrawlerClassId.DAMAGE_DEALER

/** Returns `true` if this class ID represents a tank. */
public val BrawlifyBrawlerClassId.isTank: Boolean
    get() = this == BrawlifyBrawlerClassId.TANK

/** Returns `true` if this class ID represents a marksman. */
public val BrawlifyBrawlerClassId.isMarksman: Boolean
    get() = this == BrawlifyBrawlerClassId.MARKSMAN

/** Returns `true` if this class ID represents an artillery unit. */
public val BrawlifyBrawlerClassId.isArtillery: Boolean
    get() = this == BrawlifyBrawlerClassId.ARTILLERY

/** Returns `true` if this class ID represents a controller. */
public val BrawlifyBrawlerClassId.isController: Boolean
    get() = this == BrawlifyBrawlerClassId.CONTROLLER

/** Returns `true` if this class ID represents an assassin. */
public val BrawlifyBrawlerClassId.isAssassin: Boolean
    get() = this == BrawlifyBrawlerClassId.ASSASSIN

/** Returns `true` if this class ID represents a support unit. */
public val BrawlifyBrawlerClassId.isSupport: Boolean
    get() = this == BrawlifyBrawlerClassId.SUPPORT
