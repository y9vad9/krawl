package com.y9vad9.krawl.brawlify.api.v1

import com.y9vad9.krawl.brawlify.api.v1.brawler.RawBrawlifyBrawler
import com.y9vad9.krawl.brawlify.api.v1.event.RawBrawlifyEventsRotation
import com.y9vad9.krawl.brawlify.api.v1.event.RawBrawlifyGameMode
import com.y9vad9.krawl.brawlify.api.v1.event.RawBrawlifyMap
import com.y9vad9.krawl.brawlify.api.v1.icon.RawBrawlifyIcons
import com.y9vad9.krawl.brawlify.api.v1.internal.ItemsResponse
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders

/**
 * Default implementation of [RawBrawlifyApiClient] using Ktor [HttpClient].
 *
 * @property engine The Ktor [HttpClientEngine] to use for requests.
 * @property baseUrl The base URL for Brawlify API requests. Defaults to "https://api.brawlify.com/v1".
 * @param configBlock Configuration builder for the http client. Make sure that you install json for
 *                    content negotiation if it's not created through [BrawlifyApiClient.create].
 */
public class DefaultRawBrawlifyApiClient(
    public val engine: HttpClientEngine,
    public val baseUrl: String = "https://api.brawlify.com/",
    configBlock: HttpClientConfig<*>.() -> Unit,
) : RawBrawlifyApiClient {

    private val client = HttpClient(engine) {
        defaultRequest {
            url(baseUrl)
            header(HttpHeaders.Accept, ContentType.Application.Json)
        }

        configBlock()
    }

    override suspend fun getEvents(): Result<RawBrawlifyEventsRotation> = runCatching {
        client.get("v1/events").body()
    }

    override suspend fun getBrawlers(): Result<List<RawBrawlifyBrawler>> = runCatching {
        val response: ItemsResponse<RawBrawlifyBrawler> = client.get("v1/brawlers").body()
        response.items
    }

    override suspend fun getBrawler(brawlerId: Int): Result<RawBrawlifyBrawler> = runCatching {
        client.get("v1/brawlers/$brawlerId").body()
    }

    override suspend fun getMaps(): Result<List<RawBrawlifyMap>> = runCatching {
        val response: ItemsResponse<RawBrawlifyMap> = client.get("v1/maps").body()
        response.items
    }

    override suspend fun getMap(id: Int): Result<RawBrawlifyMap> = runCatching {
        client.get("v1/maps/$id").body()
    }

    override suspend fun getGameModes(): Result<List<RawBrawlifyGameMode>> = runCatching {
        val response: ItemsResponse<RawBrawlifyGameMode> = client.get("v1/gamemodes").body()
        response.items
    }

    override suspend fun getGameMode(id: Int): Result<RawBrawlifyGameMode> = runCatching {
        client.get("v1/gamemodes/$id").body()
    }

    override suspend fun getIcons(): Result<RawBrawlifyIcons> = runCatching {
        client.get("v1/icons").body<RawBrawlifyIcons>()
    }
}
