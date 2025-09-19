package com.y9vad9.krawl.brawlify.test.event

import com.y9vad9.krawl.brawlify.event.map.BrawlifyMapEnvironmentVersion
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class BrawlifyMapEnvironmentVersionTest {

    @Test
    fun `isValid returns true for values greater or equal to FIRST and false for lower`() {
        // GIVEN
        val validValues = listOf(BrawlifyMapEnvironmentVersion.FIRST.rawInt, 2, 10, 100)
        val invalidValues = listOf(0, -1, -100)

        // WHEN / THEN
        validValues.forEach { value ->
            assertTrue(BrawlifyMapEnvironmentVersion.isValid(value), "Expected $value to be valid")
        }

        invalidValues.forEach { value ->
            assertFalse(BrawlifyMapEnvironmentVersion.isValid(value), "Expected $value to be invalid")
        }
    }

    @Test
    fun `create returns success for valid values and failure for invalid`() {
        // GIVEN
        val validValue = 5
        val invalidValue = 0

        // WHEN
        val success = BrawlifyMapEnvironmentVersion.create(validValue)
        val failure = BrawlifyMapEnvironmentVersion.create(invalidValue)

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
        val instance = BrawlifyMapEnvironmentVersion.createOrThrow(validValue)

        // THEN
        assertEquals(validValue, instance.rawInt)
        assertFailsWith<IllegalArgumentException> { BrawlifyMapEnvironmentVersion.createOrThrow(invalidValue) }
    }

    @Test
    fun `createOrNull returns instance for valid values and null for invalid`() {
        // GIVEN
        val validValue = 1
        val invalidValue = -10

        // WHEN
        val instance = BrawlifyMapEnvironmentVersion.createOrNull(validValue)
        val nullInstance = BrawlifyMapEnvironmentVersion.createOrNull(invalidValue)

        // THEN
        assertNotNull(instance)
        assertEquals(validValue, instance.rawInt)
        assertNull(nullInstance)
    }

    @Test
    fun `FIRST constant has value 1`() {
        // GIVEN / THEN
        assertEquals(1, BrawlifyMapEnvironmentVersion.FIRST.rawInt)
    }

    @Test
    fun `compareTo works correctly`() {
        // GIVEN
        val v1 = BrawlifyMapEnvironmentVersion.createOrThrow(1)
        val v2 = BrawlifyMapEnvironmentVersion.createOrThrow(2)
        val v3 = BrawlifyMapEnvironmentVersion.createOrThrow(1)

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
            assertTrue(BrawlifyMapEnvironmentVersion.isValid(v))
            val result = BrawlifyMapEnvironmentVersion.create(v)
            assertTrue(result.isSuccess)
            assertEquals(v, result.getOrThrow().rawInt)
            assertEquals(v, BrawlifyMapEnvironmentVersion.createOrThrow(v).rawInt)
            assertEquals(v, BrawlifyMapEnvironmentVersion.createOrNull(v)?.rawInt)
        }

        invalidValues.forEach { v ->
            assertFalse(BrawlifyMapEnvironmentVersion.isValid(v))
            assertTrue(BrawlifyMapEnvironmentVersion.create(v).isFailure)
            assertFailsWith<IllegalArgumentException> { BrawlifyMapEnvironmentVersion.createOrThrow(v) }
            assertNull(BrawlifyMapEnvironmentVersion.createOrNull(v))
        }
    }
}
