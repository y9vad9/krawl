package com.y9vad9.krawl.brawlify.brawler.rarity

/**
 * Represents the numeric identifier of a Brawler's rarity in the Brawlify system.
 *
 * Each rarity is assigned a unique integer value:
 * - 1 → Common (available from the start)
 * - 2 → Rare
 * - 3 → Super Rare
 * - 4 → Epic
 * - 5 → Mythic
 * - 6 → Legendary
 * - 7 → Ultra Legendary
 *
 * This value class allows for type-safe handling of brawler rarities based on their raw integer ID.
 *
 * Use [from] to create instances safely and reuse predefined constants from [Companion] when possible.
 *
 * @property rawInt The raw integer value representing the rarity level.
 */
@JvmInline
public value class BrawlifyBrawlerRarityId(
    public val rawInt: Int,
) {
    public companion object {
        /** Brawlers available from the start of the game. */
        public val COMMON: BrawlifyBrawlerRarityId = BrawlifyBrawlerRarityId(1)

        /** Rare-tier Brawlers. */
        public val RARE: BrawlifyBrawlerRarityId = BrawlifyBrawlerRarityId(2)

        /** Super Rare-tier Brawlers. */
        public val SUPER_RARE: BrawlifyBrawlerRarityId = BrawlifyBrawlerRarityId(3)

        /** Epic-tier Brawlers. */
        public val EPIC: BrawlifyBrawlerRarityId = BrawlifyBrawlerRarityId(4)

        /** Mythic-tier Brawlers. */
        public val MYTHIC: BrawlifyBrawlerRarityId = BrawlifyBrawlerRarityId(5)

        /** Legendary-tier Brawlers. */
        public val LEGENDARY: BrawlifyBrawlerRarityId = BrawlifyBrawlerRarityId(6)

        /** Ultra Legendary-tier Brawlers. */
        public val ULTRA_LEGENDARY: BrawlifyBrawlerRarityId = BrawlifyBrawlerRarityId(7)

        /** All predefined rarity IDs. */
        public val WELL_KNOWN_IDS: List<BrawlifyBrawlerRarityId> = listOf(
            COMMON, RARE, SUPER_RARE, EPIC, MYTHIC, LEGENDARY, ULTRA_LEGENDARY,
        )
    }
}

/**
 * Returns `true` if this rarity is [COMMON].
 */
public val BrawlifyBrawlerRarityId.isCommon: Boolean
    get() = this == BrawlifyBrawlerRarityId.COMMON

/**
 * Returns `true` if this rarity is [RARE].
 */
public val BrawlifyBrawlerRarityId.isRare: Boolean
    get() = this == BrawlifyBrawlerRarityId.RARE

/**
 * Returns `true` if this rarity is [SUPER_RARE].
 */
public val BrawlifyBrawlerRarityId.isSuperRare: Boolean
    get() = this == BrawlifyBrawlerRarityId.SUPER_RARE

/**
 * Returns `true` if this rarity is [EPIC].
 */
public val BrawlifyBrawlerRarityId.isEpic: Boolean
    get() = this == BrawlifyBrawlerRarityId.EPIC

/**
 * Returns `true` if this rarity is [MYTHIC].
 */
public val BrawlifyBrawlerRarityId.isMythic: Boolean
    get() = this == BrawlifyBrawlerRarityId.MYTHIC

/**
 * Returns `true` if this rarity is [LEGENDARY].
 */
public val BrawlifyBrawlerRarityId.isLegendary: Boolean
    get() = this == BrawlifyBrawlerRarityId.LEGENDARY

/**
 * Returns `true` if this rarity is [LEGENDARY].
 */
public val BrawlifyBrawlerRarityId.isUltraLegendary: Boolean
    get() = this == BrawlifyBrawlerRarityId.ULTRA_LEGENDARY
