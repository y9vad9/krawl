package com.y9vad9.brawlifyapi

import com.y9vad9.brawlifyapi.types.events.BrawlifyEvent
import com.y9vad9.brawlifyapi.types.events.BrawlifyFullGameMode
import com.y9vad9.brawlifyapi.types.events.value.BrawlifyGameModeId
import com.y9vad9.brawlifyapi.types.icons.BrawlifyClubIcon
import com.y9vad9.brawlifyapi.types.icons.BrawlifyPlayerIcon
import com.y9vad9.brawlifyapi.types.maps.BrawlifyMap
import com.y9vad9.bsapi.types.event.value.EventId
import com.y9vad9.bsapi.types.event.value.isPublic
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

public class BrawlifyClient(
    engine: HttpClientEngine,
    json: Json = Json { ignoreUnknownKeys = true },
    configBlock: HttpClientConfig<*>.() -> Unit = {},
) {
    private val client: HttpClient = HttpClient(engine) {
        defaultRequest {
            url("https://api.brawlify.com/v1/")
            accept(ContentType.Application.Json)
        }

        install(ContentNegotiation) {
            json(json)
        }

        configBlock()
    }

    /**
     * Gets available on Brawlify information about current and upcoming events.
     *
     * [API Documentation](https://brawlapi.com/#/endpoints/events)
     */
    public suspend fun getEvents(): Result<GetEventsResponse> = runCatching {
        client.get("events").body<GetEventsResponse>()
    }

    /**
     * Gets available on Brawlify information about maps.
     *
     * [API Documentation](https://brawlapi.com/#/endpoints/maps)
     */
    public suspend fun getMaps(): Result<List<BrawlifyMap>> = runCatching {
        client.get("maps").body<GetMapsResponse>().list
    }

    /**
     * Gets map by [eventId] from Brawl Stars API (or from Brawlify's [getEvents]).
     *
     * @param eventId Event's id within Brawl Stars system.
     *
     * [API Documentation](https://brawlapi.com/#/endpoints/maps)
     */
    public suspend fun getMap(eventId: EventId): Result<BrawlifyMap?> = runCatching {
        // fast-way: no way to get the event, it's most likely to be
        // map-maker
        if (!eventId.isPublic) return@runCatching null

        val result = client.get("maps/${eventId.raw}")

        when (result.status) {
            HttpStatusCode.NotFound -> null
            else -> result.body()
        }
    }

    /**
     * Gets available on Brawlify icons for players / clubs.
     *
     * [API Documentation](https://brawlapi.com/#/endpoints/icons)
     */
    public suspend fun getIcons(): Result<GetIconsResponse> = runCatching {
        client.get("icons").body<GetIconsResponse>()
    }

    /**
     * Gets available on Brawlify game modes list with all information.
     *
     * [API Documentation](https://brawlapi.com/#/endpoints/gamemodes)
     */
    public suspend fun getGameModes(): Result<List<BrawlifyFullGameMode>> = runCatching {
        client.get("gamemodes").body<GetGameModesResponse>().list
    }

    /**
     * Gets game mode on Brawlify if available or null.
     *
     * @param id Brawlify specific id linked to the game mode. Can be
     * retrieved in [getEvents] or [getMaps].
     *
     * [API Documentation](https://brawlapi.com/#/endpoints/gamemodes)
     */
    public suspend fun getGameMode(id: BrawlifyGameModeId): Result<BrawlifyFullGameMode?> = runCatching {
        val result = client.get("gamemodes/${id.raw}")

        when (result.status) {
            HttpStatusCode.NotFound -> null
            else -> result.body<BrawlifyFullGameMode>()
        }
    }

    @Serializable
    public data class GetEventsResponse(
        val active: List<BrawlifyEvent>,
        val upcoming: List<BrawlifyEvent>,
    )

    @Serializable
    private data class GetMapsResponse(
        val list: List<BrawlifyMap>,
    )

    @Serializable
    private data class GetGameModesResponse(
        val list: List<BrawlifyFullGameMode>,
    )

    @Serializable
    public data class GetIconsResponse(
        private val player: Map<String, BrawlifyPlayerIcon>,
        private val club: Map<String, BrawlifyClubIcon>,
    ) {
        public val playersIcons: List<BrawlifyPlayerIcon> by lazy { player.map { it.value } }
        public val clubsIcons: List<BrawlifyClubIcon> by lazy { club.map { it.value } }
    }
}