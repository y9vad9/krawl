package com.y9vad9.krawl.brawlify.test.brawler

import com.y9vad9.krawl.brawlify.brawler.BrawlifyGadgetVersion
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class BrawlifyGadgetVersionTest {

    @Test
    fun `FIRST constant has value 1`() {
        // GIVEN
        val first = BrawlifyGadgetVersion.FIRST

        // THEN
        assertEquals(
            expected = 1,
            actual = first.rawInt,
        )
    }

    @Test
    fun `create succeeds for valid values`() {
        // GIVEN
        val validValues = listOf(1, 2, 10, 100)

        validValues.forEach { value ->
            // WHEN
            val result = BrawlifyGadgetVersion.create(value)

            // THEN
            assertTrue(
                actual = result.isSuccess,
                message = "Expected success for value $value",
            )
            val version = result.getOrNull()
            assertNotNull(
                actual = version,
                message = "Resulting version should not be null",
            )
            assertEquals(
                expected = value,
                actual = version.rawInt,
            )
        }
    }

    @Test
    fun `create fails for invalid values`() {
        // GIVEN
        val invalidValues = listOf(0, -1, -100)

        invalidValues.forEach { value ->
            // WHEN
            val result = BrawlifyGadgetVersion.create(value)

            // THEN
            assertTrue(
                actual = result.isFailure,
                message = "Expected failure for value $value",
            )
            assertFailsWith<IllegalArgumentException> {
                result.getOrThrow()
            }
        }
    }

    @Test
    fun `createOrThrow returns valid version or throws`() {
        // GIVEN
        val valid = 5
        val invalid = 0

        // WHEN
        val version = BrawlifyGadgetVersion.createOrThrow(valid)

        // THEN
        assertEquals(
            expected = valid,
            actual = version.rawInt,
        )

        // WHEN / THEN
        assertFailsWith<IllegalArgumentException> {
            BrawlifyGadgetVersion.createOrThrow(invalid)
        }
    }

    @Test
    fun `createOrNull returns version or null`() {
        // GIVEN
        val valid = 3
        val invalid = 0

        // WHEN
        val versionValid = BrawlifyGadgetVersion.createOrNull(valid)
        val versionInvalid = BrawlifyGadgetVersion.createOrNull(invalid)

        // THEN
        assertNotNull(
            actual = versionValid,
        )
        assertEquals(
            expected = valid,
            actual = versionValid.rawInt,
        )

        assertNull(
            actual = versionInvalid,
        )
    }

    @Test
    fun `isValid returns true for valid values and false for invalid`() {
        // GIVEN
        val valid = listOf(1, 2, 50)
        val invalid = listOf(0, -10)

        // THEN
        valid.forEach { value ->
            assertTrue(
                actual = BrawlifyGadgetVersion.isValid(value),
                message = "Expected $value to be valid",
            )
        }

        invalid.forEach { value ->
            assertFalse(
                actual = BrawlifyGadgetVersion.isValid(value),
                message = "Expected $value to be invalid",
            )
        }
    }

    @Test
    fun `compareTo respects ordering`() {
        // GIVEN
        val v1 = BrawlifyGadgetVersion.createOrThrow(1)
        val v2 = BrawlifyGadgetVersion.createOrThrow(2)
        val v10 = BrawlifyGadgetVersion.createOrThrow(10)

        // THEN
        assertTrue(
            actual = v1 < v2,
        )
        assertTrue(
            actual = v2 < v10,
        )
        assertTrue(
            actual = v10 > v1,
        )
        assertEquals(
            expected = 0,
            actual = v2.compareTo(v2),
        )
    }

    @Test
    fun `createOrThrow and createOrNull behave consistently`() {
        // GIVEN valid and invalid inputs
        val validValue = 7
        val invalidValue = -5

        // WHEN converting valid value
        val throwVersion = BrawlifyGadgetVersion.createOrThrow(validValue)
        val nullVersion = BrawlifyGadgetVersion.createOrNull(validValue)

        // THEN both should produce equivalent instances
        assertNotNull(
            actual = nullVersion,
        )
        assertEquals(
            expected = throwVersion,
            actual = nullVersion,
        )

        // WHEN converting invalid value
        val throwFails = runCatching { BrawlifyGadgetVersion.createOrThrow(invalidValue) }
        val nullFails = BrawlifyGadgetVersion.createOrNull(invalidValue)

        // THEN createOrThrow fails and createOrNull returns null
        assertTrue(
            actual = throwFails.isFailure,
        )
        assertNull(
            actual = nullFails,
        )
    }
}
