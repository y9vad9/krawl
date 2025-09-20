package com.y9vad9.krawl.brawlify.test.common

import com.y9vad9.krawl.brawlify.Amount
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class CountTest {

    @Test
    fun `isValid returns true for positive numbers`() {
        // GIVEN
        val value = 5

        // WHEN
        val result = Amount.isValid(value)

        // THEN
        assertTrue(result)
    }

    @Test
    fun `isValid returns false for zero or negative numbers`() {
        // GIVEN
        val zero = 0
        val negative = -3

        // WHEN / THEN
        assertFalse(Amount.isValid(zero))
        assertFalse(Amount.isValid(negative))
    }

    @Test
    fun `create returns success for valid positive value`() {
        // GIVEN
        val value = 7

        // WHEN
        val result = Amount.create(value)

        // THEN
        assertTrue(result.isSuccess)
        assertEquals(value, result.getOrThrow().rawInt)
    }

    @Test
    fun `create returns failure for zero or negative value`() {
        // GIVEN
        val zero = 0
        val negative = -4

        // WHEN
        val resultZero = Amount.create(zero)
        val resultNegative = Amount.create(negative)

        // THEN
        assertTrue(resultZero.isFailure)
        assertTrue(resultNegative.isFailure)
    }

    @Test
    fun `createOrThrow returns instance for positive value`() {
        // GIVEN
        val value = 10

        // WHEN
        val count = Amount.createOrThrow(value)

        // THEN
        assertEquals(value, count.rawInt)
    }

    @Test
    fun `createOrThrow throws IllegalArgumentException for zero or negative value`() {
        // GIVEN
        val zero = 0
        val negative = -2

        // THEN
        assertFailsWith<IllegalArgumentException> { Amount.createOrThrow(zero) }
        assertFailsWith<IllegalArgumentException> { Amount.createOrThrow(negative) }
    }

    @Test
    fun `createOrNull returns instance for positive value`() {
        // GIVEN
        val value = 3

        // WHEN
        val count = Amount.createOrNull(value)

        // THEN
        assertEquals(value, count?.rawInt)
    }

    @Test
    fun `createOrNull returns null for zero or negative value`() {
        // GIVEN
        val zero = 0
        val negative = -1

        // WHEN / THEN
        assertNull(Amount.createOrNull(zero))
        assertNull(Amount.createOrNull(negative))
    }

    @Test
    fun `compareTo works correctly`() {
        // GIVEN
        val a = Amount.createOrThrow(5)
        val b = Amount.createOrThrow(10)
        val c = Amount.createOrThrow(5)

        // WHEN / THEN
        assertTrue(a < b)
        assertTrue(b > a)
        assertEquals(0, a.compareTo(c))
    }
}
