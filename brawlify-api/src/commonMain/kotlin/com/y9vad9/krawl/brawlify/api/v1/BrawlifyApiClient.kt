package com.y9vad9.krawl.brawlify.api.v1

import com.y9vad9.krawl.brawlify.api.v1.brawler.BrawlifyBrawler
import com.y9vad9.krawl.brawlify.api.v1.event.BrawlifyEventRotation
import com.y9vad9.krawl.brawlify.api.v1.event.BrawlifyGameMode
import com.y9vad9.krawl.brawlify.api.v1.event.BrawlifyMap
import com.y9vad9.krawl.brawlify.api.v1.icon.BrawlifyIcons
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * An http client for interacting with the Brawlify API, providing type-safe access to various game data endpoints.
 *
 * This interface facilitates asynchronous retrieval of data related to Brawl Stars, including events, brawlers, maps,
 * game modes, and icons, through the Brawlify API.
 *
 * @see [BrawlifyEventRotation] for event-related data.
 * @see [BrawlifyBrawler] for brawler-related data.
 * @see [BrawlifyMap] for map-related data.
 * @see [BrawlifyGameMode] for game mode-related data.
 * @see [BrawlifyIcons] for icon-related data.
 */
public interface BrawlifyApiClient {

    public companion object {
        /**
         * Creates a default instance of [BrawlifyApiClient].
         *
         * @param engine Ktor's http engine to be used by client.
         * @param json Json instance to be used for serialization.
         */
        public fun create(
            engine: HttpClientEngine,
            json: Json = Json { ignoreUnknownKeys = true }
        ): BrawlifyApiClient = DefaultBrawlifyApiClient(engine) {
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
     * @return A [Result] containing a [BrawlifyEventRotation] object with active and upcoming events.
     */
    public suspend fun getEvents(): Result<BrawlifyEventRotation>

    /**
     * Retrieves a list of all brawlers.
     *
     * See [Brawlify Brawlers API](https://brawlapi.com/#/endpoints/brawlers) for details.
     *
     * @return A [Result] containing a list of [BrawlifyBrawler] objects.
     */
    public suspend fun getBrawlers(): Result<List<BrawlifyBrawler>>

    /**
     * Retrieves detailed information about a specific brawler by its ID.
     *
     * See [Brawlify Brawlers API](https://brawlapi.com/#/endpoints/brawlers) for details.
     *
     * @param brawlerId The unique ID of the brawler.
     * @return A [Result] containing a [BrawlifyBrawler] object.
     */
    public suspend fun getBrawler(brawlerId: Int): Result<BrawlifyBrawler>

    /**
     * Retrieves a list of all maps.
     *
     * See [Brawlify Maps API](https://brawlapi.com/#/endpoints/maps) for details.
     *
     * @return A [Result] containing a list of [BrawlifyMap] objects.
     */
    public suspend fun getMaps(): Result<List<BrawlifyMap>>

    /**
     * Retrieves detailed information about a specific map by event ID.
     *
     * See [Brawlify Maps API](https://brawlapi.com/#/endpoints/maps) for details.
     *
     * @param id The unique ID of the event associated with the map.
     * @return A [Result] containing a [BrawlifyMap] object.
     */
    public suspend fun getMap(id: Int): Result<BrawlifyMap>

    /**
     * Retrieves a list of all game modes.
     *
     * See [Brawlify Game Modes API](https://brawlapi.com/#/endpoints/gamemodes) for details.
     *
     * @return A [Result] containing a list of [BrawlifyGameMode] objects.
     */
    public suspend fun getGameModes(): Result<List<BrawlifyGameMode>>

    /**
     * Retrieves detailed information about a specific game mode by its ID.
     *
     * See [Brawlify Game Modes API](https://brawlapi.com/#/endpoints/gamemodes) for details.
     *
     * @param id The unique ID of the game mode. It can be either [BrawlifyGameMode.id] or [BrawlifyGameMode.scId].
     *           Prefer `scId` over `id` – `id` can easily be absent.
     * @return A [Result] containing a [BrawlifyGameMode] object.
     */
    public suspend fun getGameMode(id: Int): Result<BrawlifyGameMode>

    /**
     * Retrieves a list of all available icons (players and clubs).
     *
     * See [Brawlify Icons API](https://brawlapi.com/#/endpoints/icons) for details.
     *
     * @return A [Result] containing a list of [BrawlifyIcons] objects.
     */
    public suspend fun getIcons(): Result<BrawlifyIcons>
}
