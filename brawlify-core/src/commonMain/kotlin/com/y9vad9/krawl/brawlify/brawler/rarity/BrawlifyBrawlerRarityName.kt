package com.y9vad9.krawl.brawlify.brawler.rarity

/**
 * Represents the display name of a Brawler's rarity in the Brawlify system.
 *
 * This value class encapsulates a rarity name as a string (e.g., `"Rare"`, `"Mythic"`),
 * providing type safety and avoiding raw string usage across the codebase.
 *
 * Use the predefined constants in the [Companion] to refer to known rarity names.
 *
 * @property rawString The raw string value representing the rarity name.
 */
@JvmInline
public value class BrawlifyBrawlerRarityName(public val rawString: String) {
    public companion object {
        /** Brawlers that are available from the start of the game. */
        public val COMMON: BrawlifyBrawlerRarityName = BrawlifyBrawlerRarityName("Common")

        /** Rare-tier Brawlers. */
        public val RARE: BrawlifyBrawlerRarityName = BrawlifyBrawlerRarityName("Rare")

        /** Super Rare-tier Brawlers. */
        public val SUPER_RARE: BrawlifyBrawlerRarityName = BrawlifyBrawlerRarityName("Super Rare")

        /** Epic-tier Brawlers. */
        public val EPIC: BrawlifyBrawlerRarityName = BrawlifyBrawlerRarityName("Epic")

        /** Mythic-tier Brawlers. */
        public val MYTHIC: BrawlifyBrawlerRarityName = BrawlifyBrawlerRarityName("Mythic")

        /** Legendary-tier Brawlers. */
        public val LEGENDARY: BrawlifyBrawlerRarityName = BrawlifyBrawlerRarityName("Legendary")

        /** Ultra Legendary-tier Brawlers (used in Brawlify-specific classifications). */
        public val ULTRA_LEGENDARY: BrawlifyBrawlerRarityName = BrawlifyBrawlerRarityName("Ultra Legendary")

        /**
         * All known rarity names, ordered from lowest to highest rarity.
         */
        public val WELL_KNOWN_NAMES: List<BrawlifyBrawlerRarityName> = listOf(
            COMMON,
            RARE,
            SUPER_RARE,
            EPIC,
            MYTHIC,
            LEGENDARY,
            ULTRA_LEGENDARY,
        )
    }
}
