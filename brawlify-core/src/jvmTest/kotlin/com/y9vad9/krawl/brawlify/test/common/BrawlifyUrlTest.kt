package com.y9vad9.krawl.brawlify.test.common

import com.y9vad9.krawl.brawlify.BrawlifyUrl
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class BrawlifyUrlTest {

    @Test
    fun `isValid returns true for regular brawlify URL`() {
        // GIVEN
        val url = "https://brawlify.com/brawlers"

        // WHEN
        val result = BrawlifyUrl.isValid(url)

        // THEN
        assertTrue(result)
    }

    @Test
    fun `isValid returns true for cdn brawlify URL`() {
        // GIVEN
        val url = "https://cdn.brawlify.com/star-powers/123.png"

        // WHEN
        val result = BrawlifyUrl.isValid(url)

        // THEN
        assertTrue(result)
    }

    @Test
    fun `isValid returns false for invalid URL`() {
        // GIVEN
        val url = "https://example.com/invalid"

        // WHEN
        val result = BrawlifyUrl.isValid(url)

        // THEN
        assertFalse(result)
    }

    @Test
    fun `create returns success for valid URL`() {
        // GIVEN
        val url = "https://brawlify.com/brawlers"

        // WHEN
        val result = BrawlifyUrl.create(url)

        // THEN
        assertTrue(result.isSuccess)
        assertEquals(url, result.getOrThrow().rawString)
    }

    @Test
    fun `create returns failure for invalid URL`() {
        // GIVEN
        val url = "https://notbrawlify.com/page"

        // WHEN
        val result = BrawlifyUrl.create(url)

        // THEN
        assertTrue(result.isFailure)
    }

    @Test
    fun `createOrNull returns instance for valid URL`() {
        // GIVEN
        val url = "https://cdn.brawlify.com/images/img.png"

        // WHEN
        val result = BrawlifyUrl.createOrNull(url)

        // THEN
        assertEquals(url, result?.rawString)
    }

    @Test
    fun `createOrNull returns null for invalid URL`() {
        // GIVEN
        val url = "ftp://brawlify.com/file"

        // WHEN
        val result = BrawlifyUrl.createOrNull(url)

        // THEN
        assertNull(result)
    }

    @Test
    fun `createOrThrow returns instance for valid URL`() {
        // GIVEN
        val url = "https://brawlify.com/gadgets"

        // WHEN
        val result = BrawlifyUrl.createOrThrow(url)

        // THEN
        assertEquals(url, result.rawString)
    }

    @Test
    fun `createOrThrow throws IllegalArgumentException for invalid URL`() {
        // GIVEN
        val url = "http://brawlify.com/gadgets"

        // THEN
        assertFailsWith<IllegalArgumentException> {
            BrawlifyUrl.createOrThrow(url)
        }
    }
}