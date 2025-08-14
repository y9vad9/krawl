package com.y9vad9.krawl.integrationTest.brawler

import com.y9vad9.krawl.brawler.BrawlerId
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlin.reflect.full.memberProperties
import kotlin.reflect.typeOf
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.int
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import org.junit.jupiter.api.assertDoesNotThrow

class BrawlerIdTest {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

    private suspend fun fetchRawBrawlers(): List<Pair<Int, JsonObject>> {
        // GIVEN: A Brawlify API endpoint returning brawler JSON objects
        val response = client.get("https://api.brawlify.com/v1/brawlers").body<JsonObject>()

        // WHEN: Extract the "list" of brawlers and map to pairs of (id, jsonObject)
        return response["list"]!!
            .jsonArray
            .map { element -> element.jsonObject["id"]!!.jsonPrimitive.int to element.jsonObject }
    }

    private val definedBrawlers: Map<BrawlerId, String> by lazy {
        // GIVEN: Companion properties of BrawlerId representing all defined IDs
        BrawlerId.Companion::class.memberProperties
            .filter { it.returnType == typeOf<BrawlerId>() }
            .associate { it.call(BrawlerId.Companion) as BrawlerId to it.name }
    }

    @Test
    fun `fetch brawlers from API successfully`() = runTest {
        // WHEN
        val rawBrawlers = fetchRawBrawlers()

        // THEN
        assert(rawBrawlers.isNotEmpty()) { "API returned no brawlers" }
    }

    @Test
    fun `all API brawler IDs map to BrawlerId instances`() = runTest {
        // GIVEN
        val rawBrawlers = fetchRawBrawlers()

        // THEN
        rawBrawlers.forEach { (id, _) ->
            assertDoesNotThrow("Brawler id '$id' returned by Brawlify cannot be mapped to BrawlerId.") {
                BrawlerId.createOrThrow(id)
            }
        }
    }

    @Test
    fun `all API brawler IDs are defined in BrawlerId companion with correct names`() = runTest {
        // GIVEN
        val rawBrawlers = fetchRawBrawlers()

        // THEN
        rawBrawlers.forEach { (id, jsonObject) ->
            val name = jsonObject["name"]!!.jsonPrimitive.content
            val detailsUrl = jsonObject["link"]!!.jsonPrimitive.content
            val expectedDefinedName = name.normalizeBrawlerName()
            val brawlerId = BrawlerId.createOrThrow(id)

            assert(
                value = definedBrawlers.contains(brawlerId),
                lazyMessage = {
                    buildString {
                        append("Brawler returned from Brawlify API is not yet defined in the `BrawlerId` ")
                        appendLine("companion, but should. There are multiple reasons why it can occur:")
                        appendLine("• Brawler is defined, but wrapped id is invalid.")
                        appendLine("• Brawler is not defined at all.")
                        appendLine()
                        appendLine("In case it's absent, insert the following code inside a `BrawlerId.Companion`:")
                        appendLine(
                            """
                /**
                 * Constant for Brawler ID representing $name.
                 * **[Learn more about Brawler on Brawlify]($detailsUrl)**
                 */
                public val $expectedDefinedName: BrawlerId = BrawlerId($id)
                """.trimIndent()
                        )
                        appendLine()
                        append("And you are good to go!")
                    }
                }
            )

            val definedName = definedBrawlers[brawlerId]!!
            assertEquals(
                expected = expectedDefinedName,
                actual = definedName,
                message = "Expected property name to be '$expectedDefinedName', but was '$definedName'." +
                    " Is the name right?",
            )
        }
    }

    private fun String.normalizeBrawlerName(): String {
        // Step 1: Replace & with a placeholder to remember positions
        val placeholder = "<<<AND>>>"
        var temp = this.replace("&", placeholder)

        // Step 2: Replace dashes (Unicode dash punctuation) and whitespace with underscore
        temp = temp.replace(Regex("[\\p{Pd}\\s\\.]+"), "_")

        // Step 3: Replace placeholders with either '_and_' or 'and' based on surroundings
        // We'll scan for placeholder occurrences and check chars around them

        val builder = StringBuilder()
        var i = 0
        while (i < temp.length) {
            if (temp.startsWith(placeholder, i)) {
                // Check chars before and after placeholder
                val before = if (i > 0) temp[i - 1] else null
                val after = if (i + placeholder.length < temp.length) temp[i + placeholder.length] else null

                val surroundedByUnderscores = before == '_' && after == '_'

                if (surroundedByUnderscores) {
                    builder.append("and") // just insert 'and' without extra underscores
                } else {
                    // insert with underscores, avoid double underscores if boundary chars are underscores
                    if (before != '_') builder.append('_')
                    builder.append("and")
                    if (after != '_') builder.append('_')
                }

                i += placeholder.length
            } else {
                builder.append(temp[i])
                i++
            }
        }

        // Step 4: Collapse multiple underscores and trim edges
        val result = builder.toString()
            .replace(Regex("_+"), "_")
            .trim('_')

        return result.replaceDigitsWithWords().uppercase()
    }

    private fun String.replaceDigitsWithWords(): String {
        val digitMap = mapOf(
            '0' to "ZERO",
            '1' to "ONE",
            '2' to "TWO",
            '3' to "THREE",
            '4' to "FOUR",
            '5' to "FIVE",
            '6' to "SIX",
            '7' to "SEVEN",
            '8' to "EIGHT",
            '9' to "NINE"
        )
        return map { c ->
            digitMap[c] ?: c.toString()
        }.joinToString("")
    }
}
