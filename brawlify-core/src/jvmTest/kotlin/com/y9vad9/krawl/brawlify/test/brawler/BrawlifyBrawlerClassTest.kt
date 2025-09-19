package com.y9vad9.krawl.brawlify.test.brawler

import com.y9vad9.krawl.brawlify.api.v1.brawler.RawBrawlifyBrawlerClass
import com.y9vad9.krawl.brawlify.brawler.BrawlifyBrawlerClass
import com.y9vad9.krawl.brawlify.brawler.BrawlifyBrawlerClassId
import com.y9vad9.krawl.brawlify.brawler.BrawlifyBrawlerClassName
import com.y9vad9.krawl.brawlify.brawler.isArtillery
import com.y9vad9.krawl.brawlify.brawler.isAssassin
import com.y9vad9.krawl.brawlify.brawler.isController
import com.y9vad9.krawl.brawlify.brawler.isDamageDealer
import com.y9vad9.krawl.brawlify.brawler.isMarksman
import com.y9vad9.krawl.brawlify.brawler.isSupport
import com.y9vad9.krawl.brawlify.brawler.isTank
import com.y9vad9.krawl.brawlify.brawler.isUnknown
import com.y9vad9.krawl.brawlify.brawler.toTypedOrThrow
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BrawlifyBrawlerClassTest {

    @Test
    fun `toTyped should convert raw to typed`() {
        // GIVEN
        val raw = RawBrawlifyBrawlerClass(
            id = 2,
            name = "Tank",
        )

        // WHEN
        val typed = raw.toTypedOrThrow()

        // THEN
        assertEquals(BrawlifyBrawlerClassId(2), typed.id)
        assertEquals(BrawlifyBrawlerClassName.from("Tank"), typed.name)
    }

    @Test
    fun `isTank should match tank class`() {
        // GIVEN
        val brawlerClass = BrawlifyBrawlerClass(
            id = BrawlifyBrawlerClassId.TANK,
            name = BrawlifyBrawlerClassName.from("Tank")
        )

        // WHEN
        val result = brawlerClass.isTank

        // THEN
        assertTrue(result)
    }

    @Test
    fun `consistency check for all roles`() {
        // GIVEN
        val cases = listOf(
            BrawlifyBrawlerClass(BrawlifyBrawlerClassId.UNKNOWN, BrawlifyBrawlerClassName.from("Unknown")),
            BrawlifyBrawlerClass(BrawlifyBrawlerClassId.DAMAGE_DEALER, BrawlifyBrawlerClassName.from("Damage Dealer")),
            BrawlifyBrawlerClass(BrawlifyBrawlerClassId.TANK, BrawlifyBrawlerClassName.from("Tank")),
            BrawlifyBrawlerClass(BrawlifyBrawlerClassId.MARKSMAN, BrawlifyBrawlerClassName.from("Marksman")),
            BrawlifyBrawlerClass(BrawlifyBrawlerClassId.ARTILLERY, BrawlifyBrawlerClassName.from("Artillery")),
            BrawlifyBrawlerClass(BrawlifyBrawlerClassId.CONTROLLER, BrawlifyBrawlerClassName.from("Controller")),
            BrawlifyBrawlerClass(BrawlifyBrawlerClassId.ASSASSIN, BrawlifyBrawlerClassName.from("Assassin")),
            BrawlifyBrawlerClass(BrawlifyBrawlerClassId.SUPPORT, BrawlifyBrawlerClassName.from("Support")),
        )

        // WHEN // THEN
        cases.forEach { brawlerClass ->
            assertEquals(brawlerClass.isUnknown, brawlerClass.id.isUnknown)
            assertEquals(brawlerClass.isDamageDealer, brawlerClass.id.isDamageDealer)
            assertEquals(brawlerClass.isTank, brawlerClass.id.isTank)
            assertEquals(brawlerClass.isMarksman, brawlerClass.id.isMarksman)
            assertEquals(brawlerClass.isArtillery, brawlerClass.id.isArtillery)
            assertEquals(brawlerClass.isController, brawlerClass.id.isController)
            assertEquals(brawlerClass.isAssassin, brawlerClass.id.isAssassin)
            assertEquals(brawlerClass.isSupport, brawlerClass.id.isSupport)
        }
    }
}