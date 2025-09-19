package com.y9vad9.krawl.brawlify.test.common

import com.y9vad9.krawl.brawlify.BrawlifyHtmlDescription
import kotlin.test.Test
import kotlin.test.assertEquals

class BrawlifyHtmlDescriptionTest {

    @Test
    fun `fromPlainText escapes special HTML characters`() {
        // GIVEN
        val input = """Hello & welcome <user> "test" 'quote'"""
        val expected = "Hello &amp; welcome &lt;user&gt; &quot;test&quot; &#39;quote&#39;"

        // WHEN
        val result = BrawlifyHtmlDescription.fromPlainText(input)

        // THEN
        assertEquals(expected, result.rawString)
    }

    @Test
    fun `fromPlainText does not alter normal characters`() {
        // GIVEN
        val input = "Just some normal text 123 !@#"
        val expected = input

        // WHEN
        val result = BrawlifyHtmlDescription.fromPlainText(input)

        // THEN
        assertEquals(expected, result.rawString)
    }

    @Test
    fun `fromPlainText escapes multiple occurrences correctly`() {
        // GIVEN
        val input = "<<&&>>\"\"''"
        val expected = "&lt;&lt;&amp;&amp;&gt;&gt;&quot;&quot;&#39;&#39;"

        // WHEN
        val result = BrawlifyHtmlDescription.fromPlainText(input)

        // THEN
        assertEquals(expected, result.rawString)
    }

    @Test
    fun `fromPlainText returns empty string unchanged`() {
        // GIVEN
        val input = ""
        val expected = ""

        // WHEN
        val result = BrawlifyHtmlDescription.fromPlainText(input)

        // THEN
        assertEquals(expected, result.rawString)
    }
}