package com.y9vad9.krawl.event.battle.participant

import com.y9vad9.krawl.player.PlayerTag

/**
 * Represents a collection of participants involved in a Brawl Stars battle.
 *
 * Implementations of this interface are specialized by game mode or battle type,
 * such as [FriendlyBattleParticipants], [RankedBattlePlayers], or [TrophyLeagueBattlePlayers].
 */
public sealed interface BattleParticipants {
    /**
     * The list of individual participants in the battle.
     */
    public val list: List<BattleParticipant>

    /**
     * Returns the participant matching the specified [tag], or `null` if no match is found.
     *
     * @param tag The [PlayerTag] of the participant to locate.
     * @return The [BattleParticipant] if present, or `null`.
     */
    public fun getParticipantOrNull(tag: PlayerTag): BattleParticipant?

    /**
     * Returns the participant matching the specified [tag], or throws if not found.
     *
     * @param tag The [PlayerTag] of the participant to locate.
     * @return The [BattleParticipant] if found.
     * @throws IllegalStateException If no participant with the given tag exists.
     */
    @Throws(IllegalStateException::class)
    public fun getParticipantOrThrow(tag: PlayerTag): BattleParticipant
}

/**
 * Represents participants in a friendly battle (custom games or friendly matches).
 *
 * These battles do not affect trophies or rank progression.
 */
public data class FriendlyBattleParticipants(
    override val list: List<BattleParticipant>,
) : BattleParticipants {

    private val tagIndex: Map<PlayerTag, BattleParticipant> by lazy {
        list.associateBy { it.tag }
    }

    override fun getParticipantOrNull(tag: PlayerTag): BattleParticipant? = tagIndex[tag]

    override fun getParticipantOrThrow(tag: PlayerTag): BattleParticipant =
        getParticipantOrNull(tag) ?: throwUnableToFindParticipant(tag)
}

/**
 * Attempts to retrieve the [BattlePlayer] with the given [tag] from this team.
 *
 * @param tag The [PlayerTag] of the player to look for.
 * @return The matching [BattlePlayer], or `null` if not found or not a player.
 */
public fun FriendlyBattleParticipants.getAsPlayerOrNull(tag: PlayerTag): BattlePlayer? =
    getParticipantOrNull(tag) as? BattlePlayer?

/**
 * Retrieves the [BattlePlayer] with the given [tag] from this team.
 *
 * @param tag The [PlayerTag] of the player to look for.
 * @return The matching [BattlePlayer].
 * @throws ClassCastException if the participant exists but is not a player.
 * @throws IllegalStateException if no participant with the given tag exists.
 */
public fun FriendlyBattleParticipants.getAsPlayerOrThrow(tag: PlayerTag): BattlePlayer =
    getParticipantOrThrow(tag) as BattlePlayer

/**
 * Attempts to retrieve the [BattleBot] with the given [tag] from this team.
 *
 * @param tag The [PlayerTag] of the bot to look for.
 * @return The matching [BattleBot], or `null` if not found or not a bot.
 */
public fun FriendlyBattleParticipants.getAsBotOrNull(tag: PlayerTag): BattleBot? =
    getParticipantOrNull(tag) as? BattleBot?

/**
 * Retrieves the [BattleBot] with the given [tag] from this team.
 *
 * @param tag The [PlayerTag] of the bot to look for.
 * @return The matching [BattleBot].
 * @throws ClassCastException if the participant exists but is not a bot.
 * @throws IllegalStateException if no participant with the given tag exists.
 */
public fun FriendlyBattleParticipants.getAsBotOrThrow(tag: PlayerTag): BattleBot =
    getParticipantOrThrow(tag) as BattleBot

/**
 * Represents participants in a ranked battle (Power League / Ranked mode).
 *
 * These battles affect competitive progression but not trophy count.
 */
public data class RankedBattlePlayers(
    override val list: List<RankedBattlePlayer>,
) : BattleParticipants {

    private val tagIndex: Map<PlayerTag, RankedBattlePlayer> by lazy {
        list.associateBy { it.tag }
    }

    override fun getParticipantOrNull(tag: PlayerTag): RankedBattlePlayer? = tagIndex[tag]

    override fun getParticipantOrThrow(tag: PlayerTag): RankedBattlePlayer =
        getParticipantOrNull(tag) ?: throwUnableToFindParticipant(tag)
}

/**
 * Represents participants in a trophy league battle.
 *
 * These battles directly impact a player's trophy count and progression on the ladder.
 */
public data class TrophyLeagueBattlePlayers(
    override val list: List<TrophyLeagueBattlePlayer>,
) : BattleParticipants {

    private val tagIndex: Map<PlayerTag, TrophyLeagueBattlePlayer> by lazy {
        list.associateBy { it.tag }
    }

    override fun getParticipantOrNull(tag: PlayerTag): TrophyLeagueBattlePlayer? = tagIndex[tag]

    override fun getParticipantOrThrow(tag: PlayerTag): TrophyLeagueBattlePlayer =
        getParticipantOrNull(tag) ?: throwUnableToFindParticipant(tag)
}

private fun throwUnableToFindParticipant(tag: PlayerTag): Nothing =
    error("Unable to find participant with given tag: ${tag.stringWithTagPrefix}.")
