package com.y9vad9.krawl.brawlify.test.brawler

import com.y9vad9.krawl.brawlify.api.v1.brawler.RawBrawlifyBrawler
import com.y9vad9.krawl.brawlify.api.v1.brawler.RawBrawlifyBrawlerClass
import com.y9vad9.krawl.brawlify.api.v1.brawler.RawBrawlifyBrawlerGadget
import com.y9vad9.krawl.brawlify.api.v1.brawler.RawBrawlifyBrawlerRarity
import com.y9vad9.krawl.brawlify.api.v1.brawler.RawBrawlifyBrawlerStarPower
import com.y9vad9.krawl.brawlify.brawler.BrawlifyBrawler
import com.y9vad9.krawl.brawlify.brawler.toTypedOrNull
import com.y9vad9.krawl.brawlify.brawler.toTypedOrThrow
import com.y9vad9.krawl.test.WithJsonFixturesTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertIs
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.decodeFromStream
import kotlinx.serialization.json.jsonArray

class BrawlifyBrawlerTest : WithJsonFixturesTest() {

    private fun validRawBrawler(
        id: Int = 16_000_010,
        name: String = "Shelly",
        released: Boolean = true,
        gadgetCount: Int = 1,
        starPowerCount: Int = 1,
    ) = RawBrawlifyBrawler(
        id = id,
        avatarId = 0,
        name = name,
        hash = "shelly_hash",
        path = "shelly",
        fankit = "shelly",
        released = released,
        version = 1,
        link = "https://brawlify.com/shelly",
        imageUrl = "https://cdn.brawlify.com/brawlers/borders/$id",
        imageUrl2 = "https://cdn.brawlify.com/brawlers/borderless/$id",
        imageUrl3 = "https://cdn.brawlify.com/brawlers/emoji/$id",
        classInfo = RawBrawlifyBrawlerClass(
            id = 1,
            name = "Damage Dealer"
        ),
        rarity = RawBrawlifyBrawlerRarity(
            id = 1,
            name = "Common",
            color = "#000"
        ),
        unlock = null,
        description = "desc",
        descriptionHtml = "<p>desc</p>",
        starPowers = List(starPowerCount) {
            RawBrawlifyBrawlerStarPower(
                id = 23_000_010 + it,
                name = "Star $it",
                description = "desc",
                descriptionHtml = "<p>desc</p>",
                imageUrl = "https://cdn.brawlify.com/star-powers/borderless/$it",
                released = true,
                path = "test$it",
                version = 1,
            )
        },
        gadgets = List(gadgetCount) {
            val id = 23_000_010 + it

            RawBrawlifyBrawlerGadget(
                id = id,
                name = "Gadget $it",
                path = "gadget$it",
                description = "desc",
                descriptionHtml = "<p>desc</p>",
                version = 1,
                released = true,
                imageUrl = "https://cdn.brawlify.com/gadgets/borderless/$id"
            )
        },
        videos = emptyList()
    )

    @Test
    fun `toTypedOrThrow returns fully mapped BrawlifyBrawler and matches toTypedOrNull`() {
        // GIVEN
        val raw = validRawBrawler()

        // WHEN
        val typedThrow = raw.toTypedOrThrow()
        val typedNull = raw.toTypedOrNull()

        // THEN
        assertIs<BrawlifyBrawler>(
            value = typedThrow,
        )
        assertEquals(
            expected = typedThrow,
            actual = typedNull,
        )
        assertEquals(
            expected = raw.id,
            actual = typedThrow.id.rawInt,
        )
        assertEquals(
            expected = raw.name,
            actual = typedThrow.name.rawString,
        )
        assertEquals(
            expected = raw.released,
            actual = typedThrow.isReleased,
        )
        assertEquals(
            expected = raw.description,
            actual = typedThrow.description.regular.rawString,
        )
        assertEquals(
            expected = raw.descriptionHtml,
            actual = typedThrow.description.html.rawString,
        )
        assertEquals(
            expected = raw.imageUrl,
            actual = typedThrow.image.border.rawString,
        )
        assertEquals(
            expected = raw.borderlessImageUrl,
            actual = typedThrow.image.borderless.rawString,
        )
        assertEquals(
            expected = raw.fankitImageUrl,
            actual = typedThrow.image.emoji.rawString,
        )
        assertEquals(
            expected = raw.classInfo.id,
            actual = typedThrow.classification.id.rawInt,
        )
        assertEquals(
            expected = raw.classInfo.name,
            actual = typedThrow.classification.name.rawString,
        )
        assertEquals(
            expected = raw.rarity.id,
            actual = typedThrow.rarity.id.rawInt,
        )
        assertEquals(
            expected = raw.rarity.name,
            actual = typedThrow.rarity.name.rawString,
        )
    }

