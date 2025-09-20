package com.y9vad9.krawl.brawlify.api.v1

import com.y9vad9.krawl.brawlify.api.v1.brawler.RawBrawlifyBrawler
import com.y9vad9.krawl.brawlify.api.v1.event.RawBrawlifyEventsRotation
import com.y9vad9.krawl.brawlify.api.v1.event.RawBrawlifyGameMode
import com.y9vad9.krawl.brawlify.api.v1.event.RawBrawlifyMap
import com.y9vad9.krawl.brawlify.api.v1.icon.RawBrawlifyIcons
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * An http client for interacting with the Brawlify API, providing raw access to various endpoints.
 *
 * This interface facilitates asynchronous retrieval of data related to Brawl Stars, including events, brawlers, maps,
 * game modes, and icons, through the Brawlify API.
 *
 * @see [RawBrawlifyEventsRotation] for event-related data.
 * @see [RawBrawlifyBrawler] for brawler-related data.
 * @see [RawBrawlifyMap] for map-related data.
 * @see [RawBrawlifyGameMode] for game mode-related data.
 * @see [RawBrawlifyIcons] for icon-related data.
 */
public interface RawBrawlifyApiClient {

    public companion object {
        /**
         * Creates a default instance of [RawBrawlifyApiClient].
         *
         * @param engine Ktor's http engine to be used by client.
         * @param json Json instance to be used for serialization.
         */
        public fun create(
            engine: HttpClientEngine,
            json: Json = Json { ignoreUnknownKeys = true }
        ): RawBrawlifyApiClient = DefaultRawBrawlifyApiClient(engine) {
            install(ContentNegotiation) {
                json(json)
            }
        }
    }

    /**
     * Retrieves the current and upcoming event rotations.
     *
     * Events are fetched from the Brawlify API.
     *
     * See [Brawlify Events API](https://brawlapi.com/#/endpoints/events) for details.
     *
     * @return A [Result] containing a [RawBrawlifyEventsRotation] object with active and upcoming events.
     */
    public suspend fun getEvents(): Result<RawBrawlifyEventsRotation>

    /**
     * Retrieves a list of all brawlers.
     *
     * See [Brawlify Brawlers API](https://brawlapi.com/#/endpoints/brawlers) for details.
     *
     * @return A [Result] containing a list of [RawBrawlifyBrawler] objects.
     */
    public suspend fun getBrawlers(): Result<List<RawBrawlifyBrawler>>

    /**
     * Retrieves detailed information about a specific brawler by its ID.
     *
     * See [Brawlify Brawlers API](https://brawlapi.com/#/endpoints/brawlers) for details.
     *
     * @param brawlerId The unique ID of the brawler.
     * @return A [Result] containing a [RawBrawlifyBrawler] object.
     */
    public suspend fun getBrawler(brawlerId: Int): Result<RawBrawlifyBrawler>

    /**
     * Retrieves a list of all maps.
     *
     * See [Brawlify Maps API](https://brawlapi.com/#/endpoints/maps) for details.
     *
     * @return A [Result] containing a list of [RawBrawlifyMap] objects.
     */
    public suspend fun getMaps(): Result<List<RawBrawlifyMap>>

    /**
     * Retrieves detailed information about a specific map by event ID.
     *
     * See [Brawlify Maps API](https://brawlapi.com/#/endpoints/maps) for details.
     *
     * @param id The unique ID of the event associated with the map.
     * @return A [Result] containing a [RawBrawlifyMap] object.
     */
    public suspend fun getMap(id: Int): Result<RawBrawlifyMap>

    /**
     * Retrieves a list of all game modes.
     *
     * See [Brawlify Game Modes API](https://brawlapi.com/#/endpoints/gamemodes) for details.
     *
     * @return A [Result] containing a list of [RawBrawlifyGameMode] objects.
     */
    public suspend fun getGameModes(): Result<List<RawBrawlifyGameMode>>

    /**
     * Retrieves detailed information about a specific game mode by its ID.
     *
     * See [Brawlify Game Modes API](https://brawlapi.com/#/endpoints/gamemodes) for details.
     *
     * @param id The unique ID of the game mode. It can be either [RawBrawlifyGameMode.id] or
     * [RawBrawlifyGameMode.scId]. Prefer `scId` over `id` – `id` can easily be absent.
     * @return A [Result] containing a [RawBrawlifyGameMode] object.
     */
    public suspend fun getGameMode(id: Int): Result<RawBrawlifyGameMode>

    /**
     * Retrieves a list of all available icons (players and clubs).
     *
     * See [Brawlify Icons API](https://brawlapi.com/#/endpoints/icons) for details.
     *
     * @return A [Result] containing a list of [RawBrawlifyIcons] objects.
     */
    public suspend fun getIcons(): Result<RawBrawlifyIcons>
}
