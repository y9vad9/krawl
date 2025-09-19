package com.y9vad9.krawl.brawlify.test.brawler

import com.y9vad9.krawl.brawlify.api.v1.brawler.RawBrawlifyBrawlerStarPower
import com.y9vad9.krawl.brawlify.brawler.toTypedOrNull
import com.y9vad9.krawl.brawlify.brawler.toTypedOrThrow
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertFails

class BrawlifyBrawlerStarPowerTest {

    private fun validRawStarPower(
        id: Int = 23_000_998,
        name: String = "Power Shot",
        description: String = "Does extra damage",
        descriptionHtml: String = "<p>Does extra damage</p>",
        imageUrl: String = "https://cdn.brawlify.com/star-powers/borderless/23000998.png",
        released: Boolean = true,
    ) = RawBrawlifyBrawlerStarPower(
        id = id,
        name = name,
        path = "power-shot",
        version = 1,
        description = description,
        descriptionHtml = descriptionHtml,
        imageUrl = imageUrl,
        released = released
    )

    @Test
    fun `toTypedOrThrow maps all fields correctly`() {
        // GIVEN
        val raw = validRawStarPower()

        // WHEN
        val typed = raw.toTypedOrThrow()

        // THEN
        assertEquals(raw.id, typed.id.rawInt)
        assertEquals(raw.name, typed.name.rawString)
        assertEquals(raw.description, typed.description.regular.rawString)
        assertEquals(raw.descriptionHtml, typed.description.html.rawString)
        assertEquals(raw.imageUrl, typed.imageUrl.rawString)
        assertEquals(raw.released, typed.isReleased)
    }

    @Test
    fun `toTypedOrNull returns same as toTypedOrThrow when valid`() {
        // GIVEN
        val raw = validRawStarPower()

        // WHEN
        val typedThrow = raw.toTypedOrThrow()
        val typedNull = raw.toTypedOrNull()

        // THEN
        assertEquals(typedThrow, typedNull)
    }

    @Test
    fun `toTypedOrNull returns null on invalid id`() {
        // GIVEN
        val raw = validRawStarPower(id = 0) // invalid StarPowerId

        // WHEN
        val typedNull = raw.toTypedOrNull()

        // THEN
        assertNull(typedNull)
    }

    @Test
    fun `toTypedOrThrow throws on invalid id`() {
        // GIVEN
        val raw = validRawStarPower(id = 0)

        // THEN
        assertFails { raw.toTypedOrThrow() }
    }

    @Test
    fun `toTypedOrNull returns null on invalid imageUrl`() {
        // GIVEN
        val raw = validRawStarPower(imageUrl = "invalid-url")

        // WHEN
        val typedNull = raw.toTypedOrNull()

        // THEN
        assertNull(typedNull)
    }
}
