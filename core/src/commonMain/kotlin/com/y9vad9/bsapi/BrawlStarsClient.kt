package com.y9vad9.bsapi

import com.y9vad9.bsapi.types.brawler.Brawler
import com.y9vad9.bsapi.types.brawler.value.BrawlerId
import com.y9vad9.bsapi.types.club.Club
import com.y9vad9.bsapi.types.club.ClubMember
import com.y9vad9.bsapi.types.club.value.ClubTag
import com.y9vad9.bsapi.types.common.value.Count
import com.y9vad9.bsapi.types.common.value.CountryCode
import com.y9vad9.bsapi.types.event.battle.RawBattle
import com.y9vad9.bsapi.types.event.ScheduledEvent
import com.y9vad9.bsapi.types.exception.BrawlStarsAPIException
import com.y9vad9.bsapi.types.pagination.Cursors
import com.y9vad9.bsapi.types.pagination.Page
import com.y9vad9.bsapi.types.pagination.PagesIterator
import com.y9vad9.bsapi.types.player.Player
import com.y9vad9.bsapi.types.player.value.PlayerTag
import com.y9vad9.bsapi.types.player.value.withHashTag
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.reflect.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

/**
 * A client for interacting with the Brawl Stars API.
 *
 * This client provides methods for retrieving player information, battle logs, and club details.
 * It utilizes the provided bearer token for authentication and is designed for asynchronous operations.
 *
 * @param bearerToken The token used for API authentication.
 * @param json The JSON configuration for parsing API responses. Defaults to ignoring unknown keys.
 * @param engine Ktor's Client Engine to execute requests by.
 * @param configBlock Optional HTTP client configuration.
 */
