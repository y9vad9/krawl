@file:Suppress("detekt.StringLiteralDuplication")
package com.y9vad9.krawl.api.v1

import com.y9vad9.krawl.api.v1.battle.BattleRecord
import com.y9vad9.krawl.api.v1.club.Club
import com.y9vad9.krawl.api.v1.club.ClubMember
import com.y9vad9.krawl.api.v1.event.ScheduledEvent
import com.y9vad9.krawl.api.v1.pagination.PaginatedList
import com.y9vad9.krawl.api.v1.player.Player
import com.y9vad9.krawl.api.v1.ranking.ClubRanking
import com.y9vad9.krawl.api.v1.ranking.PlayerRanking
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.accept
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.isSuccess
import io.ktor.http.parameters
import io.ktor.http.path
import kotlinx.io.IOException

/**
 * Default implementation of [BrawlStarsApiClient] using Ktor's [HttpClient] to interact
 * with the official Brawl Stars API.
 *
 * This client:
 * - Configures a base URL and default JSON content negotiation.
 * - Attaches a Bearer token for authentication to every request.
 * - Automatically maps HTTP errors to specific [BrawlStarsApiException] subclasses.
 * - Provides convenience methods for retrieving players, clubs, battles, rankings, and events.
 *
 * @param engine The [HttpClientEngine] to be used for network communication.
 * @param bearerToken The Bearer token used for authenticating requests to the Brawl Stars API.
 * @param baseUrl The base URL for the Brawl Stars API (defaults to `https://api.brawlstars.com/v1/`).
 * @param configBlock Additional [HttpClientConfig] customization applied after default configuration.
 */
