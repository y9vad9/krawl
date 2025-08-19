package com.y9vad9.krawl.api.v1.test.client

import com.y9vad9.krawl.ExperimentalKrawlApi
import com.y9vad9.krawl.api.v1.BrawlStarsApiClient
import com.y9vad9.krawl.api.v1.RateLimitedBrawlStarsApiClient
import com.y9vad9.krawl.api.v1.club.Club
import com.y9vad9.krawl.api.v1.player.Player
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Clock
import kotlin.time.Duration.Companion.seconds
import kotlin.time.Instant
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest

@OptIn(ExperimentalCoroutinesApi::class, ExperimentalKrawlApi::class)
class RateLimitedBrawlStarsApiClientTest {

    private val dispatcher = StandardTestDispatcher()
    private val testScope = TestScope(dispatcher)

    private val delegate: BrawlStarsApiClient = mockk()

    @Test
    fun `GIVEN delegate succeeds WHEN single call is made THEN it returns immediately`() = testScope.runTest {
        // GIVEN
        val player = mockk<Player>()
        coEvery { delegate.getPlayer("#AAA") } returns Result.success(player)

        val client = RateLimitedBrawlStarsApiClient(
            delegate = delegate,
            maxRequests = 2,
            per = 1.seconds,
        )

        // WHEN
        val result = client.getPlayer("#AAA")

        // THEN
        assertEquals(Result.success(player), result)
        coVerify(exactly = 1) { delegate.getPlayer("#AAA") }
    }

    @Test
    fun `GIVEN rate limit 1 req per second WHEN two calls made THEN second is delayed`() = testScope.runTest {
        // GIVEN
        val player = mockk<Player>()
        coEvery { delegate.getPlayer("#BBB") } returns Result.success(player)

        val client = RateLimitedBrawlStarsApiClient(
            delegate = delegate,
            maxRequests = 1,
            per = 1.seconds,
            clock = testClock(testScheduler),
        )

        // WHEN
        val first = async { client.getPlayer("#BBB") }
        advanceUntilIdle()
        val second = async { client.getPlayer("#BBB") }

        // THEN first finishes immediately
        assertEquals(Result.success(player), first.await())
        coVerify(exactly = 1) { delegate.getPlayer("#BBB") }

        // second should be pending until we advance virtual time
        advanceTimeBy(1.seconds)
        advanceUntilIdle()

        assertEquals(Result.success(player), second.await())
        coVerify(exactly = 2) { delegate.getPlayer("#BBB") }
    }

    @Test
    fun `GIVEN multiple methods WHEN called THEN all go through rate limiter`() = testScope.runTest {
        // GIVEN
        val club = mockk<Club>()
        coEvery { delegate.getClub("#CCC") } returns Result.success(club)

        val client = RateLimitedBrawlStarsApiClient(
            delegate = delegate,
            maxRequests = 1,
            per = 1.seconds,
            clock = testClock(testScheduler),
        )

        // WHEN
        val call1 = async { client.getClub("#CCC") }
        advanceUntilIdle()
        val call2 = async { client.getClub("#CCC") }

        // THEN
        assertEquals(Result.success(club), call1.await())
        advanceTimeBy(1.seconds)
        advanceUntilIdle()
        assertEquals(Result.success(club), call2.await())
        coVerify(exactly = 2) { delegate.getClub("#CCC") }
    }

    // Fake Clock that follows the virtual scheduler's time
    private fun testClock(scheduler: kotlinx.coroutines.test.TestCoroutineScheduler): Clock =
        object : Clock {
            override fun now(): Instant = Instant.fromEpochMilliseconds(scheduler.currentTime)
        }
}
