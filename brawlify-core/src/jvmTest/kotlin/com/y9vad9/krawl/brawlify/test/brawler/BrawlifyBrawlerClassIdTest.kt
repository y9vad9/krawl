package com.y9vad9.krawl.brawlify.test.brawler

import com.y9vad9.krawl.brawlify.brawler.BrawlifyBrawlerClassId
import com.y9vad9.krawl.brawlify.brawler.isArtillery
import com.y9vad9.krawl.brawlify.brawler.isAssassin
import com.y9vad9.krawl.brawlify.brawler.isController
import com.y9vad9.krawl.brawlify.brawler.isDamageDealer
import com.y9vad9.krawl.brawlify.brawler.isMarksman
import com.y9vad9.krawl.brawlify.brawler.isSupport
import com.y9vad9.krawl.brawlify.brawler.isTank
import com.y9vad9.krawl.brawlify.brawler.isUnknown
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BrawlifyBrawlerClassIdTest {

    @Test
    fun `unknown should be recognized`() {
        // GIVEN
        val id = BrawlifyBrawlerClassId(0)

        // WHEN
        val result = id.isUnknown

        // THEN
        assertTrue(result)
    }

    @Test
    fun `damage dealer should be recognized`() {
        // GIVEN
        val id = BrawlifyBrawlerClassId(1)

        // WHEN
        val result = id.isDamageDealer

        // THEN
        assertTrue(result)
    }

    @Test
    fun `tank should be recognized`() {
        // GIVEN
        val id = BrawlifyBrawlerClassId(2)

        // WHEN
        val result = id.isTank

        // THEN
        assertTrue(result)
    }

    @Test
    fun `marksman should be recognized`() {
        // GIVEN
        val id = BrawlifyBrawlerClassId(3)

        // WHEN
        val result = id.isMarksman

        // THEN
        assertTrue(result)
    }

    @Test
    fun `artillery should be recognized`() {
        // GIVEN
        val id = BrawlifyBrawlerClassId(4)

        // WHEN
        val result = id.isArtillery

        // THEN
        assertTrue(result)
    }

    @Test
    fun `controller should be recognized`() {
        // GIVEN
        val id = BrawlifyBrawlerClassId(5)

        // WHEN
        val result = id.isController

        // THEN
        assertTrue(result)
    }

    @Test
    fun `assassin should be recognized`() {
        // GIVEN
        val id = BrawlifyBrawlerClassId(6)

        // WHEN
        val result = id.isAssassin

        // THEN
        assertTrue(result)
    }

    @Test
    fun `support should be recognized`() {
        // GIVEN
        val id = BrawlifyBrawlerClassId(7)

        // WHEN
        val result = id.isSupport

        // THEN
        assertTrue(result)
    }

    @Test
    fun `only correct role matches are true`() {
        // GIVEN
        val allIds = listOf(
            BrawlifyBrawlerClassId.UNKNOWN,
            BrawlifyBrawlerClassId.DAMAGE_DEALER,
            BrawlifyBrawlerClassId.TANK,
            BrawlifyBrawlerClassId.MARKSMAN,
            BrawlifyBrawlerClassId.ARTILLERY,
            BrawlifyBrawlerClassId.CONTROLLER,
            BrawlifyBrawlerClassId.ASSASSIN,
            BrawlifyBrawlerClassId.SUPPORT,
        )

        // WHEN // THEN
        allIds.forEach { id ->
            assertEquals(id.isUnknown, id == BrawlifyBrawlerClassId.UNKNOWN)
            assertEquals(id.isDamageDealer, id == BrawlifyBrawlerClassId.DAMAGE_DEALER)
            assertEquals(id.isTank, id == BrawlifyBrawlerClassId.TANK)
            assertEquals(id.isMarksman, id == BrawlifyBrawlerClassId.MARKSMAN)
            assertEquals(id.isArtillery, id == BrawlifyBrawlerClassId.ARTILLERY)
            assertEquals(id.isController, id == BrawlifyBrawlerClassId.CONTROLLER)
            assertEquals(id.isAssassin, id == BrawlifyBrawlerClassId.ASSASSIN)
            assertEquals(id.isSupport, id == BrawlifyBrawlerClassId.SUPPORT)
        }
    }
}