public class DefaultBrawlStarsApiClient(
    engine: HttpClientEngine,
    bearerToken: String,
    baseUrl: String = "https://api.brawlstars.com/v1/",
    configBlock: HttpClientConfig<*>.() -> Unit,
) : BrawlStarsApiClient {
    private val client: HttpClient = HttpClient(engine) {
        defaultRequest {
            url(baseUrl)
            accept(ContentType.Application.Json)

            bearerAuth(bearerToken)
        }

        configBlock()
    }


    /**
     * Retrieves a [Player] by their tag.
     *
     * @param tag The player's unique tag (with the leading '#').
     * @return A [Result] containing the player if found, `null` if not found, or a failure if the request failed.
     */
    override suspend fun getPlayer(tag: String): Result<Player?> =
        getRequest("players", tag)

    /**
     * Retrieves the battle log for a specific player.
     *
     * The battle log contains recent battles the player participated in.
     *
     * @param tag The player's unique tag (with the leading '#').
     * @return A [Result] containing the list of [BattleRecord] entries, or `null` if no battles are found.
     */
    override suspend fun getPlayerBattleLog(tag: String): Result<List<BattleRecord>?> =
        getRequest<PaginatedList<BattleRecord>?>("players", tag, "battlelog")

    /**
     * Retrieves a [Club] by its tag.
     *
     * @param tag The club's unique tag (with the leading '#').
     * @return A [Result] containing the club if found, `null` if not found, or a failure if the request failed.
     */
    override suspend fun getClub(tag: String): Result<Club?> =
        getRequest("clubs", tag)

    /**
     * Retrieves the list of members for a given club.
     *
     * @param tag The club's unique tag (with the leading '#').
     * @return A [Result] containing the list of [ClubMember] entries, or a failure if the request failed.
     */
    override suspend fun getClubMembers(tag: String): Result<List<ClubMember>?> =
        getRequest<PaginatedList<ClubMember>>("clubs", tag, "members")

    /**
     * Retrieves player rankings for a specific brawler.
     *
     * Supports pagination via the `after` and `before` cursors.
     *
     * @param brawlerId The brawler's ID.
     * @param countryCode The country code for rankings (default is [BrawlStarsApiClient.DEFAULT_COUNTRY_CODE]).
     * @param after Cursor for results after a given item.
     * @param before Cursor for results before a given item.
     * @param limit Maximum number of results to return.
     * @return A [Result] containing a [PaginatedList] of [PlayerRanking].
     */
    override suspend fun getBrawlerRanking(
        brawlerId: Int,
        countryCode: String,
        after: String?,
        before: String?,
        limit: Int?
    ): Result<PaginatedList<PlayerRanking>> = getRequest<PaginatedList<PlayerRanking>>(
        "rankings", countryCode, "brawlers", brawlerId.toString(),
    ) {
        parameters {
            if (after != null) append("after", after)
            if (before != null) append("before", before)
            if (limit != null) append("limit", limit.toString())
        }
    }.mapCatching { it ?: error("`getBrawlerRanking` returned unexpected null") }

    /**
     * Retrieves overall player rankings.
     *
     * Supports pagination via the `after` and `before` cursors.
     *
     * @param countryCode The country code for rankings.
     * @param after Cursor for results after a given item.
     * @param before Cursor for results before a given item.
     * @param limit Maximum number of results to return.
     * @return A [Result] containing a [PaginatedList] of [PlayerRanking].
     */
    override suspend fun getPlayerRanking(
        countryCode: String,
        after: String?,
        before: String?,
        limit: Int?
    ): Result<PaginatedList<PlayerRanking>> = getRequest<PaginatedList<PlayerRanking>>(
        "rankings", countryCode, "players"
    ) {
        parameters {
            if (after != null) append("after", after)
            if (before != null) append("before", before)
            if (limit != null) append("limit", limit.toString())
        }
    }.mapCatching { it ?: error("`getPlayerRanking` returned unexpected null") }

    /**
     * Retrieves club rankings.
     *
     * Supports pagination via the `after` and `before` cursors.
     *
     * @param countryCode The country code for rankings.
     * @param after Cursor for results after a given item.
     * @param before Cursor for results before a given item.
     * @param limit Maximum number of results to return.
     * @return A [Result] containing a [PaginatedList] of [ClubRanking].
     */
    override suspend fun getClubRanking(
        countryCode: String,
        after: String?,
        before: String?,
        limit: Int?
    ): Result<PaginatedList<ClubRanking>> = getRequest<PaginatedList<ClubRanking>>(
        "rankings", countryCode, "clubs"
    ) {
        parameters {
            if (after != null) append("after", after)
            if (before != null) append("before", before)
            if (limit != null) append("limit", limit.toString())
        }
    }.mapCatching { it ?: error("`getClubRanking` returned unexpected null") }

    /**
     * Retrieves the scheduled event rotation.
     *
     * @return A [Result] containing a list of [ScheduledEvent] representing upcoming events.
     */
    override suspend fun getEventsRotation(): Result<List<ScheduledEvent>> =
        getRequest<List<ScheduledEvent>>("events", "rotation").mapCatching {
            it ?: error("`getEventRotation` returned unexpected null")
        }

    private suspend inline fun <reified T> getRequest(
        vararg pathSegments: String,
        block: HttpRequestBuilder.() -> Unit = {},
    ): Result<T?> = runCatching {
        val result = client.get {
            url {
                path(*pathSegments)
            }

            block()
        }

        if (result.status.isSuccess())
            return Result.success(result.body<T>())

        when (result.status) {
            HttpStatusCode.NotFound -> null
            HttpStatusCode.BadRequest -> throw BadRequestException(result.body())
            HttpStatusCode.Forbidden -> throw AccessDeniedException(result.body())
            HttpStatusCode.TooManyRequests -> throw LimitsExceededException(result.body())
            HttpStatusCode.InternalServerError -> throw InternalServerErrorException(result.body())
            HttpStatusCode.ServiceUnavailable -> throw UnderMaintenanceException(result.body())
            else -> throw IOException(
                "Brawl Stars API returned a '${result.status.value}' status code with the " +
                    "following response: ${result.bodyAsText()}"
            )
        }
    }
}
