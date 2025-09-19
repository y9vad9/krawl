package com.y9vad9.krawl.brawlify.test.brawler

import com.y9vad9.krawl.brawlify.brawler.BrawlifyBrawlerClassName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertSame
import kotlin.test.assertTrue

class BrawlifyBrawlerClassNameTest {

    @Test
    fun `well known names list contains all predefined constants`() {
        val expected = listOf(
            BrawlifyBrawlerClassName.DAMAGE_DEALER,
            BrawlifyBrawlerClassName.TANK,
            BrawlifyBrawlerClassName.MARKSMAN,
            BrawlifyBrawlerClassName.ARTILLERY,
            BrawlifyBrawlerClassName.CONTROLLER,
            BrawlifyBrawlerClassName.ASSASSIN,
            BrawlifyBrawlerClassName.SUPPORT,
        )
        assertEquals(expected, BrawlifyBrawlerClassName.WELL_KNOWN_NAMES)
    }

    @Test
    fun `from returns the correct instance for well known names`() {
        assertEquals(
            BrawlifyBrawlerClassName.DAMAGE_DEALER,
            BrawlifyBrawlerClassName.from("Damage Dealer")
        )
        assertEquals(
            BrawlifyBrawlerClassName.TANK,
            BrawlifyBrawlerClassName.from("Tank")
        )
        assertEquals(
            BrawlifyBrawlerClassName.MARKSMAN,
            BrawlifyBrawlerClassName.from("Marksman")
        )
        assertEquals(
            BrawlifyBrawlerClassName.ARTILLERY,
            BrawlifyBrawlerClassName.from("Artillery")
        )
        assertEquals(
            BrawlifyBrawlerClassName.CONTROLLER,
            BrawlifyBrawlerClassName.from("Controller")
        )
        assertEquals(
            BrawlifyBrawlerClassName.ASSASSIN,
            BrawlifyBrawlerClassName.from("Assassin")
        )
        assertEquals(
            BrawlifyBrawlerClassName.SUPPORT,
            BrawlifyBrawlerClassName.from("Support")
        )
    }

    @Test
    fun `from returns new instance for unknown name`() {
        val custom = BrawlifyBrawlerClassName.from("CustomRole")
        assertEquals("CustomRole", custom.rawString)
        assertTrue(custom !in BrawlifyBrawlerClassName.WELL_KNOWN_NAMES)
    }

    @Test
    fun `unknown constant is consistent`() {
        val unknown = BrawlifyBrawlerClassName.UNKNOWN
        assertEquals("UNKNOWN", unknown.rawString)
        assertNotEquals(
            BrawlifyBrawlerClassName.from("Tank"),
            unknown
        )
    }

    @Test
    fun `from preserves equality for unknown names`() {
        val a = BrawlifyBrawlerClassName.from("Mystery")
        val b = BrawlifyBrawlerClassName.from("Mystery")
        assertEquals(a, b)
        assertEquals(a.rawString, b.rawString)
    }
}