public class BrawlStarsClient(
    bearerToken: String,
    json: Json = Json { ignoreUnknownKeys = true },
    engine: HttpClientEngine,
    baseUrl: String = "https://api.brawlstars.com/v1/",
    configBlock: HttpClientConfig<*>.() -> Unit = {},
) {
    private val client: HttpClient = HttpClient(engine) {
        defaultRequest {
            url(baseUrl)
            accept(ContentType.Application.Json)

            bearerAuth(bearerToken)
        }

        install(ContentNegotiation) {
            json(json)
        }

        configBlock()
    }

    /**
     * Retrieves information about a player.
     *
     * @param tag The unique player tag (e.g., #PLAYER_TAG).
     * @return [Result] containing the [Player] object if successful, or null if the player was not found.
     */
    public suspend fun getPlayer(tag: PlayerTag): Result<Player?> =
        getRequest(typeInfo<Player>(), "players/${tag.withHashTag.replace("#", "%23")}")

    /**
     * Retrieves a player's battle log, showing recent battles.
     *
     * **Note:** New battles may take up to 30 minutes to appear in the battle log.
     *
     * @param tag The unique player tag (e.g., #PLAYER_TAG).
     * @return [Result] containing a list of [RawBattle] objects if successful, or null if the player was not found.
     */
    public suspend fun getPlayerBattlelog(tag: PlayerTag): Result<List<RawBattle>?> =
        getRequest<ItemsResponse<RawBattle>>(
            typeInfo<ItemsResponse<RawBattle>>(),
            "players/${tag.withHashTag.replace("#", "%23")}/battlelog"
        ).map { it?.items }

    /**
     * Retrieves information about a club.
     *
     * @param tag The unique club tag (e.g., #CLUB_TAG).
     * @return [Result] containing the [Club] object if successful, or null if the club was not found.
     */
    public suspend fun getClub(tag: ClubTag): Result<Club?> =
        getRequest(
            typeInfo<Club?>(),
            "clubs/${tag.toString().replace("#", "%23")}"
        )

    /**
     * Retrieves the list of members in a club.
     *
     * @param tag The unique club tag (e.g., #CLUB_TAG).
     * @return [Result] containing a [ClubMember] object if successful, or null if the club was not found.
     */
    public suspend fun getClubMembers(tag: ClubTag): Result<List<ClubMember>> = getRequest<ItemsResponse<ClubMember>>(
        typeInfo = typeInfo<ItemsResponse<ClubMember>>(),
        url = "clubs/${tag.toString().replace("#", "%23")}/members"
    ).map { it!!.items }

    /**
     * Provides a lazy iterator for paginated retrieval of club members.
     *
     * @param tag The unique club tag (e.g., #CLUB_TAG).
     * @param limit The maximum number of members to retrieve per page.
     * @return [PagesIterator] that iterates through paginated [ClubMember] objects.
     */
    public fun getClubMembersLazily(tag: ClubTag, limit: Count): PagesIterator<ClubMember> {
        return PagesIterator(limit = limit) { count, cursors ->
            getRequestListWithPagination(
                url = "clubs/${tag.toString().replace("#", "%23")}/members",
                cursors = cursors,
                limit = count,
                typeInfo = typeInfo<ClubMember>()
            )
        }
    }

    /**
     * Retrieves a list of all brawlers.
     *
     * @return [Result] containing a list of [BrawlerView] objects.
     */
    public suspend fun getBrawlers(): Result<List<Brawler.View>> {
        return getRequest<ItemsResponse<Brawler.View>>(typeInfo<ItemsResponse<Brawler.View>>(), "brawlers")
            .map { it!!.items } // no kaboom expected: API should never return 404
    }

    /**
     * Retrieves information about a specific brawler.
     *
     * @param id The unique ID of the brawler.
     * @return [Result] containing the [BrawlerView] object if successful, or null if the brawler was not found.
     */
    public suspend fun getBrawler(id: BrawlerId): Result<Brawler.View?> {
        return getRequest<Brawler.View>(typeInfo<Brawler.View>(), "brawlers/${id.value}")
    }

    /**
     * Provides a lazy iterator for paginated retrieval of brawlers.
     *
     * @param limit The maximum number of brawlers to retrieve per page.
     * @return [PagesIterator] that iterates through paginated [BrawlerView] objects.
     */
    public fun getBrawlersLazily(limit: Count): PagesIterator<Brawler.View> {
        return PagesIterator(limit) { _, cursors ->
            getRequestListWithPagination("brawlers", cursors, limit, typeInfo<Brawler.View>())
        }
    }

    /**
     * Retrieves a list of club rankings for a specific country.
     *
     * @param countryCode The country code to filter rankings (default: GLOBAL).
     * @return [Result] containing a list of [Club.Ranking] objects if successful.
     */
    public suspend fun getClubsRankings(countryCode: CountryCode = CountryCode.GLOBAL): Result<List<Club.Ranking>> {
        return getRequest<ItemsResponse<Club.Ranking>>(
            typeInfo = typeInfo<ItemsResponse<Club.Ranking>>(),
            url = "rankings/${countryCode.value}/clubs",
        ).map { it!!.items }
    }

    /**
     * Provides a lazy iterator for paginated retrieval of club rankings.
     *
     * @param countryCode The country code to filter rankings (default: GLOBAL).
     * @param limit The maximum number of rankings to retrieve per page.
     * @return [PagesIterator] that iterates through paginated [Club.Ranking] objects.
     */
    public fun getClubsRankingsLazily(
        countryCode: CountryCode = CountryCode.GLOBAL,
        limit: Count,
    ): PagesIterator<Club.Ranking> {
        return PagesIterator(limit) { count, cursors ->
            getRequestListWithPagination(
                typeInfo = typeInfo<List<Club.Ranking>>(),
                url = "rankings/${countryCode.value}/clubs",
                cursors = cursors,
                limit = count,
            )
        }
    }

    /**
     * Retrieves a list of player rankings for a specific country.
     *
     * @param countryCode The country code to filter rankings (default: GLOBAL).
     * @return [Result] containing a list of [Player.Ranking] objects if successful.
     */
    public suspend fun getPlayersRankings(countryCode: CountryCode = CountryCode.GLOBAL): Result<List<Player.Ranking>> {
        return getRequest<ItemsResponse<Player.Ranking>>(
            typeInfo = typeInfo<ItemsResponse<Player.Ranking>>(),
            url = "rankings/${countryCode.value}/players",
        ).map { it?.items.orEmpty() }
    }

    /**
     * Provides a lazy iterator for paginated retrieval of player rankings.
     *
     * @param countryCode The country code to filter rankings (default: GLOBAL).
     * @param limit The maximum number of rankings to retrieve per page.
     * @return [PagesIterator] that iterates through paginated [Player.Ranking] objects.
     */
    public fun getPlayersRankingsLazily(
        countryCode: CountryCode = CountryCode.GLOBAL,
        limit: Count,
    ): PagesIterator<Player.Ranking> {
        return PagesIterator(limit) { count, cursors ->
            getRequestListWithPagination(
                typeInfo = typeInfo<List<Player.Ranking>>(),
                url = "rankings/${countryCode.value}/players",
                cursors = cursors,
                limit = count,
            )
        }
    }

    /**
     * Retrieves rankings for a specific brawler in a specific country.
     *
     * @param countryCode The country code to filter rankings (default: GLOBAL).
     * @param brawlerId The unique identifier of the brawler.
     * @return [Result] containing a list of [Brawler.Ranking] objects if successful.
     * @see BrawlerId.Companion
     */
    public suspend fun getBrawlerRankings(
        countryCode: CountryCode = CountryCode.GLOBAL,
        brawlerId: BrawlerId,
    ): Result<List<Brawler.Ranking>> {
        return getRequest<ItemsResponse<Brawler.Ranking>>(
            typeInfo = typeInfo<ItemsResponse<Brawler.Ranking>>(),
            url = "rankings/${countryCode.value}/brawlers/${brawlerId.value}",
        ).map { it!!.items }
    }

    /**
     * Provides a lazy iterator for paginated retrieval of brawler rankings.
     *
     * @param countryCode The country code to filter rankings (default: GLOBAL).
     * @param brawlerId The unique identifier of the brawler.
     * @param limit The maximum number of rankings to retrieve per page.
     * @return [PagesIterator] that iterates through paginated [Brawler.Ranking] objects.
     * @see BrawlerId.Companion
     */
    public fun getBrawlerRankingsLazily(
        countryCode: CountryCode = CountryCode.GLOBAL,
        brawlerId: BrawlerId,
        limit: Count,
    ): PagesIterator<Brawler.Ranking> {
        return PagesIterator(limit) { count, cursors ->
            getRequestListWithPagination(
                typeInfo = typeInfo<List<Brawler.Ranking>>(),
                url = "rankings/${countryCode.value}/brawlers/${brawlerId.value}",
                cursors = cursors,
                limit = count,
            )
        }
    }

    /**
     * Get event rotation for ongoing events.
     */
    public suspend fun getEventRotation(): Result<List<ScheduledEvent>> = getRequest<List<ScheduledEvent>>(
        typeInfo = typeInfo<List<ScheduledEvent>>(),
        url = "events/rotation",
    ).map { it!! }

    private suspend fun <T> getRequestListWithPagination(
        url: String,
        cursors: Cursors?,
        limit: Count,
        typeInfo: TypeInfo,
    ): Result<Page<T>> = getRequest<Page<T>>(
        typeInfo = typeInfo,
        url = url,
    ) {
        parameters {
            append("limit", limit.raw.toString())
            if (cursors?.after != null)
                append("after", cursors.after.value)

            if (cursors?.before != null)
                append("after", cursors.before.value)
        }
    }.map {
        it!!
    }

    private suspend fun <T> getRequest(
        typeInfo: TypeInfo,
        url: String,
        block: HttpRequestBuilder.() -> Unit = {},
    ): Result<T?> =
        runCatching {
            val result = client.get(url) {
                block()
            }

            return@runCatching if (result.status.isSuccess()) {
                result.body<T>(typeInfo)
            } else if (result.status == HttpStatusCode.NotFound) {
                null
            } else if (result.status == HttpStatusCode.BadRequest) {
                throw BrawlStarsAPIException.BadRequest()
            } else if (result.status == HttpStatusCode.Forbidden) {
                throw BrawlStarsAPIException.AccessDenied()
            } else if(result.status == HttpStatusCode.TooManyRequests) {
                throw BrawlStarsAPIException.LimitsExceeded()
            } else if (result.status == HttpStatusCode.InternalServerError) {
                throw BrawlStarsAPIException.InternalServerError()
            } else if (result.status == HttpStatusCode.ServiceUnavailable) {
                throw BrawlStarsAPIException.UnderMaintenance()
            } else {
                throw BrawlStarsAPIException.RawHttpError(result.status)
            }
        }

    @Serializable
    private data class ItemsResponse<T>(
        val items: List<T>,
    )
}