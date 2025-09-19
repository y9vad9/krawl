package com.y9vad9.krawl.brawlify.test.brawler

import com.y9vad9.krawl.brawlify.api.v1.brawler.RawBrawlifyBrawlerRarity
import com.y9vad9.krawl.brawlify.brawler.BrawlifyBrawlerRarity
import com.y9vad9.krawl.brawlify.brawler.BrawlifyBrawlerRarityId
import com.y9vad9.krawl.brawlify.brawler.BrawlifyBrawlerRarityName
import com.y9vad9.krawl.brawlify.brawler.isCommon
import com.y9vad9.krawl.brawlify.brawler.isEpic
import com.y9vad9.krawl.brawlify.brawler.isLegendary
import com.y9vad9.krawl.brawlify.brawler.isMythic
import com.y9vad9.krawl.brawlify.brawler.isRare
import com.y9vad9.krawl.brawlify.brawler.isSuperRare
import com.y9vad9.krawl.brawlify.brawler.isUltraLegendary
import com.y9vad9.krawl.brawlify.brawler.toTypedOrNull
import com.y9vad9.krawl.brawlify.brawler.toTypedOrThrow
import com.y9vad9.krawl.common.HexColor
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class BrawlifyBrawlerRarityTest {

    @Test
    fun `toTypedOrThrow builds a valid rarity`() {
        // GIVEN
        val raw = RawBrawlifyBrawlerRarity(
            id = 4,
            name = "Epic",
            color = "#FF00FF"
        )

        // WHEN
        val typed = raw.toTypedOrThrow()

        // THEN
        assertEquals(BrawlifyBrawlerRarityId.EPIC, typed.id)
        assertEquals("Epic", typed.name.rawString)
        assertEquals("#FF00FF", typed.color.rawString)
    }

    @Test
    fun `toTypedOrThrow fails with invalid hex color`() {
        // GIVEN
        val raw = RawBrawlifyBrawlerRarity(
            id = 2,
            name = "Rare",
            color = "not-a-color"
        )

        // WHEN // THEN
        assertFailsWith<IllegalArgumentException> {
            raw.toTypedOrThrow()
        }
    }

    @Test
    fun `toTypedOrNull returns null on invalid input`() {
        // GIVEN
        val raw = RawBrawlifyBrawlerRarity(
            id = 5,
            name = "Mythic",
            color = "invalid"
        )

        // WHEN
        val result = raw.toTypedOrNull()

        // THEN
        assertNull(result)
    }

    @Test
    fun `toTypedOrNull returns instance on valid input`() {
        // GIVEN
        val raw = RawBrawlifyBrawlerRarity(
            id = 1,
            name = "Common",
            color = "#FFFFFF"
        )

        // WHEN
        val result = raw.toTypedOrNull()

        // THEN
        assertNotNull(result)
        assertEquals(BrawlifyBrawlerRarityId.COMMON, result.id)
    }

    @Test
    fun `classification booleans match rarity id`() {
        // GIVEN
        val rarities = listOf(
            BrawlifyBrawlerRarity(
                id = BrawlifyBrawlerRarityId.COMMON,
                name = BrawlifyBrawlerRarityName.from("Common"),
                color = HexColor.createOrThrow("#000000")
            ),
            BrawlifyBrawlerRarity(
                id = BrawlifyBrawlerRarityId.RARE,
                name = BrawlifyBrawlerRarityName.from("Rare"),
                color = HexColor.createOrThrow("#00FF00")
            ),
            BrawlifyBrawlerRarity(
                id = BrawlifyBrawlerRarityId.SUPER_RARE,
                name = BrawlifyBrawlerRarityName.from("Super Rare"),
                color = HexColor.createOrThrow("#0000FF")
            ),
            BrawlifyBrawlerRarity(
                id = BrawlifyBrawlerRarityId.EPIC,
                name = BrawlifyBrawlerRarityName.from("Epic"),
                color = HexColor.createOrThrow("#FF00FF")
            ),
            BrawlifyBrawlerRarity(
                id = BrawlifyBrawlerRarityId.MYTHIC,
                name = BrawlifyBrawlerRarityName.from("Mythic"),
                color = HexColor.createOrThrow("#FFFF00")
            ),
            BrawlifyBrawlerRarity(
                id = BrawlifyBrawlerRarityId.LEGENDARY,
                name = BrawlifyBrawlerRarityName.from("Legendary"),
                color = HexColor.createOrThrow("#FFA500")
            ),
            BrawlifyBrawlerRarity(
                id = BrawlifyBrawlerRarityId.ULTRA_LEGENDARY,
                name = BrawlifyBrawlerRarityName.from("Ultra Legendary"),
                color = HexColor.createOrThrow("#FF0000")
            )
        )

        // WHEN // THEN
        rarities.forEach { rarity ->
            assertEquals(rarity.id.isCommon, rarity.isCommon, "Mismatch for COMMON")
            assertEquals(rarity.id.isRare, rarity.isRare, "Mismatch for RARE")
            assertEquals(rarity.id.isSuperRare, rarity.isSuperRare, "Mismatch for SUPER_RARE")
            assertEquals(rarity.id.isEpic, rarity.isEpic, "Mismatch for EPIC")
            assertEquals(rarity.id.isMythic, rarity.isMythic, "Mismatch for MYTHIC")
            assertEquals(rarity.id.isLegendary, rarity.isLegendary, "Mismatch for LEGENDARY")
            assertEquals(rarity.id.isUltraLegendary, rarity.isUltraLegendary, "Mismatch for ULTRA_LEGENDARY")
        }
    }

    @Test
    fun `only correct classification boolean is true for each rarity`() {
        // GIVEN
        val rarity = BrawlifyBrawlerRarity(
            id = BrawlifyBrawlerRarityId.SUPER_RARE,
            name = BrawlifyBrawlerRarityName.from("Super Rare"),
            color = HexColor.createOrThrow("#123456")
        )

        // WHEN // THEN
        assertFalse(rarity.isCommon)
        assertFalse(rarity.isRare)
        assertTrue(rarity.isSuperRare)
        assertFalse(rarity.isEpic)
        assertFalse(rarity.isMythic)
        assertFalse(rarity.isLegendary)
        assertFalse(rarity.isUltraLegendary)
    }
}
