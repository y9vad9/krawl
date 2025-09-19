package com.y9vad9.krawl.brawlify.test.event

import com.y9vad9.krawl.brawlify.event.map.BrawlifyPercentRate
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class BrawlifyPercentRateTest {

    @Test
    fun `isValid returns true for valid values and false for invalid`() {
        // GIVEN
        val validValues = listOf(0.0, 50.0, 100.0, 0.0001, 99.9999)
        val invalidValues = listOf(-0.1, -100.0, 100.1, 200.0)

        // WHEN / THEN
        validValues.forEach { value ->
            assertTrue(BrawlifyPercentRate.isValid(value), "Expected $value to be valid")
        }

        invalidValues.forEach { value ->
            assertFalse(BrawlifyPercentRate.isValid(value), "Expected $value to be invalid")
        }
    }

    @Test
    fun `create returns success for valid values and failure for invalid`() {
        // GIVEN
        val validValue = 42.0
        val invalidValue = -5.0

        // WHEN
        val success = BrawlifyPercentRate.create(validValue)
        val failure = BrawlifyPercentRate.create(invalidValue)

        // THEN
        assertTrue(success.isSuccess)
        assertEquals(validValue, success.getOrThrow().rawDouble)

        assertTrue(failure.isFailure)
        assertFailsWith<IllegalArgumentException> { failure.getOrThrow() }
    }

    @Test
    fun `createOrThrow returns instance for valid values and throws for invalid`() {
        // GIVEN
        val validValue = 75.5
        val invalidValue = 105.0

        // WHEN
        val instance = BrawlifyPercentRate.createOrThrow(validValue)

        // THEN
        assertEquals(validValue, instance.rawDouble)
        assertFailsWith<IllegalArgumentException> { BrawlifyPercentRate.createOrThrow(invalidValue) }
    }

    @Test
    fun `createOrNull returns instance for valid values and null for invalid`() {
        // GIVEN
        val validValue = 33.3
        val invalidValue = -0.5

        // WHEN
        val instance = BrawlifyPercentRate.createOrNull(validValue)
        val nullInstance = BrawlifyPercentRate.createOrNull(invalidValue)

        // THEN
        assertNotNull(instance)
        assertEquals(validValue, instance.rawDouble)
        assertNull(nullInstance)
    }

    @Test
    fun `MIN and MAX constants are correct`() {
        // GIVEN / THEN
        assertEquals(0.0, BrawlifyPercentRate.MIN.rawDouble)
        assertEquals(100.0, BrawlifyPercentRate.MAX.rawDouble)
    }

    @Test
    fun `compareTo works correctly`() {
        // GIVEN
        val a = BrawlifyPercentRate.createOrThrow(10.0)
        val b = BrawlifyPercentRate.createOrThrow(20.0)
        val c = BrawlifyPercentRate.createOrThrow(10.0)

        // THEN
        assertTrue(a < b)
        assertTrue(b > a)
        assertEquals(0, a.compareTo(c))
    }

    @Test
    fun `toString returns formatted string`() {
        // GIVEN
        val rate = BrawlifyPercentRate.createOrThrow(55.5)

        // WHEN
        val str = rate.toString()

        // THEN
        assertEquals("BrawlifyPercentRate(55.5%)", str)
    }

    @Test
    fun `consistency between isValid, create, createOrThrow, createOrNull`() {
        // GIVEN
        val validValues = listOf(0.0, 50.0, 100.0)
        val invalidValues = listOf(-1.0, 101.0)

        // WHEN / THEN
        validValues.forEach { v ->
            assertTrue(BrawlifyPercentRate.isValid(v))
            val result = BrawlifyPercentRate.create(v)
            assertTrue(result.isSuccess)
            assertEquals(v, result.getOrThrow().rawDouble)
            assertEquals(v, BrawlifyPercentRate.createOrThrow(v).rawDouble)
            assertEquals(v, BrawlifyPercentRate.createOrNull(v)?.rawDouble)
        }

        invalidValues.forEach { v ->
            assertFalse(BrawlifyPercentRate.isValid(v))
            assertTrue(BrawlifyPercentRate.create(v).isFailure)
            assertFailsWith<IllegalArgumentException> { BrawlifyPercentRate.createOrThrow(v) }
            assertNull(BrawlifyPercentRate.createOrNull(v))
        }
    }
}
