import com.y9vad9.brawlifyapi.BrawlifyClient
import com.y9vad9.brawlifyapi.types.events.value.BrawlifyGameModeId
import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.createUnsafe
import io.ktor.client.engine.java.*
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

@OptIn(ValueConstructor.Unsafe::class)
class BrawlifyClientIntegrationTest {

    private val client: BrawlifyClient = BrawlifyClient(
        engine = Java.create(),
    )

    @Test
    fun testGetEvents() = runTest {
        val result = client.getEvents()
        assertTrue(result.isSuccess, "Expected getEvents() to succeed but it failed.")
        val events = result.getOrNull()
        assertNotNull(events, "Expected non-null response from getEvents().")

        println("Active events: ${events.active.size}, Upcoming events: ${events.upcoming.size}")
    }

    @Test
    fun testGetMaps() = runTest {
        val result = client.getMaps()
        assertTrue(result.isSuccess, "Expected getMaps() to succeed but it failed.")
        val maps = result.getOrNull()
        assertNotNull(maps, "Expected non-null response from getMaps().")
    }

    @Test
    fun testGetIcons() = runTest {
        val result = client.getIcons()
        assertTrue(result.isSuccess, "Expected getIcons() to succeed but it failed.")
        val icons = result.getOrNull()
        assertNotNull(icons, "Expected non-null response from getIcons().")
    }

    @Test
    fun testGetGameModes() = runTest {
        val result = client.getGameModes()
        assertTrue(result.isSuccess, "Expected getGameModes() to succeed but it failed.")
        val gameModes = result.getOrNull()
        assertNotNull(gameModes, "Expected non-null response from getGameModes().")
    }

    @Test
    fun testGetGameModeById() = runTest {
        // Replace `validGameModeId` with an actual ID to test.
        val validGameModeId = BrawlifyGameModeId.createUnsafe(15)
        val result = client.getGameMode(validGameModeId)
        assertTrue(result.isSuccess, "Expected getGameMode() to succeed but it failed.")
    }
}
