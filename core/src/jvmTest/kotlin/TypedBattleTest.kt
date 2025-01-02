@file:OptIn(ValueConstructor.Unsafe::class)

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.common.value.Count
import com.y9vad9.bsapi.types.createUnsafe
import com.y9vad9.bsapi.types.event.battle.*
import com.y9vad9.bsapi.types.event.value.EventMode
import com.y9vad9.bsapi.types.pagination.*
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertIs

class TypedBattleTest {
    @Test
    fun `test conversion`() {
        val list = Json.decodeFromString<List<RawBattle>>(
            TypedBattleTest::class.java.classLoader.getResource("typed-battles-test-1.json")!!.readText()
        ).typed()

        assertIs<FriendlyRankedBattle>(list[0])
        assert((list[0] as FriendlyRankedBattle).rounds.size == 5)

        assertIs<RegularRankedBattle>(list[1])
        assert((list[1] as RegularRankedBattle).rounds.size == 2)

        assertIs<FriendlyTeamsBattle>(list[2])

        assertIs<TrophiesSoloShowdownBattle>(list[3])

        assertIs<TrophiesSoloShowdownBattle>(list[4])
        assert(!list[4].isMapMaker)

        assertIs<TrophiesTeamShowdownBattle>(list[5])
        assert(list[5].isMapMaker)

        assertIs<TrophiesTeamsBattle>(list[6])
        assert(list[6].event.mode == EventMode.GEM_GRAB)

        println(list[7])
        assertIs<TrophiesTeamsBattle>(list[7])
    }

    @Test
    fun `test conversion pagination`(): Unit = runTest {
        val list = Json.decodeFromString<List<RawBattle>>(
            TypedBattleTest::class.java.classLoader.getResource("typed-battles-test-1.json")!!.readText()
        )

        val iterator = list.listIterator()

        val pageIteratorFacade = PagesIterator(
            limit = Count.createUnsafe(3),
            provider = { limit, cursors ->
                runCatching {
                    if (cursors?.after != null) {
                        val nextIndex = iterator.nextIndex()
                        val items = (nextIndex..nextIndex + limit.raw).mapNotNull { _ ->
                            if(iterator.hasNext())
                                iterator.next()
                            else null
                        }.takeIf { it.isNotEmpty() }
                        Page(items, paging = Cursors(BrawlStarsCursor.createUnsafe(""), if (items == null) null else BrawlStarsCursor.createUnsafe("")))
                    } else if (cursors?.before != null) {
                        val nextIndex = iterator.previousIndex()
                        val items = (nextIndex..nextIndex + limit.raw).mapNotNull { _ ->
                            if(iterator.hasPrevious())
                                iterator.previous()
                            else null
                        }.takeIf { it.isNotEmpty() }
                        Page(items, paging = Cursors(if (items == null) null else BrawlStarsCursor.createUnsafe(""), BrawlStarsCursor.createUnsafe("")))
                    } else {
                        val items = (0..limit.raw).mapNotNull {
                            if(iterator.hasNext())
                                iterator.next()
                            else null
                        }.takeIf { it.isNotEmpty() }

                        Page(items, paging = Cursors(BrawlStarsCursor.createUnsafe(""), if (items == null) null else BrawlStarsCursor.createUnsafe("")))
                    }
                }
            }
        ).map { println("Returned list: $it");it; }.typed()



        val resultingList = pageIteratorFacade.asFlow().onEach { println("--------") }.toList().flatten()
        println(resultingList.joinToString("\n"))

        assertIs<FriendlyRankedBattle>(resultingList[0])
        assert((resultingList[0] as FriendlyRankedBattle).rounds.size == 5)

        assertIs<RegularRankedBattle>(resultingList[1])
        assert((resultingList[1] as RegularRankedBattle).rounds.size == 2)

        assertIs<FriendlyTeamsBattle>(resultingList[2])

        assertIs<TrophiesSoloShowdownBattle>(resultingList[3])

        assertIs<TrophiesSoloShowdownBattle>(resultingList[4])
        assert(!resultingList[4].isMapMaker)

        assertIs<TrophiesTeamShowdownBattle>(resultingList[5])
        assert(resultingList[5].isMapMaker)

        assertIs<TrophiesTeamsBattle>(resultingList[6])
        assert(list[6].event.mode == EventMode.GEM_GRAB)

        println(list[7])
        assertIs<TrophiesTeamsBattle>(resultingList[7])
    }
}