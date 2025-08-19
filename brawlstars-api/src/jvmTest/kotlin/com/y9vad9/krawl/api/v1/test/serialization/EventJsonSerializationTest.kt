package com.y9vad9.krawl.api.v1.test.serialization

import com.y9vad9.krawl.api.v1.event.ScheduledEvent
import com.y9vad9.krawl.api.v1.test.JsonFixturesTest
import kotlin.test.Test
import kotlinx.serialization.json.decodeFromStream
import org.junit.jupiter.api.assertDoesNotThrow

class EventJsonSerializationTest : JsonFixturesTest() {
    @Test
    fun `check no errors when serializing test fixtures battlelog`() {
        // GIVEN
        val filePath = "/api/v1/events/rotation/example_response.json"
        val fileStream = loadFixtureAsStream(filePath)

        // WHEN & THEN
        assertDoesNotThrow(
            message = "Couldn't serialize $filePath into PaginatedList<BattleRecord>"
        ) {
            json.decodeFromStream<List<ScheduledEvent>>(fileStream)
        }
    }
}
