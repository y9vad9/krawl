package com.y9vad9.bsapi.types.event.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.common.value.Count
import com.y9vad9.bsapi.types.createUnsafe
import com.y9vad9.bsapi.types.event.BrawlerView
import com.y9vad9.bsapi.types.event.battle.Battle
import com.y9vad9.bsapi.types.player.value.EntityTag
import com.y9vad9.bsapi.types.player.value.PlayerTag
import com.y9vad9.bsapi.types.player.value.isBot
import com.y9vad9.bsapi.types.player.value.isPlayer
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class BattleTeams<TEntityTag : EntityTag, TBrawlerView : BrawlerView>(
    public val raw: List<List<Battle.PlayerView<TEntityTag, TBrawlerView>>>,
) {

    init {
        require(raw.isNotEmpty()) { "BattleTeams must have at least one team" }
    }

    public val firstTeam: List<Battle.PlayerView<TEntityTag, TBrawlerView>> get() = raw[0]

    @OptIn(ValueConstructor.Unsafe::class)
    public val count: Count get() = Count.createUnsafe(raw.size)

    /**
     * For friendly battles there can be no secondTeam available
     */
    public val secondTeam: List<Battle.PlayerView<TEntityTag, TBrawlerView>>? get() = raw.getOrNull(1)
    public val thirdTeam: List<Battle.PlayerView<TEntityTag, TBrawlerView>>? get() = raw.getOrNull(2)
    public val fourthTeam: List<Battle.PlayerView<TEntityTag, TBrawlerView>>? get() = raw.getOrNull(3)
    public val fifthTeam: List<Battle.PlayerView<TEntityTag, TBrawlerView>>? get() = raw.getOrNull(4)
}

public fun <TBrawlerView : BrawlerView> BattleTeams<EntityTag, TBrawlerView>.findPlayer(
    tag: PlayerTag,
): Battle.PlayerView<PlayerTag, TBrawlerView>? {
    @Suppress("UNCHECKED_CAST")
    return raw.flatten().firstOrNull {
        it.tag == tag
    } as? Battle.PlayerView<PlayerTag, TBrawlerView>
}

public val BattleTeams<EntityTag, *>.hasBots: Boolean get() = raw.flatten().any { it.tag.isBot() }
public val BattleTeams<EntityTag, *>.onlyHasRealPlayers: Boolean get() = raw.flatten().all { it.tag.isPlayer() }

public fun <TBrawlerView : BrawlerView> BattleTeams<EntityTag, TBrawlerView>.withOnlyRealPlayersOrNull(): BattleTeams<EntityTag, TBrawlerView>? {
    return if (hasBots) null else this
}

public fun <TBrawlerView : BrawlerView> BattleTeams<EntityTag, TBrawlerView>.requireOnlyRealPlayers(): BattleTeams<PlayerTag, TBrawlerView> {
    @Suppress("UNCHECKED_CAST")
    return if (hasBots) error("There are bots in the team: $raw") else this as BattleTeams<PlayerTag, TBrawlerView>
}