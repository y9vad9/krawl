package com.y9vad9.krawl.brawlify.api.v1.test.serialization

import com.y9vad9.krawl.brawlify.api.v1.icon.RawBrawlifyIcons
import kotlin.test.Test
import kotlinx.serialization.json.decodeFromStream
import org.junit.jupiter.api.assertDoesNotThrow

class IconsJsonSerializationTest : com.y9vad9.krawl.test.WithJsonFixturesTest() {
    @Test
    fun `check no errors when serializing icons from fixtures`() {
        // GIVEN
        val filePath = "v1/icons/multiple.json"
        val stream = loadFixtureAsStream(filePath)

        // WHEN & THEN
        assertDoesNotThrow(
            message = "Couldn't serialize $filePath into ItemsResponse<BrawlifyIcons>"
        ) {
            json.decodeFromStream<RawBrawlifyIcons>(stream)
        }
    }
}
