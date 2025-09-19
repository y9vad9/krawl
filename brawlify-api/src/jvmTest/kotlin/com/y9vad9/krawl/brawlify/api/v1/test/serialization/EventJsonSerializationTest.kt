package com.y9vad9.krawl.brawlify.api.v1.test.serialization

import com.y9vad9.krawl.brawlify.api.v1.event.RawBrawlifyEventsRotation
import kotlin.test.Test
import kotlinx.serialization.json.decodeFromStream
import org.junit.jupiter.api.assertDoesNotThrow

class EventJsonSerializationTest : com.y9vad9.krawl.test.WithJsonFixturesTest() {

    @Test
    fun `check no errors when serializing events from fixtures`() {
        // GIVEN
        val filePath = "v1/events/multiple.json"
        val stream = loadFixtureAsStream(filePath)

        // WHEN & THEN
        assertDoesNotThrow(
            message = "Couldn't serialize $filePath into ItemsResponse<BrawlifyEvent>"
        ) {
            json.decodeFromStream<RawBrawlifyEventsRotation>(stream)
        }
    }
}
