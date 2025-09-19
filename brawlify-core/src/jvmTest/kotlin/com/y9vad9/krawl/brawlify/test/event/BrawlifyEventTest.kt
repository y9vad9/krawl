package com.y9vad9.krawl.brawlify.test.event

import com.y9vad9.krawl.brawlify.api.v1.event.RawBrawlifyEvent
import com.y9vad9.krawl.brawlify.api.v1.event.RawBrawlifyEventSlot
import com.y9vad9.krawl.brawlify.api.v1.event.RawBrawlifyGameModeView
import com.y9vad9.krawl.brawlify.api.v1.event.RawBrawlifyMap
import com.y9vad9.krawl.brawlify.api.v1.event.RawBrawlifyMapEnvironment
import com.y9vad9.krawl.brawlify.api.v1.event.statistics.RawBrawlifyMapTeamStatistics
import com.y9vad9.krawl.brawlify.api.v1.event.statistics.RawBrawlifyMapTeamStatisticsData
import com.y9vad9.krawl.brawlify.event.toTypedOrNull
import com.y9vad9.krawl.brawlify.event.toTypedOrThrow
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlin.test.assertFalse
import kotlin.time.Instant

class BrawlifyEventTest {

    private fun createRawEventSlot(): RawBrawlifyEventSlot =
        RawBrawlifyEventSlot(
            id = 15000000,
            name = "Bounty",
            emoji = "⭐",
            hash = "bounty",
            listAlone = false,
            hideable = false,
            hideForSlot = null,
            background = null
        )

    private fun createRawMap(): RawBrawlifyMap =
        RawBrawlifyMap(
            id = 15000123,
            new = false,
            disabled = false,
            name = "Gem Grab Map",
            hash = "gemgrabmap",
            version = 1,
            link = "https://brawlify.com/maps/gemgrabmap",
            imageUrl = "https://cdn.brawlify.com/maps/borderless/123.png",
            credit = null,
            environment = RawBrawlifyMapEnvironment(
                id = 1,
                scId = 1,
                name = "Desert",
                hash = "desert",
                path = "desert",
                version = 1,
                imageUrl = "https://cdn.brawlify.com/maps/environment/desert.png"
            ),
            gameMode = RawBrawlifyGameModeView(
                id = null,
                scId = 48_000_000,
                name = "Gem Grab",
                hash = "gemgrab",
                version = 1,
                color = "#FF0000",
                bgColor = "#00FF00",
                link = "https://brawlify.com/modes/gemgrab",
                imageUrl = "https://cdn.brawlify.com/modes/gemgrab.png"
            ),
            stats = emptyList(),
            teamStats = emptyList()
        )

    @Test
    fun `toTypedOrThrow converts RawBrawlifyEvent correctly`() {
        // GIVEN
        val rawEvent = RawBrawlifyEvent(
            slot = createRawEventSlot(),
            predicted = true,
            startTime = "2025-08-29T12:00:00Z",
            endTime = "2025-08-29T14:00:00Z",
            reward = 100,
            map = createRawMap(),
            modifier = null
        )

        // WHEN
        val event = rawEvent.toTypedOrThrow()

        // THEN
        assertEquals(Instant.parse("2025-08-29T12:00:00Z"), event.startTime)
        assertEquals(Instant.parse("2025-08-29T14:00:00Z"), event.endTime)
        assertNotNull(event.slot)
        assertNotNull(event.map)
        assertTrue(event.isPredicted)
    }

    @Test
    fun `toTypedOrNull returns instance for valid raw event`() {
        val rawEvent = RawBrawlifyEvent(
            slot = createRawEventSlot(),
            predicted = false,
            startTime = "2025-08-29T12:00:00Z",
            endTime = "2025-08-29T12:30:00Z",
            reward = 50,
            map = createRawMap(),
            modifier = null
        )

        val event = rawEvent.toTypedOrNull()
        assertNotNull(event)
        assertFalse(event.isPredicted)
        assertEquals(Instant.parse("2025-08-29T12:00:00Z"), event.startTime)
        assertEquals(Instant.parse("2025-08-29T12:30:00Z"), event.endTime)
    }

    @Test
    fun `toTypedOrNull returns null for invalid raw event`() {
        val invalidRawEvent = RawBrawlifyEvent(
            slot = createRawEventSlot(),
            predicted = true,
            startTime = "invalid-time",
            endTime = "2025-08-29T14:00:00Z",
            reward = 0,
            map = createRawMap(),
            modifier = null
        )

        val event = invalidRawEvent.toTypedOrNull()
        assertNull(event)
    }

    @Test
    fun `startTime and endTime properties match timeline`() {
        val rawEvent = RawBrawlifyEvent(
            slot = createRawEventSlot(),
            predicted = true,
            startTime = "2025-08-29T10:00:00Z",
            endTime = "2025-08-29T11:00:00Z",
            reward = 100,
            map = createRawMap(),
            modifier = null
        )

        val event = rawEvent.toTypedOrThrow()

        assertEquals(event.timeline.start, event.startTime)
        assertEquals(event.timeline.endInclusive, event.endTime)
    }

