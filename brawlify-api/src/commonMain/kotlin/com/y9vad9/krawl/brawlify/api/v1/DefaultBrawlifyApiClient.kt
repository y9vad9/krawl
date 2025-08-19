package com.y9vad9.krawl.brawlify.api.v1

import com.y9vad9.krawl.brawlify.api.v1.brawler.BrawlifyBrawler
import com.y9vad9.krawl.brawlify.api.v1.event.BrawlifyEventRotation
import com.y9vad9.krawl.brawlify.api.v1.event.BrawlifyGameMode
import com.y9vad9.krawl.brawlify.api.v1.event.BrawlifyMap
import com.y9vad9.krawl.brawlify.api.v1.icon.BrawlifyIcons
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
 * Default implementation of [BrawlifyApiClient] using Ktor [HttpClient].
 *
 * @property engine The Ktor [HttpClientEngine] to use for requests.
 * @property baseUrl The base URL for Brawlify API requests. Defaults to "https://api.brawlify.com/v1".
 * @param configBlock Configuration builder for the http client. Make sure that you install json for
 *                    content negotiation if it's not created through [BrawlifyApiClient.create].
 */
public class DefaultBrawlifyApiClient(
    public val engine: HttpClientEngine,
    public val baseUrl: String = "https://api.brawlify.com/",
    configBlock: HttpClientConfig<*>.() -> Unit,
) : BrawlifyApiClient {

    private val client = HttpClient(engine) {
        defaultRequest {
            url(baseUrl)
            header(HttpHeaders.Accept, ContentType.Application.Json)
        }

        configBlock()
    }

    override suspend fun getEvents(): Result<BrawlifyEventRotation> = runCatching {
        client.get("v1/events").body()
    }

    override suspend fun getBrawlers(): Result<List<BrawlifyBrawler>> = runCatching {
        val response: ItemsResponse<BrawlifyBrawler> = client.get("v1/brawlers").body()
        response.items
    }

    override suspend fun getBrawler(brawlerId: Int): Result<BrawlifyBrawler> = runCatching {
        client.get("v1/brawlers/$brawlerId").body()
    }

    override suspend fun getMaps(): Result<List<BrawlifyMap>> = runCatching {
        val response: ItemsResponse<BrawlifyMap> = client.get("v1/maps").body()
        response.items
    }

    override suspend fun getMap(id: Int): Result<BrawlifyMap> = runCatching {
        client.get("v1/maps/$id").body()
    }

    override suspend fun getGameModes(): Result<List<BrawlifyGameMode>> = runCatching {
        val response: ItemsResponse<BrawlifyGameMode> = client.get("v1/gamemodes").body()
        response.items
    }

    override suspend fun getGameMode(id: Int): Result<BrawlifyGameMode> = runCatching {
        client.get("v1/gamemodes/$id").body()
    }

    override suspend fun getIcons(): Result<BrawlifyIcons> = runCatching {
        client.get("v1/icons").body<BrawlifyIcons>()
    }
}
