package com.y9vad9.krawl.api.v1

import com.y9vad9.krawl.api.v1.BrawlStarsApiClient.Companion.DEFAULT_COUNTRY_CODE
import com.y9vad9.krawl.api.v1.battle.BattleRecord
import com.y9vad9.krawl.api.v1.club.Club
import com.y9vad9.krawl.api.v1.club.ClubMember
import com.y9vad9.krawl.api.v1.event.ScheduledEvent
import com.y9vad9.krawl.api.v1.pagination.PaginatedList
import com.y9vad9.krawl.api.v1.player.Player
import com.y9vad9.krawl.api.v1.ranking.ClubRanking
import com.y9vad9.krawl.api.v1.ranking.PlayerRanking
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlin.time.Duration
import kotlinx.serialization.json.Json

/**
 * # Brawl Stars API Client
 *
 * Provides access to the [Brawl Stars REST API](https://developer.brawlstars.com).
 * All functions are **suspending** and return results wrapped in [Result],
 * with the successful value containing the requested data or `null` if not found.
 *
 * ## Pagination
 * Many endpoints support pagination using `after` and `before` cursors.
 * These cursors can be retrieved from the `paging` property of a previous response,
 * such as [PaginatedList].
 *
 * ## Implementations
 * This interface can be instantiated via:
 * - [create] — Uses the official API at `https://api.brawlstars.com`.
 * - [createWithRoyaleApiProxy] — Uses the RoyaleAPI proxy at `https://proxy.royaleapi.dev`.
 *
 * Both factory methods configure the client with:
 * - A provided [HttpClientEngine]
 * - An API access token
 * - A [Json] serializer (default: `ignoreUnknownKeys = true`)
 * - Optional extra [io.ktor.client.HttpClient] configuration
 */
public interface BrawlStarsApiClient {
    public companion object {
        /**
         * Default country code used in the rankings API.
         */
        public const val DEFAULT_COUNTRY_CODE: String = "global"

        /**
         * Creates a [BrawlStarsApiClient] using the official Brawl Stars API.
         *
         * This client will communicate with `https://api.brawlstars.com`.
         *
         * @param engine The [HttpClientEngine] to use for network requests.
         * @param bearerToken Your Brawl Stars API access token.
         * @param json The [Json] instance used for serialization/deserialization. Defaults to
         *             [Json] with `ignoreUnknownKeys = true`.
         * @return A [BrawlStarsApiClient] configured to call the official Brawl Stars API.
         */
        public fun create(
            engine: HttpClientEngine,
            bearerToken: String,
            json: Json = Json { ignoreUnknownKeys = true },
        ): BrawlStarsApiClient = DefaultBrawlStarsApiClient(
            engine = engine,
            bearerToken = bearerToken,
            baseUrl = "https://api.brawlstars.com/v1/"
        ) {
            install(ContentNegotiation) {
                json(json)
            }
        }

        /**
         * Creates a [BrawlStarsApiClient] using the RoyaleAPI proxy.
         *
         * This client will use the proxy endpoint `https://proxy.royaleapi.dev` instead of the official API.
         * See the proxy documentation: [https://docs.royaleapi.com/proxy.html](https://docs.royaleapi.com/proxy.html)
         *
         * @param engine The [HttpClientEngine] to use for network requests.
         * @param bearerToken Your Brawl Stars API access token.
         * @param json The [Json] instance used for serialization/deserialization. Defaults to
         *             [Json] with `ignoreUnknownKeys = true`.
         * @return A [BrawlStarsApiClient] configured to call the RoyaleAPI proxy.
         */
        public fun createWithRoyaleApiProxy(
            engine: HttpClientEngine,
            bearerToken: String,
            json: Json = Json { ignoreUnknownKeys = true },
        ): BrawlStarsApiClient = DefaultBrawlStarsApiClient(
            engine = engine,
            bearerToken = bearerToken,
            baseUrl = "https://bsproxy.royaleapi.dev/v1/"
        ) {
            install(ContentNegotiation) {
                json(json)
            }
        }
    }

    /**
     * Retrieves a player by their tag.
     *
     * @param tag The unique tag of the player.
     * @return A [Result] wrapping the [Player] if found, or null if the player does not exist,
     *         or a failure if the request failed.
     */
    public suspend fun getPlayer(tag: String): Result<Player?>

    /**
     * Retrieves the battle log for a specific player.
     *
     * The battle log contains recent battles the player participated in.
     *
     * @param tag The unique tag of the player.
     * @return A [Result] wrapping a list of battle records.
     */
    public suspend fun getPlayerBattleLog(tag: String): Result<List<BattleRecord>?>

    /**
     * Retrieves a club by its tag.
     *
     * @param tag The unique tag of the club.
     * @return A [Result] wrapping the [Club] if found, or null if the club does not exist,
     *         or a failure if the request failed.
     */
    public suspend fun getClub(tag: String): Result<Club?>