    @Test
    fun `toTypedOrThrow handles optional fields correctly`() {
        // GIVEN
        val rawEventSlot = RawBrawlifyEventSlot(
            id = 15000001,
            name = "Showdown",
            emoji = "🔥",
            hash = "showdown",
            listAlone = true,
            hideable = true,
            hideForSlot = 15000000, // nullable with a value
            background = "https://cdn.brawlify.com/eventslot/bg/showdown.png" // nullable with a value
        )

        val rawMap = RawBrawlifyMap(
            id = 15000234,
            new = true,
            disabled = false,
            name = "Heist Map",
            hash = "heistmap",
            version = 2,
            link = "https://brawlify.com/maps/heistmap",
            imageUrl = "https://cdn.brawlify.com/maps/borderless/234.png",
            credit = "Player123", // optional field provided
            environment = RawBrawlifyMapEnvironment(
                id = 2,
                scId = 2,
                name = "Forest",
                hash = "forest",
                path = "forest-path",
                version = 2,
                imageUrl = "https://cdn.brawlify.com/maps/environment/forest.png"
            ),
            gameMode = RawBrawlifyGameModeView(
                id = null,
                scId = 48000001,
                name = "Heist",
                hash = "heist",
                version = 2,
                color = "#123456",
                bgColor = "#654321",
                link = "https://brawlify.com/modes/heist",
                imageUrl = "https://cdn.brawlify.com/modes/heist.png"
            ),
            stats = emptyList(),
            teamStats = emptyList(),
            lastActive = 1_715_000_000,
            dataUpdated = 1_720_000_000
        )

        val rawEvent = RawBrawlifyEvent(
            slot = rawEventSlot,
            predicted = false,
            startTime = "2025-08-29T15:00:00Z",
            endTime = "2025-08-29T16:30:00Z",
            reward = 200,
            map = rawMap,
            modifier = "Double XP"
        )

        // WHEN
        val event = rawEvent.toTypedOrThrow()

        // THEN
        assertNotNull(event.slot.hideForSlot)
        assertEquals(15000000, event.slot.hideForSlot?.rawInt)
        assertNotNull(event.slot.backgroundUrl)
        assertEquals("https://cdn.brawlify.com/eventslot/bg/showdown.png", event.slot.backgroundUrl!!.rawString)
        assertNotNull(event.map.conceptOwner)
        assertEquals("Player123", event.map.conceptOwner?.rawString)
        assertEquals(Instant.fromEpochSeconds(1_715_000_000), event.map.lastActiveTime)
        assertEquals(Instant.fromEpochSeconds(1_720_000_000), event.map.dataUpdateTime)
        assertEquals("Double XP", rawEvent.modifier)
    }

    @Test
    fun `toTypedOrThrow correctly converts multi-brawler team stats`() {
        // GIVEN
        val teamStatsRaw = listOf(
            RawBrawlifyMapTeamStatistics(
                name = "Team Alpha",
                hash = "team-alpha",
                brawler1 = 16_000_001,
                brawler2 = 16_000_002,
                brawler3 = 16_000_003,
                brawler4 = 16_000_004,
                brawler5 = 16_000_005,
                data = RawBrawlifyMapTeamStatisticsData(
                    winRate = 0.75,
                    useRate = 0.6,
                    wins = 10,
                    losses = 3,
                    draws = 2,
                    total = 15
                )
            )
        )

        val rawMap = createRawMap().copy(teamStats = teamStatsRaw)
        val rawEvent = RawBrawlifyEvent(
            slot = createRawEventSlot(),
            predicted = true,
            startTime = "2025-08-29T17:00:00Z",
            endTime = "2025-08-29T18:00:00Z",
            reward = 150,
            map = rawMap,
            modifier = null
        )

        // WHEN
        val event = rawEvent.toTypedOrThrow()
        val teamStats = event.map.teamStatistics

        // THEN
        assertEquals(1, teamStats.size)
        val teamAlpha = teamStats.first()
        assertEquals("Team Alpha", teamAlpha.name.rawString)
        assertEquals(5, teamAlpha.brawlers.size)
        assertEquals(0.75, teamAlpha.recordedData.winRate.rawDouble, 1e-9)
        assertEquals(10, teamAlpha.recordedData.wins.rawInt)
    }

    @Test
    fun `toTypedOrThrow converts environment and game mode correctly`() {
        // GIVEN
        val rawMap = createRawMap()
        val rawEvent = RawBrawlifyEvent(
            slot = createRawEventSlot(),
            predicted = false,
            startTime = "2025-08-29T19:00:00Z",
            endTime = "2025-08-29T20:00:00Z",
            reward = 120,
            map = rawMap,
            modifier = null
        )

        // WHEN
        val event = rawEvent.toTypedOrThrow()
        val env = event.map.environment
        val mode = event.map.gamemode

        // THEN
        assertEquals("Desert", env.name.rawString)
        assertEquals("desert", env.pathSegment.rawString)
        assertEquals("Gem Grab", mode.name.rawString)
        assertEquals("#FF0000", mode.color.primary.rawString)
        assertEquals("#00FF00", mode.color.background.rawString)
    }
}