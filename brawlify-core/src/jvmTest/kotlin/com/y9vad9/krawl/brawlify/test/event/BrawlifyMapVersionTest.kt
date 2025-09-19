package com.y9vad9.krawl.brawlify.test.event

import com.y9vad9.krawl.brawlify.event.map.BrawlifyMapVersion
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class BrawlifyMapVersionTest {

    @Test
    fun `isValid returns true for values greater or equal FIRST and false for lower`() {
        // GIVEN
        val validValues = listOf(BrawlifyMapVersion.FIRST.rawInt, 2, 10, 100)
        val invalidValues = listOf(0, -1, -100)

        // WHEN / THEN
        validValues.forEach { value ->
            assertTrue(BrawlifyMapVersion.isValid(value), "Expected $value to be valid")
        }

        invalidValues.forEach { value ->
            assertFalse(BrawlifyMapVersion.isValid(value), "Expected $value to be invalid")
        }
    }

    @Test
    fun `create returns success for valid values and failure for invalid`() {
        // GIVEN
        val validValue = 5
        val invalidValue = 0

        // WHEN
        val success = BrawlifyMapVersion.create(validValue)
        val failure = BrawlifyMapVersion.create(invalidValue)

        // THEN
        assertTrue(success.isSuccess)
        assertEquals(validValue, success.getOrThrow().rawInt)

        assertTrue(failure.isFailure)
        assertFailsWith<IllegalArgumentException> { failure.getOrThrow() }
    }

    @Test
    fun `createOrThrow returns instance for valid values and throws for invalid`() {
        // GIVEN
        val validValue = 7
        val invalidValue = -3

        // WHEN
        val instance = BrawlifyMapVersion.createOrThrow(validValue)

        // THEN
        assertEquals(validValue, instance.rawInt)
        assertFailsWith<IllegalArgumentException> { BrawlifyMapVersion.createOrThrow(invalidValue) }
    }

    @Test
    fun `createOrNull returns instance for valid values and null for invalid`() {
        // GIVEN
        val validValue = 1
        val invalidValue = -10

        // WHEN
        val instance = BrawlifyMapVersion.createOrNull(validValue)
        val nullInstance = BrawlifyMapVersion.createOrNull(invalidValue)

        // THEN
        assertNotNull(instance)
        assertEquals(validValue, instance.rawInt)
        assertNull(nullInstance)
    }

    @Test
    fun `FIRST constant has value 1`() {
        // GIVEN / THEN
        assertEquals(1, BrawlifyMapVersion.FIRST.rawInt)
    }

    @Test
    fun `compareTo works correctly`() {
        // GIVEN
        val v1 = BrawlifyMapVersion.createOrThrow(1)
        val v2 = BrawlifyMapVersion.createOrThrow(2)
        val v3 = BrawlifyMapVersion.createOrThrow(1)

        // THEN
        assertTrue(v1 < v2)
        assertTrue(v2 > v1)
        assertEquals(0, v1.compareTo(v3))
    }

    @Test
    fun `consistency between isValid, create, createOrThrow, createOrNull`() {
        // GIVEN
        val validValues = listOf(1, 5, 10)
        val invalidValues = listOf(-1, 0)

        // WHEN / THEN
        validValues.forEach { v ->
            assertTrue(BrawlifyMapVersion.isValid(v))
            val result = BrawlifyMapVersion.create(v)
            assertTrue(result.isSuccess)
            assertEquals(v, result.getOrThrow().rawInt)
            assertEquals(v, BrawlifyMapVersion.createOrThrow(v).rawInt)
            assertEquals(v, BrawlifyMapVersion.createOrNull(v)?.rawInt)
        }

        invalidValues.forEach { v ->
            assertFalse(BrawlifyMapVersion.isValid(v))
            assertTrue(BrawlifyMapVersion.create(v).isFailure)
            assertFailsWith<IllegalArgumentException> { BrawlifyMapVersion.createOrThrow(v) }
            assertNull(BrawlifyMapVersion.createOrNull(v))
        }
    }
}