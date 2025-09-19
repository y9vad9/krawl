package com.y9vad9.krawl.brawlify.test.brawler

import com.y9vad9.krawl.brawlify.brawler.BrawlifyBrawlerRarityName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotSame
import kotlin.test.assertTrue

class BrawlifyBrawlerRarityNameTest {


    @Test
    fun `from returns predefined instances for well-known rarity names`() {
        // GIVEN
        val inputs = mapOf(
            "Common" to BrawlifyBrawlerRarityName.COMMON,
            "Rare" to BrawlifyBrawlerRarityName.RARE,
            "Super Rare" to BrawlifyBrawlerRarityName.SUPER_RARE,
            "Epic" to BrawlifyBrawlerRarityName.EPIC,
            "Mythic" to BrawlifyBrawlerRarityName.MYTHIC,
            "Legendary" to BrawlifyBrawlerRarityName.LEGENDARY,
            "Ultra Legendary" to BrawlifyBrawlerRarityName.ULTRA_LEGENDARY,
        )

        // WHEN // THEN
        for ((input, expected) in inputs) {
            val result = BrawlifyBrawlerRarityName.from(input)
            assertEquals(expected, result, "Expected predefined instance for $input")
        }
    }

    @Test
    fun `from creates new instances for unknown rarity names`() {
        // GIVEN
        val input = "Custom Rarity"

        // WHEN
        val result1 = BrawlifyBrawlerRarityName.from(input)
        val result2 = BrawlifyBrawlerRarityName.from(input)

        // THEN
        assertEquals(input, result1.rawString)
        assertEquals(input, result2.rawString)
        assertNotSame(result1, result2, "Unknown rarities should not reuse instances")
    }

    @Test
    fun `WELL_KNOWN_NAMES contains all predefined rarities in correct order`() {
        // GIVEN
        val expectedOrder = listOf(
            BrawlifyBrawlerRarityName.COMMON,
            BrawlifyBrawlerRarityName.RARE,
            BrawlifyBrawlerRarityName.SUPER_RARE,
            BrawlifyBrawlerRarityName.EPIC,
            BrawlifyBrawlerRarityName.MYTHIC,
            BrawlifyBrawlerRarityName.LEGENDARY,
            BrawlifyBrawlerRarityName.ULTRA_LEGENDARY,
        )

        // WHEN
        val wellKnown = BrawlifyBrawlerRarityName.WELL_KNOWN_NAMES

        // THEN
        assertEquals(expectedOrder.size, wellKnown.size, "Size mismatch")
        assertTrue(wellKnown.containsAll(expectedOrder), "Missing some rarities")
        assertEquals(expectedOrder, wellKnown, "Order mismatch")
    }

    @Test
    fun `rawString returns underlying rarity name`() {
        // GIVEN
        val rarity = BrawlifyBrawlerRarityName.RARE

        // WHEN
        val value = rarity.rawString

        // THEN
        assertEquals("Rare", value)
    }
}
