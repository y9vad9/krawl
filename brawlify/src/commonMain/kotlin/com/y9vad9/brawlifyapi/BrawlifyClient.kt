package com.y9vad9.brawlifyapi

import com.y9vad9.brawlifyapi.types.events.BrawlifyEvent
import com.y9vad9.brawlifyapi.types.maps.BrawlifyMap
import com.y9vad9.bsapi.types.event.value.EventId
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

    public suspend fun getEvents(): Result<GetEventsResponse> = runCatching {
        client.get("events").body()
    }

    public suspend fun getMaps(): Result<GetMapsResponse> = runCatching {
        client.get("maps").body()
    }

    public suspend fun getMap(eventId: EventId): Result<GetMapsResponse> = runCatching {
        client.get("maps/${eventId.raw}").body()
    }

    @Serializable
    public data class GetEventsResponse(
        val active: List<BrawlifyEvent>,
        val upcoming: List<BrawlifyEvent>,
    )

    @Serializable
    public data class GetMapsResponse(
        val list: List<BrawlifyMap>,
    )
}