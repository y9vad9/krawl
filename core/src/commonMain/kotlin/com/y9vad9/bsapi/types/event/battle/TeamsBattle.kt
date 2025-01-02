package com.y9vad9.bsapi.types.event.battle

import com.y9vad9.bsapi.types.event.*
import com.y9vad9.bsapi.types.event.value.BattleResultKind
import com.y9vad9.bsapi.types.event.value.BattleTeams
import com.y9vad9.bsapi.types.event.value.EventMode
import com.y9vad9.bsapi.types.event.value.Trophies
import com.y9vad9.bsapi.types.player.value.EntityTag
import com.y9vad9.bsapi.types.player.value.PlayerTag
import kotlinx.datetime.Instant
import kotlin.time.Duration

/**
 * Represents all 3-vs-3 and 5-vs-5 game modes (excluding Trio Showdown).
 *
 * This sealed interface defines the structure and properties common to battles
 * involving predefined teams, either in standard or friendly contexts.
 */
public sealed interface TeamsBattle : Battle {
    /**
     * The star player of the battle.
     *
     * This may be `null` in specific cases, such as friendly battles where no player
     * made a significant impact during the match.
     */
    public val starPlayer: StarPlayer<out EntityTag, out TrophiesOrFriendlyBrawlerView>?

    /**
     * The teams involved in the battle.
     *
     * - In regular battles, this typically includes three or five teams.
     * - In friendly battles, there may be one to five teams.
     *
     * At least one team is always present in the battle.
     */
    public val teams: BattleTeams<out EntityTag, out BrawlerView>

    /**
     * The result of the battle, indicating the overall outcome for the teams.
     */
    public val result: BattleResultKind

    public val duration: Duration
}

/**
 * Represents a friendly team battle.
 *
 * These battles are casual and do not affect player trophies. Friendly matches may involve
 * flexible team compositions ranging from one to five teams.
 *
 * @property battleTime The time when the battle occurred.
 * @property mode The mode of the event.
 * @property starPlayer The star player of the battle, if any.
 * @property teams The teams involved in the battle.
 * @property event The event metadata for the battle.
 * @property duration The duration of the battle.
 * @property result The overall result of the battle.
 */
public data class FriendlyTeamsBattle(
    override val battleTime: Instant,
    override val starPlayer: StarPlayer<EntityTag, FriendlyBrawlerView>?,
    override val teams: BattleTeams<EntityTag, FriendlyBrawlerView>,
    override val event: Event,
    override val duration: Duration,
    override val result: BattleResultKind
) : TeamsBattle

/**
 * Represents a standard team battle that impacts player trophies.
 *
 * These battles involve regular 3-vs-3 or 5-vs-5 gameplay where the outcome directly affects
 * player rankings and trophy counts.
 *
 * ## Known limitations
 * After a mega tree (basically mega pig), we can learn that it will
 * be passed into this category for the lack of unique traits, except
 * [Event.mode] == [EventMode.UNKNOWN] for some of the modes. We don't have reliable
 * data to determine such events.
 *
 * ### Way around
 * But there's still way around if you need to figure out at least most battles:
 * - Such events have predefined range of [EventMode]s, so start your conditioning on it.
 * - Such events have no [trophyChange] (that equal to zero) when [result] == [BattleResultKind.DEFEAT]
 * or when [result] == [BattleResultKind.VICTORY].
 * - Partially if a player uses the brawler with high-trophies, for [result] == [BattleResultKind.DRAW]
 * it might still have effect on brawler's trophies.
 *
 * In case if it's a brawler under 1100 trophies (I am not sure for now from which trophies
 * does Brawl Stars take trophies, but probably it's not less than 1100 trophies), you
 * cannot determine such battles as a Mega Pig or of such kind. If you find a way to do so,
 * please report it on library's issues – it will be highly appreciated.
 *
 * @property battleTime The time when the battle occurred.
 * @property mode The mode of the event.
 * @property starPlayer The star player of the battle, if any.
 * @property teams The teams involved in the battle.
 * @property event The event metadata for the battle.
 * @property duration The duration of the battle.
 * @property result The overall result of the battle.
 */
public data class TrophiesTeamsBattle(
    override val battleTime: Instant,
    override val starPlayer: StarPlayer<PlayerTag, TrophiesBrawlerView>?,
    override val teams: BattleTeams<PlayerTag, TrophiesBrawlerView>,
    override val event: Event,
    override val duration: Duration,
    override val result: BattleResultKind,
    val trophyChange: Trophies = Trophies.ZERO,
) : TeamsBattle