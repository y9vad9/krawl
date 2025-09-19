package com.y9vad9.krawl.brawlify.test.event

import com.y9vad9.krawl.brawlify.api.v1.event.statistics.RawBrawlifyMapBrawlerStatistics
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class BrawlifyMapBrawlerStatisticsConsistencyTest {

    @Test
    fun `valid raw statistics without starRate`() {
        // GIVEN
        val raw = RawBrawlifyMapBrawlerStatistics(
            brawler = 16_000_001,
            winRate = 55.0,
            useRate = 40.0,
            starRate = null
        )

        // WHEN
        val typedThrow = raw.toTypedOrThrow()
        val typedNull = raw.toTypedOrNull()

        // THEN
        assertEquals(16_000_001, typedThrow.brawlerId.rawInt)
        assertEquals(55.0, typedThrow.winRate.rawDouble)
        assertEquals(40.0, typedThrow.useRate.rawDouble)
        assertEquals(null, typedThrow.starRate)

        assertNotNull(typedNull)
        assertEquals(typedThrow, typedNull)
    }

    @Test
    fun `valid raw statistics with starRate`() {
        // GIVEN
        val raw = RawBrawlifyMapBrawlerStatistics(
            brawler = 16_000_002,
            winRate = 70.5,
            useRate = 60.0,
            starRate = 10.0
        )

        // WHEN
        val typedThrow = raw.toTypedOrThrow()
        val typedNull = raw.toTypedOrNull()

        // THEN
        assertEquals(16_000_002, typedThrow.brawlerId.rawInt)
        assertEquals(70.5, typedThrow.winRate.rawDouble)
        assertEquals(60.0, typedThrow.useRate.rawDouble)
        assertNotNull(typedThrow.starRate)
        assertEquals(10.0, typedThrow.starRate.rawDouble)

        assertNotNull(typedNull)
        assertEquals(typedThrow, typedNull)
    }

    @Test
    fun `invalid raw statistics returns null and throws consistently`() {
        // GIVEN
        val invalidRawList = listOf(
            RawBrawlifyMapBrawlerStatistics(brawler = -1, winRate = 50.0, useRate = 30.0, starRate = null),
            RawBrawlifyMapBrawlerStatistics(brawler = 16_000_003, winRate = -5.0, useRate = 30.0, starRate = null),
            RawBrawlifyMapBrawlerStatistics(brawler = 16_000_004, winRate = 50.0, useRate = 120.0, starRate = null),
            RawBrawlifyMapBrawlerStatistics(brawler = 16_000_005, winRate = 50.0, useRate = 50.0, starRate = -1.0),
            RawBrawlifyMapBrawlerStatistics(brawler = 16_000_006, winRate = 50.0, useRate = 50.0, starRate = 150.0)
        )

        invalidRawList.forEach { raw ->
            // WHEN / THEN
            val typedNull = raw.toTypedOrNull()
            assertNull(typedNull)
            assertFailsWith<IllegalArgumentException> { raw.toTypedOrThrow() }
        }
    }
}