    @Test
    fun `toTypedOrThrow maps gadgets and star powers correctly and matches toTypedOrNull`() {
        // GIVEN
        val raw = validRawBrawler(gadgetCount = 2, starPowerCount = 2)

        // WHEN
        val typedThrow = raw.toTypedOrThrow()
        val typedNull = raw.toTypedOrNull()

        // THEN
        assertEquals(
            expected = typedThrow,
            actual = typedNull,
        )
        assertEquals(
            expected = raw.gadgets.size,
            actual = typedThrow.gadgets.size,
        )
        typedThrow.gadgets.forEachIndexed { index, gadget ->
            val rawG = raw.gadgets[index]
            assertEquals(
                expected = rawG.id,
                actual = gadget.id.rawInt,
            )
            assertEquals(
                expected = rawG.name,
                actual = gadget.name.rawString,
            )
            assertEquals(
                expected = rawG.path,
                actual = gadget.pathSegment.rawString,
            )
            assertEquals(
                expected = rawG.description,
                actual = gadget.description.regular.rawString,
            )
            assertEquals(
                expected = rawG.descriptionHtml,
                actual = gadget.description.html.rawString,
            )
        }
        assertEquals(
            expected = raw.starPowers.size,
            actual = typedThrow.starPowers.size,
        )
        typedThrow.starPowers.forEachIndexed { index, star ->
            val rawS = raw.starPowers[index]
            assertEquals(
                expected = rawS.id,
                actual = star.id.rawInt,
            )
            assertEquals(
                expected = rawS.name,
                actual = star.name.rawString,
            )
            assertEquals(
                expected = rawS.description,
                actual = star.description.regular.rawString,
            )
            assertEquals(
                expected = rawS.descriptionHtml,
                actual = star.description.html.rawString,
            )
        }
    }

    @Test
    fun `toTypedOrNull returns null for invalid Brawler id and matches toTypedOrThrow failure`() {
        // GIVEN
        val raw = validRawBrawler(id = 0)

        // WHEN
        val typedNull = raw.toTypedOrNull()

        // THEN
        assertNull(
            actual = typedNull,
        )
        assertFails {
            raw.toTypedOrThrow()
        }
    }

    @Test
    fun `toTypedOrNull returns null for invalid gadget id and matches toTypedOrThrow failure`() {
        // GIVEN
        val raw = validRawBrawler().copy(
            gadgets = listOf(
                RawBrawlifyBrawlerGadget(
                    id = 0,
                    name = "Bad Gadget",
                    path = "bad",
                    description = "desc",
                    descriptionHtml = "<p>desc</p>",
                    version = 1,
                    released = true,
                    imageUrl = "https://cdn.brawlify.com/gadgets/borderless/0",
                )
            )
        )

        // WHEN
        val typedNull = raw.toTypedOrNull()

        // THEN
        assertNull(
            actual = typedNull,
        )
        assertFails {
            raw.toTypedOrThrow()
        }
    }

    @Test
    fun `toTypedOrNull returns null for invalid star power id and matches toTypedOrThrow failure`() {
        // GIVEN
        val raw = validRawBrawler().copy(
            starPowers = listOf(
                RawBrawlifyBrawlerStarPower(
                    id = 0,
                    name = "Bad Star",
                    description = "desc",
                    descriptionHtml = "<p>desc</p>",
                    imageUrl = "https://image",
                    released = true,
                    path = "bad",
                    version = 1,
                )
            )
        )

        // WHEN
        val typedNull = raw.toTypedOrNull()

        // THEN
        assertNull(
            actual = typedNull,
        )
        assertFails {
            raw.toTypedOrThrow()
        }
    }

    @Test
    fun `toTypedOrThrow returns empty list for gadgets and star powers if raw list empty and matches toTypedOrNull`() {
        // GIVEN
        val raw = validRawBrawler(gadgetCount = 0, starPowerCount = 0)

        // WHEN
        val typedThrow = raw.toTypedOrThrow()
        val typedNull = raw.toTypedOrNull()

        // THEN
        assertEquals(
            expected = typedThrow,
            actual = typedNull,
        )
        assertEquals(
            expected = 0,
            actual = typedThrow.gadgets.size,
        )
        assertEquals(
            expected = 0,
            actual = typedThrow.starPowers.size,
        )
    }

    @OptIn(ExperimentalSerializationApi::class)
    @Test
    fun `mapping does not fail on single fixture`() {
        // GIVEN
        val raw: RawBrawlifyBrawler = json.decodeFromStream(
            stream = loadFixtureAsStream("v1/brawlers/single.json"),
        )

        // WHEN
        val typedOrThrow = runCatching { raw.toTypedOrThrow() }
        val typedOrNull = raw.toTypedOrNull()

        // THEN
        assertTrue(
            actual = typedOrThrow.isSuccess,
            message = "Mapping shouldn't have failed on test fixture. " +
                "Exception: ${typedOrThrow.exceptionOrNull()?.stackTraceToString()}",
        )
        assertNotNull(
            actual = typedOrNull,
            message = "Mapping shouldn't have failed on test fixture. It seems that `toTypedOrNull` " +
                "gives inconsistent with `toTypedOrThrow` result.",
        )
    }

    @OptIn(ExperimentalSerializationApi::class)
    @Test
    fun `mapping does not fail on multiple fixture`() {
        // GIVEN
        val raw: List<RawBrawlifyBrawler> = json.decodeFromStream<JsonObject>(
            stream = loadFixtureAsStream("v1/brawlers/multiple.json"),
        )["list"]!!.jsonArray.let { json.decodeFromJsonElement(it) }

        // WHEN
        val typedOrThrow = raw.map { runCatching { it.toTypedOrThrow() } }
        val typedOrNull = raw.map { it.toTypedOrNull() }

        // THEN
        typedOrThrow.forEach { result ->
            assertTrue(
                actual = result.isSuccess,
                message = "Mapping shouldn't have failed on test fixture. " +
                    "Exception: ${result.exceptionOrNull()?.stackTraceToString()}." +
                    "Raw data: $result.",
            )
        }
        typedOrNull.forEach { raw ->
            assertNotNull(
                actual = raw,
                message = "Mapping shouldn't have failed on test fixture. It seems that `toTypedOrNull` " +
                    "gives inconsistent with `toTypedOrThrow` result. Raw data: $raw.",
            )
        }
    }
}
