package com.y9vad9.krawl.brawlify.test.brawler

import com.y9vad9.krawl.brawlify.brawler.BrawlifyStarPowerVersion
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class BrawlifyStarPowerVersionTest {

    @Test
    fun `isValid returns true for values greater or equal to FIRST`() {
        // GIVEN
        val validValue = BrawlifyStarPowerVersion.FIRST.rawInt

        // WHEN
        val result = BrawlifyStarPowerVersion.isValid(validValue)

        // THEN
        assertTrue(result)
    }

    @Test
    fun `isValid returns false for values less than FIRST`() {
        // GIVEN
        val invalidValue = BrawlifyStarPowerVersion.FIRST.rawInt - 1

        // WHEN
        val result = BrawlifyStarPowerVersion.isValid(invalidValue)

        // THEN
        assertFalse(result)
    }

    @Test
    fun `create succeeds for valid value`() {
        // GIVEN
        val value = 3

        // WHEN
        val result = BrawlifyStarPowerVersion.create(value)

        // THEN
        assertTrue(result.isSuccess)
        assertEquals(value, result.getOrThrow().rawInt)
    }

    @Test
    fun `create fails for invalid value`() {
        // GIVEN
        val value = 0

        // WHEN
        val result = BrawlifyStarPowerVersion.create(value)

        // THEN
        assertTrue(result.isFailure)
        assertFailsWith<IllegalArgumentException> { result.getOrThrow() }
    }

    @Test
    fun `createOrThrow succeeds for valid value`() {
        // GIVEN
        val value = 2

        // WHEN
        val version = BrawlifyStarPowerVersion.createOrThrow(value)

        // THEN
        assertEquals(value, version.rawInt)
    }

    @Test
    fun `createOrThrow throws for invalid value`() {
        // GIVEN
        val value = -1

        // WHEN / THEN
        assertFailsWith<IllegalArgumentException> {
            BrawlifyStarPowerVersion.createOrThrow(value)
        }
    }

    @Test
    fun `createOrNull returns version for valid value`() {
        // GIVEN
        val value = 5

        // WHEN
        val version = BrawlifyStarPowerVersion.createOrNull(value)

        // THEN
        assertNotNull(version)
        assertEquals(value, version.rawInt)
    }

    @Test
    fun `createOrNull returns null for invalid value`() {
        // GIVEN
        val value = 0

        // WHEN
        val version = BrawlifyStarPowerVersion.createOrNull(value)

        // THEN
        assertNull(version)
    }

    @Test
    fun `compareTo orders versions by rawInt`() {
        // GIVEN
        val lower = BrawlifyStarPowerVersion.createOrThrow(1)
        val higher = BrawlifyStarPowerVersion.createOrThrow(2)

        // WHEN / THEN
        assertTrue(lower < higher)
        assertTrue(higher > lower)
        assertEquals(0, lower.compareTo(lower))
    }

    @Test
    fun `createOrThrow and createOrNull behave consistently`() {
        // GIVEN
        val validValue = 7
        val invalidValue = -3

        // WHEN valid
        val throwVersion = BrawlifyStarPowerVersion.createOrThrow(validValue)
        val nullVersion = BrawlifyStarPowerVersion.createOrNull(validValue)

        // THEN both paths should yield the same version
        assertNotNull(nullVersion)
        assertEquals(throwVersion, nullVersion)

        // WHEN invalid
        val throwFails = runCatching { BrawlifyStarPowerVersion.createOrThrow(invalidValue) }
        val nullFails = BrawlifyStarPowerVersion.createOrNull(invalidValue)

        // THEN one throws, the other returns null
        assertTrue(throwFails.isFailure)
        assertNull(nullFails)
    }
}
