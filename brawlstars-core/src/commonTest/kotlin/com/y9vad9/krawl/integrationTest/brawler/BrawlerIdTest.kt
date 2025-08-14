package com.y9vad9.krawl.integrationTest.brawler

import com.y9vad9.krawl.brawler.BrawlerId
import kotlin.IllegalArgumentException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class BrawlerIdTest {
    // GIVEN
    private val validMin = BrawlerId.MIN_VALUE
    private val validMid = 16_000_100
    private val validMax = BrawlerId.MAX_VALUE
    private val invalidLow = BrawlerId.MIN_VALUE - 1
    private val invalidHigh = BrawlerId.MAX_VALUE + 1

    @Test
    fun `isValid returns true for values within range`() {
        // THEN
        assertTrue(BrawlerId.isValid(validMin))
        assertTrue(BrawlerId.isValid(validMid))
        assertTrue(BrawlerId.isValid(validMax))
    }

    @Test
    fun `isValid returns false for values outside range`() {
        // THEN
        assertFalse(BrawlerId.isValid(invalidLow))
        assertFalse(BrawlerId.isValid(invalidHigh))
    }

    @Test
    fun `create returns success for valid values`() {
        // WHEN
        val resultMin = BrawlerId.create(validMin)
        val resultMid = BrawlerId.create(validMid)
        val resultMax = BrawlerId.create(validMax)

        // THEN
        assertTrue(resultMin.isSuccess)
        assertTrue(resultMid.isSuccess)
        assertTrue(resultMax.isSuccess)

        assertEquals(
            expected = validMin,
            actual = resultMin.getOrNull()?.rawInt,
        )
        assertEquals(
            expected = validMid,
            actual = resultMid.getOrNull()?.rawInt,
        )
        assertEquals(
            expected = validMax,
            actual = resultMax.getOrNull()?.rawInt,
        )
    }

    @Test
    fun `create returns failure for invalid values`() {
        // WHEN
        val resultLow = BrawlerId.create(invalidLow)
        val resultHigh = BrawlerId.create(invalidHigh)

        // THEN
        assertTrue(resultLow.isFailure)
        assertTrue(resultHigh.isFailure)
    }

    @Test
    fun `createOrNull returns BrawlerId for valid values`() {
        // THEN
        assertEquals(
            expected = validMin,
            actual = BrawlerId.createOrNull(validMin)?.rawInt,
        )
        assertEquals(
            expected = validMid,
            actual = BrawlerId.createOrNull(validMid)?.rawInt,
        )
        assertEquals(
            expected = validMax,
            actual = BrawlerId.createOrNull(validMax)?.rawInt,
        )
    }

    @Test
    fun `createOrNull returns null for invalid values`() {
        // THEN
        assertNull(BrawlerId.createOrNull(invalidLow))
        assertNull(BrawlerId.createOrNull(invalidHigh))
    }

    @Test
    fun `createOrThrow returns BrawlerId for valid values`() {
        // WHEN
        val id = BrawlerId.createOrThrow(validMid)

        // THEN
        assertEquals(
            expected = validMid,
            actual = id.rawInt,
        )
    }

    @Test
    fun `createOrThrow throws for invalid values`() {
        // THEN
        assertFailsWith<IllegalArgumentException> {
            BrawlerId.createOrThrow(invalidLow)
        }
        assertFailsWith<IllegalArgumentException> {
            BrawlerId.createOrThrow(invalidHigh)
        }
    }

    @Test
    fun `factory methods are consistent for valid input`() {
        // WHEN
        val result = BrawlerId.create(validMid)

        // THEN
        assertTrue(result.isSuccess)
        val value = result.getOrNull()

        assertEquals(
            expected = BrawlerId.createOrNull(validMid),
            actual = value,
        )
        assertEquals(
            expected = BrawlerId.createOrThrow(validMid),
            actual = value,
        )
    }

    @Test
    fun `factory methods are consistent for invalid input`() {
        // WHEN
        val result = BrawlerId.create(invalidLow)

        // THEN
        assertTrue(result.isFailure)
        assertNull(BrawlerId.createOrNull(invalidLow))
        assertFailsWith<IllegalArgumentException> {
            BrawlerId.createOrThrow(invalidLow)
        }
    }

    @Test
    fun `compareTo compares underlying int values`() {
        // WHEN
        val smaller = BrawlerId.createOrThrow(validMin)
        val larger = BrawlerId.createOrThrow(validMax)

        // THEN
        assertTrue(smaller < larger)
        assertEquals(0, smaller.compareTo(smaller))
        assertTrue(larger > smaller)
    }

    @Test
    fun `value class stores and exposes the underlying int`() {
        // WHEN
        val id = BrawlerId.createOrThrow(validMid)

        // THEN
        assertEquals(
            expected = validMid,
            actual = id.rawInt,
        )
    }
}
