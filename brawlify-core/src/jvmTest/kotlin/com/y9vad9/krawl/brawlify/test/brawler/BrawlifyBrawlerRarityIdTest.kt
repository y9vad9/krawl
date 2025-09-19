package com.y9vad9.krawl.brawlify.test.brawler

import com.y9vad9.krawl.brawlify.brawler.BrawlifyBrawlerRarityId
import com.y9vad9.krawl.brawlify.brawler.isCommon
import com.y9vad9.krawl.brawlify.brawler.isEpic
import com.y9vad9.krawl.brawlify.brawler.isLegendary
import com.y9vad9.krawl.brawlify.brawler.isMythic
import com.y9vad9.krawl.brawlify.brawler.isRare
import com.y9vad9.krawl.brawlify.brawler.isSuperRare
import com.y9vad9.krawl.brawlify.brawler.isUltraLegendary
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse
import kotlin.test.assertContains

class BrawlifyBrawlerRarityIdTest {

    @Test
    fun `well known ids cover expected values`() {
        // WHEN
        val ids = BrawlifyBrawlerRarityId.WELL_KNOWN_IDS.map { it.rawInt }

        // THEN
        assertEquals(listOf(1, 2, 3, 4, 5, 6, 7), ids)
    }

    @Test
    fun `isCommon returns true only for COMMON`() {
        // GIVEN
        val common = BrawlifyBrawlerRarityId.COMMON
        val others = BrawlifyBrawlerRarityId.WELL_KNOWN_IDS - common

        // THEN
        assertTrue(common.isCommon)
        others.forEach { assertFalse(it.isCommon) }
    }

    @Test
    fun `isRare returns true only for RARE`() {
        // GIVEN
        val rare = BrawlifyBrawlerRarityId.RARE
        val others = BrawlifyBrawlerRarityId.WELL_KNOWN_IDS - rare

        // THEN
        assertTrue(rare.isRare)
        others.forEach { assertFalse(it.isRare) }
    }

    @Test
    fun `isSuperRare returns true only for SUPER_RARE`() {
        // GIVEN
        val superRare = BrawlifyBrawlerRarityId.SUPER_RARE
        val others = BrawlifyBrawlerRarityId.WELL_KNOWN_IDS - superRare

        // THEN
        assertTrue(superRare.isSuperRare)
        others.forEach { assertFalse(it.isSuperRare) }
    }

    @Test
    fun `isEpic returns true only for EPIC`() {
        // GIVEN
        val epic = BrawlifyBrawlerRarityId.EPIC
        val others = BrawlifyBrawlerRarityId.WELL_KNOWN_IDS - epic

        // THEN
        assertTrue(epic.isEpic)
        others.forEach { assertFalse(it.isEpic) }
    }

    @Test
    fun `isMythic returns true only for MYTHIC`() {
        // GIVEN
        val mythic = BrawlifyBrawlerRarityId.MYTHIC
        val others = BrawlifyBrawlerRarityId.WELL_KNOWN_IDS - mythic

        // THEN
        assertTrue(mythic.isMythic)
        others.forEach { assertFalse(it.isMythic) }
    }

    @Test
    fun `isLegendary returns true only for LEGENDARY`() {
        // GIVEN
        val legendary = BrawlifyBrawlerRarityId.LEGENDARY
        val others = BrawlifyBrawlerRarityId.WELL_KNOWN_IDS - legendary

        // THEN
        assertTrue(legendary.isLegendary)
        others.forEach { assertFalse(it.isLegendary) }
    }

    @Test
    fun `isUltraLegendary returns true only for ULTRA_LEGENDARY`() {
        // GIVEN
        val ultraLegendary = BrawlifyBrawlerRarityId.ULTRA_LEGENDARY
        val others = BrawlifyBrawlerRarityId.WELL_KNOWN_IDS - ultraLegendary

        // THEN
        assertTrue(ultraLegendary.isUltraLegendary)
        others.forEach { assertFalse(it.isUltraLegendary) }
    }
}