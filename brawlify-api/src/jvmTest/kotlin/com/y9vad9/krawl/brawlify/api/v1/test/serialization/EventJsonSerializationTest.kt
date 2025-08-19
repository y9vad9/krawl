package com.y9vad9.krawl.brawlify.api.v1.test.serialization

import com.y9vad9.krawl.brawlify.api.v1.event.BrawlifyEventRotation
import com.y9vad9.krawl.brawlify.api.v1.test.JsonFixturesTest
import kotlin.test.Test
import kotlinx.serialization.json.decodeFromStream
import org.junit.jupiter.api.assertDoesNotThrow

class EventJsonSerializationTest : JsonFixturesTest() {

    @Test
    fun `check no errors when serializing events from fixtures`() {
        // GIVEN
        val filePath = "api/v1/events/multiple.json"
        val stream = loadFixtureAsStream(filePath)

        // WHEN & THEN
        assertDoesNotThrow(
            message = "Couldn't serialize $filePath into ItemsResponse<BrawlifyEvent>"
        ) {
            json.decodeFromStream<BrawlifyEventRotation>(stream)
        }
    }
}