    /**
     * Retrieves the list of members for a club by its tag.
     *
     * @param tag The unique tag of the club.
     * @return A [Result] wrapping the list of [ClubMember] objects, or a failure if the request failed.
     */
    public suspend fun getClubMembers(tag: String): Result<List<ClubMember>?>

    /**
     * Retrieves player rankings for a specific brawler.
     *
     * Supports pagination using the `after` and `before` cursors from a previous [PaginatedList].
     *
     * @param brawlerId The ID of the brawler.
     * @param countryCode The country code for rankings (default is [DEFAULT_COUNTRY_CODE]).
     * @param after Optional cursor to return results **after** the given item, for pagination.
     * @param before Optional cursor to return results **before** the given item, for pagination.
     * @param limit Optional parameter to limit the number of results returned.
     * @return A [Result] wrapping a [PaginatedList] of [PlayerRanking], or a failure if the request failed.
     */
    public suspend fun getBrawlerRanking(
        brawlerId: Int,
        countryCode: String = DEFAULT_COUNTRY_CODE,
        after: String? = null,
        before: String? = null,
        limit: Int? = null,
    ): Result<PaginatedList<PlayerRanking>>

    /**
     * Retrieves overall player rankings for a specific brawler.
     *
     * Supports pagination using the `after` and `before` cursors from a previous [PaginatedList].
     *
     * @param brawlerId The ID of the brawler.
     * @param countryCode The country code for rankings (default is [DEFAULT_COUNTRY_CODE]).
     * @param after Optional cursor to return results **after** the given item, for pagination.
     * @param before Optional cursor to return results **before** the given item, for pagination.
     * @param limit Optional parameter to limit the number of results returned.
     * @return A [Result] wrapping a [PaginatedList] of [PlayerRanking], or a failure if the request failed.
     */
    public suspend fun getPlayerRanking(
        brawlerId: Int,
        countryCode: String = DEFAULT_COUNTRY_CODE,
        after: String? = null,
        before: String? = null,
        limit: Int? = null,
    ): Result<PaginatedList<PlayerRanking>>

    /**
     * Retrieves club rankings.
     *
     * Supports pagination using the `after` and `before` cursors from a previous [PaginatedList].
     *
     * @param countryCode The country code for rankings (default is [DEFAULT_COUNTRY_CODE]).
     * @param after Optional cursor to return results **after** the given item, for pagination.
     * @param before Optional cursor to return results **before** the given item, for pagination.
     * @param limit Optional parameter to limit the number of results returned.
     * @return A [Result] wrapping a [PaginatedList] of [ClubRanking], or a failure if the request failed.
     */
    public suspend fun getClubRanking(
        countryCode: String = DEFAULT_COUNTRY_CODE,
        after: String? = null,
        before: String? = null,
        limit: Int? = null,
    ): Result<PaginatedList<ClubRanking>>

    /**
     * Retrieves the scheduled event rotation in Brawl Stars.
     *
     * @return A list of [ScheduledEvent] representing upcoming events.
     */
    public suspend fun getEventRotation(): Result<List<ScheduledEvent>>
}

/**
 * Creates a new instance of [BrawlStarsApiClient] with the client-side rate limit.
 * It's an experimental API with possible performance drawbacks.
 *
 * @param maxRequests Maximum number of requests allowed per [per] duration.
 * @param per The time window for rate limiting.
 *
 * TODO experimental annotation
 */
public fun BrawlStarsApiClient.rateLimited(
    maxRequests: Int,
    per: Duration,
): BrawlStarsApiClient = RateLimitedBrawlStarsApiClient(this, maxRequests, per)

/**
 * Returns the player if successful, or null in case of error.
 */
public suspend fun BrawlStarsApiClient.tryGetPlayer(tag: String): Player? =
    getPlayer(tag).getOrNull()

/**
 * Returns the club if successful, or null in case of error.
 */
public suspend fun BrawlStarsApiClient.tryGetClub(tag: String): Club? =
    getClub(tag).getOrNull()

/**
 * Returns the club members list if successful, or null in case of error.
 */
public suspend fun BrawlStarsApiClient.tryGetClubMembers(tag: String): List<ClubMember>? =
    getClubMembers(tag).getOrNull()

/**
 * Returns the brawler ranking if successful, or null in case of error.
 */
public suspend fun BrawlStarsApiClient.tryGetBrawlerRanking(
    brawlerId: Int,
    countryCode: String = DEFAULT_COUNTRY_CODE,
): List<PlayerRanking>? = getBrawlerRanking(brawlerId, countryCode).getOrNull()

/**
 * Returns the player ranking if successful, or null in case of error.
 */
public suspend fun BrawlStarsApiClient.tryGetPlayerRanking(
    brawlerId: Int,
    countryCode: String = DEFAULT_COUNTRY_CODE,
): List<PlayerRanking>? = getPlayerRanking(brawlerId, countryCode).getOrNull()

/**
 * Returns the club ranking if successful, or null in case of error.
 */
public suspend fun BrawlStarsApiClient.tryGetClubRanking(
    countryCode: String = DEFAULT_COUNTRY_CODE,
): List<ClubRanking>? = getClubRanking(countryCode).getOrNull()
