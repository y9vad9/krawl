package com.y9vad9.krawl.brawlify

import com.y9vad9.krawl.brawler.BrawlerId
import com.y9vad9.krawl.brawlify.api.v1.RawBrawlifyApiClient
import com.y9vad9.krawl.brawlify.api.v1.icon.RawBrawlifyIcons
import com.y9vad9.krawl.brawlify.brawler.BrawlifyBrawler
import com.y9vad9.krawl.brawlify.brawler.toTypedOrThrow
import com.y9vad9.krawl.brawlify.event.BrawlifyEventsRotation
import com.y9vad9.krawl.brawlify.event.gamemode.BrawlifyGameMode
import com.y9vad9.krawl.brawlify.event.gamemode.BrawlifyGameModeId
import com.y9vad9.krawl.brawlify.event.gamemode.toTypedOrThrow
import com.y9vad9.krawl.brawlify.event.map.BrawlifyMap
import com.y9vad9.krawl.brawlify.event.map.toTypedOrThrow
import com.y9vad9.krawl.brawlify.event.toTypedOrThrow
import com.y9vad9.krawl.brawlify.icon.BrawlifyIcons
import com.y9vad9.krawl.brawlify.icon.toTypedOrThrow
import com.y9vad9.krawl.event.EventId
import io.ktor.client.engine.HttpClientEngine
import kotlinx.serialization.json.Json

/**
 * An http client for interacting with the Brawlify API, providing type-safe access to various game data endpoints.
 *
 * This interface facilitates asynchronous retrieval of data related to Brawl Stars, including events, brawlers, maps,
 * game modes, and icons, through the Brawlify API.
 *
 * @see [BrawlifyEventsRotation] for event-related data.
 * @see [BrawlifyBrawler] for brawler-related data.
 * @see [BrawlifyMap] for map-related data.
 * @see [BrawlifyGameMode] for game mode-related data.
 * @see [BrawlifyIcons] for icon-related data.
 */
public interface BrawlifyApiClient {

    public companion object {
        /**
         * Creates a new [BrawlifyApiClient] backed by an internally constructed [RawBrawlifyApiClient].
         *
         * This overload allows you to provide an [HttpClientEngine] and optionally a [Json] instance
         * to configure how requests and responses are handled.
         *
         * - The [engine] defines the HTTP transport (e.g., CIO, OkHttp).
         * - The [json] instance (defaulting to `Json { ignoreUnknownKeys = true }`) controls
         *   JSON serialization and deserialization behavior.
         *
         * @param engine the [HttpClientEngine] to use for network requests.
         * @param json the [Json] configuration to use for encoding/decoding payloads.
         * @return a new [BrawlifyApiClient] instance with the provided configuration.
         */
        public fun create(
            engine: HttpClientEngine,
            json: Json = Json { ignoreUnknownKeys = true },
        ): BrawlifyApiClient = BrawlifyApiClientImpl(RawBrawlifyApiClient.create(engine, json))

        /**
         * Creates a new [BrawlifyApiClient] that wraps an existing [RawBrawlifyApiClient].
         *
         * This overload is useful if you need direct control over the construction or customization
         * of the underlying [RawBrawlifyApiClient], for example when injecting it for testing.
         *
         * @param rawClient an existing [RawBrawlifyApiClient] to wrap.
         * @return a new [BrawlifyApiClient] instance backed by the given [rawClient].
         */
        public fun create(
            rawClient: RawBrawlifyApiClient,
        ): BrawlifyApiClient = BrawlifyApiClientImpl(rawClient)
    }

    /**
     * Retrieves the current and upcoming event rotations.
     *
     * Events are fetched from the Brawlify API.
     *
     * See [Brawlify Events API](https://brawlapi.com/#/endpoints/events) for details.
     *
     * @return A [Result] containing a [BrawlifyEventsRotation] object with active and upcoming events.
     */
    public suspend fun getEvents(): Result<BrawlifyEventsRotation>

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
    public suspend fun getBrawler(brawlerId: BrawlerId): Result<BrawlifyBrawler>

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
    public suspend fun getMap(id: EventId): Result<BrawlifyMap>

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
     * @param id The unique ID of the game mode. It can be either [BrawlifyGameMode.id].
     *           Prefer `scId` over `id` – `id` can easily be absent.
     * @return A [Result] containing a [BrawlifyGameMode] object.
     */
    public suspend fun getGameMode(id: BrawlifyGameModeId): Result<BrawlifyGameMode>

    /**
     * Retrieves a list of all available icons (players and clubs).
     *
     * See [Brawlify Icons API](https://brawlapi.com/#/endpoints/icons) for details.
     *
     * @return A [Result] containing a list of [RawBrawlifyIcons] objects.
     */
    public suspend fun getIcons(): Result<BrawlifyIcons>
}

private class BrawlifyApiClientImpl(
    private val rawClient: RawBrawlifyApiClient,
) : BrawlifyApiClient {
    override suspend fun getEvents(): Result<BrawlifyEventsRotation> =
        rawClient.getEvents().mapCatching { it.toTypedOrThrow() }

    override suspend fun getBrawlers(): Result<List<BrawlifyBrawler>> {
        return rawClient.getBrawlers().mapCatching { list ->
            list.map { it.toTypedOrThrow() }
        }
    }

    override suspend fun getBrawler(brawlerId: BrawlerId): Result<BrawlifyBrawler> =
        rawClient.getBrawler(brawlerId.rawInt).mapCatching { it.toTypedOrThrow() }

    override suspend fun getMaps(): Result<List<BrawlifyMap>> {
        return rawClient.getMaps().mapCatching { list ->
            list.map { it.toTypedOrThrow() }
        }
    }

    override suspend fun getMap(id: EventId): Result<BrawlifyMap> =
        rawClient.getMap(id.rawInt).mapCatching { it.toTypedOrThrow() }

    override suspend fun getGameModes(): Result<List<BrawlifyGameMode>> {
        return rawClient.getGameModes().mapCatching { list ->
            list.map { it.toTypedOrThrow() }
        }
    }

    override suspend fun getGameMode(id: BrawlifyGameModeId): Result<BrawlifyGameMode> {
        return rawClient.getGameMode(id.rawInt).mapCatching {
            it.toTypedOrThrow()
        }
    }

    override suspend fun getIcons(): Result<BrawlifyIcons> =
        rawClient.getIcons().mapCatching { it.toTypedOrThrow() }
}
