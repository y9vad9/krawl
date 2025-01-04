package com.y9vad9.brawlstars.types.event

import com.y9vad9.brawlstars.types.event.battle.RawBattle.BrawlerBattleView
import com.y9vad9.brawlstars.types.player.value.EntityTag
import com.y9vad9.brawlstars.types.player.value.PlayerName

/**
 * Represents a view of a player in the game, including their tag, name, and current brawler in battle.
 * The [EntityTag] may represent either a player or a bot, particularly in the context of friendly matches.
 *
 * In friendly matches, it's possible for the tag to belong to a bot instead of a player. This distinction is
 * important when processing data related to players and bots in the game. The [EntityTag] interface allows
 * for easy handling of both scenarios in a type-safe manner.
 *
 * @property tag The [EntityTag] representing either the player's or bot's tag.
 * @property name The name of the player, represented by the [PlayerName] type.
 * @property brawler The current brawler being used by the player or bot in the battle, represented by [BrawlerBattleView].
 */
public data class StarPlayer<TPlayerTag : EntityTag, TBrawlerView : BrawlerView>(
    val tag: TPlayerTag,
    val name: PlayerName,
    val brawler: TBrawlerView,
)