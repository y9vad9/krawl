package com.y9vad9.krawl.brawlify.test.brawler

import com.y9vad9.krawl.brawler.GadgetId
import com.y9vad9.krawl.brawlify.api.v1.brawler.RawBrawlifyBrawlerGadget
import com.y9vad9.krawl.brawlify.brawler.toTypedOrNull
import com.y9vad9.krawl.brawlify.brawler.toTypedOrThrow
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class BrawlifyBrawlerGadgetConversionTest {

    @Test
    fun `toTypedOrThrow converts valid raw gadget`() {
        // GIVEN
        val raw = RawBrawlifyBrawlerGadget(
            id = GadgetId.MIN_VALUE,
            name = "Shell Shock",
            path = "shell-shock",
            version = 1,
            description = "Slows enemies on hit.",
            descriptionHtml = "<p>Slows enemies on hit.</p>",
            imageUrl = "https://cdn.brawlify.com/gadgets/borderless/${GadgetId.MIN_VALUE}",
            released = true,
        )

        // WHEN
        val typed = raw.toTypedOrThrow()

        // THEN
        assertEquals(GadgetId.createOrThrow(GadgetId.MIN_VALUE), typed.id)
        assertEquals("Shell Shock", typed.name.rawString)
        assertEquals("shell-shock", typed.pathSegment.rawString)
        assertEquals("Slows enemies on hit.", typed.description.regular.rawString)
        assertEquals("<p>Slows enemies on hit.</p>", typed.description.html.rawString)
        assertEquals(1, typed.version.rawInt)
        assertEquals(true, typed.isReleased)
    }

    @Test
    fun `toTypedOrThrow fails for invalid gadget id`() {
        // GIVEN
        val raw = RawBrawlifyBrawlerGadget(
            id = 999, // invalid
            name = "Broken Gadget",
            path = "broken",
            version = 1,
            description = "Invalid ID",
            descriptionHtml = "<p>Invalid ID</p>",
            imageUrl = "https://cdn.brawlify.com/gadgets/borderless/999",
            released = false,
        )

        // WHEN // THEN
        assertFailsWith<IllegalArgumentException> {
            raw.toTypedOrThrow()
        }
    }

    @Test
    fun `toTypedOrNull returns null for invalid gadget id`() {
        // GIVEN
        val raw = RawBrawlifyBrawlerGadget(
            id = GadgetId.MIN_VALUE - 1, // invalid
            name = "Invalid",
            path = "invalid",
            version = 1,
            description = "Invalid",
            descriptionHtml = "<p>Invalid</p>",
            imageUrl = "https://cdn.brawlify.com/gadgets/borderless/${GadgetId.MIN_VALUE - 1}",
            released = false,
        )

        // WHEN
        val result = raw.toTypedOrNull()

        // THEN
        assertNull(result)
    }

    @Test
    fun `toTypedOrNull succeeds for valid raw gadget`() {
        // GIVEN
        val raw = RawBrawlifyBrawlerGadget(
            id = GadgetId.MAX_VALUE,
            name = "Last Gadget",
            path = "last",
            version = 2,
            description = "Final gadget description",
            descriptionHtml = "<p>Final gadget description</p>",
            imageUrl = "https://cdn.brawlify.com/gadgets/borderless/${GadgetId.MAX_VALUE}",
            released = true,
        )

        // WHEN
        val result = raw.toTypedOrNull()

        // THEN
        assertNotNull(result)
        assertEquals(GadgetId.createOrThrow(GadgetId.MAX_VALUE), result.id)
        assertEquals("Last Gadget", result.name.rawString)
        assertEquals("last", result.pathSegment.rawString)
        assertEquals("Final gadget description", result.description.regular.rawString)
        assertEquals("<p>Final gadget description</p>", result.description.html.rawString)
        assertEquals(2, result.version.rawInt)
        assertEquals(true, result.isReleased)
    }
}
