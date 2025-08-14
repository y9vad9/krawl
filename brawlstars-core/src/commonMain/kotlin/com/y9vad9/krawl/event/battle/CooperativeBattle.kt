package com.y9vad9.krawl.event.battle

import com.y9vad9.krawl.event.Event
import com.y9vad9.krawl.event.OfficialEvent
import com.y9vad9.krawl.event.battle.participant.BattleParticipants
import com.y9vad9.krawl.event.battle.participant.TrophyLeagueBattlePlayers
import kotlin.time.Instant
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * Marker interface for all **cooperative** battles in Brawl Stars.
 *
 * Cooperative battles are team-based game modes where players work together
 * to achieve a common objective, rather than competing directly against each other.
 *
 * Examples include game modes like Last Stand and Robo Rumble.
 */
public sealed interface CooperativeBattle : Battle {
    /**
     * The participants in this cooperative battle.
     */
    public val players: BattleParticipants
}

/**
 * Represents a **friendly** cooperative battle — an unranked cooperative match
 * played casually or for practice.
 */
public sealed interface FriendlyCooperativeBattle : CooperativeBattle, FriendlyBattle {
    /**
     * The participants in this friendly cooperative battle. Can be either
     * bot or real player.
     */
    public override val players: BattleParticipants
}

/**
 * Represents a non-friendly cooperative battle — a cooperative match that is not
 * considered friendly or casual.
 *
 * Extends [CooperativeBattle].
 */
public sealed interface EventCooperativeBattle : CooperativeBattle {
    /**
     * The participants in this cooperative battle.
     */
    public override val players: TrophyLeagueBattlePlayers

    /**
     * Represents official event returned from Brawl Stars API. For competitive
     * battles, it's always an official event.
     */
    public override val event: OfficialEvent
}

/**
 * Represents a Last Stand battle, a cooperative game mode where players team up
 * to defend against waves of enemies.
 *
 * This interface extends [CooperativeBattle] and adds a specific level property
 * indicating the difficulty or stage of the Last Stand battle.
 *
 * Last Stand battles can be either friendly or competitive depending on the
 * implementing subtype.
 */
public sealed interface LastStandBattle : CooperativeBattle {
    /**
     * The [EnemyBotsLevel] representing the difficulty or progression
     * stage of the battle.
     */
    public val level: EnemyBotsLevel
}

/**
 * A **friendly** Last Stand battle — an unranked cooperative match where players
 * team up to defend against waves of enemies in the Last Stand game mode.
 *
 * These battles are typically casual or practice matches and include:
 * - The difficulty level ([level]) of the Last Stand encounter.
 * - The participants ([players]), which can include bots or real players.
 * - The timestamp when the battle occurred ([time]).
 * - The event metadata ([event]) describing the map and mode.
 *
 * @property level The difficulty or progression stage of the Last Stand battle.
 * @property players The participants involved in the friendly cooperative battle.
 * @property time The time when the battle was played.
 * @property event The event (map and mode) in which this battle took place.
 */
public data class FriendlyLastStandBattle(
    override val level: EnemyBotsLevel,
    override val players: BattleParticipants,
    override val time: Instant,
    override val event: Event,
) : LastStandBattle, FriendlyCooperativeBattle

/**
 * A **competitive** Last Stand battle — a ranked cooperative match where players
 * team up to defend against waves of enemies with stakes and ranking implications.
 *
 * These battles include:
 * - The difficulty level ([level]) of the Last Stand encounter.
 * - The participants ([players]) with trophy league specific stats.
 * - The timestamp when the battle occurred ([time]).
 * - The event metadata ([event]) describing the map and mode.
 *
 * @property level The difficulty or progression stage of the Last Stand battle.
 * @property players The ranked participants involved in the competitive cooperative battle.
 * @property time The time when the battle was played.
 * @property event The event (map and mode) in which this battle took place.
 */
public data class EventLastStandBattle(
    override val level: EnemyBotsLevel,
    override val players: TrophyLeagueBattlePlayers,
    override val time: Instant,
    override val event: OfficialEvent,
) : LastStandBattle, EventCooperativeBattle

/**
 * Represents a classic cooperative battle in Brawl Stars.
 *
 * Classic cooperative battles are team-based game modes where players cooperate without
 * additional unique properties like Last Stand’s level. This interface is used as a
 * general marker for such cooperative battles.
 *
 * > **Note**: Some battles currently classified as classic cooperative may
 * > be moved in the future to more specific interfaces if additional unique
 * > attributes are identified that cannot be expressed through this general type.
 */
public sealed interface ClassicCooperativeBattle : CooperativeBattle {
    /**
     * The participants in this classic cooperative battle.
     */
    public override val players: BattleParticipants
}

/**
 * Represents a **friendly** classic cooperative battle — an unranked cooperative
 * match played casually or for practice.
 *
 * > **Note**: Some battles currently classified as classic cooperative may
 * > be moved in the future to more specific interfaces if additional unique
 * > attributes are identified that cannot be expressed through this general type.
 */
public data class FriendlyClassicCooperativeBattle(
    override val players: BattleParticipants,
    override val time: Instant,
    override val event: Event,
) : ClassicCooperativeBattle, FriendlyCooperativeBattle

/**
 * Represents a **competitive** classic cooperative battle — a cooperative match that
 * is not considered friendly or casual.
 *
 * > **Note**: Some battles currently classified as classic cooperative may
 * > be moved in the future to more specific interfaces if additional unique
 * > attributes are identified that cannot be expressed through this general type.
 */
public data class EventClassicCooperativeBattle(
    override val players: TrophyLeagueBattlePlayers,
    override val time: Instant,
    override val event: OfficialEvent,
) : ClassicCooperativeBattle, EventCooperativeBattle

/**
 * Returns `true` if this cooperative battle is a [FriendlyCooperativeBattle].
 *
 * This check is contract-aware: within `if (isFriendlyCooperative())` blocks,
 * `this` is smart-cast to [FriendlyCooperativeBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun CooperativeBattle.isFriendlyCooperative(): Boolean {
    contract {
        returns(true) implies (this@isFriendlyCooperative is FriendlyCooperativeBattle)
    }
    return this is FriendlyCooperativeBattle
}

/**
 * Returns `true` if this cooperative battle is an [EventCooperativeBattle].
 *
 * This check is contract-aware: within `if (isEventCooperative())` blocks,
 * `this` is smart-cast to [EventCooperativeBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun CooperativeBattle.isEventCooperative(): Boolean {
    contract {
        returns(true) implies (this@isEventCooperative is EventCooperativeBattle)
    }
    return this is EventCooperativeBattle
}

/**
 * Returns `true` if this cooperative battle is a [LastStandBattle].
 *
 * This check is contract-aware: within `if (isLastStandBattle())` blocks,
 * `this` is smart-cast to [LastStandBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun CooperativeBattle.isLastStandBattle(): Boolean {
    contract {
        returns(true) implies (this@isLastStandBattle is LastStandBattle)
    }
    return this is LastStandBattle
}

/**
 * Returns `true` if this cooperative battle is a [ClassicCooperativeBattle].
 *
 * This check is contract-aware: within `if (isClassicCooperativeBattle())` blocks,
 * `this` is smart-cast to [ClassicCooperativeBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun CooperativeBattle.isClassicCooperativeBattle(): Boolean {
    contract {
        returns(true) implies (this@isClassicCooperativeBattle is ClassicCooperativeBattle)
    }
    return this is ClassicCooperativeBattle
}

/**
 * Returns `true` if this cooperative battle is a friendly Last Stand battle.
 *
 * This check is contract-aware: within `if (isFriendlyLastStandBattle())` blocks,
 * `this` is smart-cast to [FriendlyLastStandBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun LastStandBattle.isFriendlyLastStandBattle(): Boolean {
    contract {
        returns(true) implies (this@isFriendlyLastStandBattle is FriendlyLastStandBattle)
    }
    return this is FriendlyLastStandBattle
}

/**
 * Returns `true` if this cooperative battle is a competitive Last Stand battle.
 *
 * This check is contract-aware: within `if (isEventLastStandBattle())` blocks,
 * `this` is smart-cast to [EventLastStandBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun LastStandBattle.isEventLastStandBattle(): Boolean {
    contract {
        returns(true) implies (this@isEventLastStandBattle is EventLastStandBattle)
    }
    return this is EventLastStandBattle
}

/**
 * Returns `true` if this cooperative battle is a friendly classic cooperative battle.
 *
 * This check is contract-aware: within `if (isFriendlyClassicCooperativeBattle())` blocks,
 * `this` is smart-cast to [FriendlyClassicCooperativeBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun ClassicCooperativeBattle.isFriendlyClassicCooperativeBattle(): Boolean {
    contract {
        returns(true) implies (this@isFriendlyClassicCooperativeBattle is FriendlyClassicCooperativeBattle)
    }
    return this is FriendlyClassicCooperativeBattle
}

/**
 * Returns `true` if this cooperative battle is a competitive classic cooperative battle.
 *
 * This check is contract-aware: within `if (isEventClassicCooperativeBattle())` blocks,
 * `this` is smart-cast to [EventClassicCooperativeBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun ClassicCooperativeBattle.isEventClassicCooperativeBattle(): Boolean {
    contract {
        returns(true) implies (this@isEventClassicCooperativeBattle is EventClassicCooperativeBattle)
    }
    return this is EventClassicCooperativeBattle
}

/**
 * Casts this cooperative battle to a [FriendlyCooperativeBattle], throwing an [IllegalArgumentException]
 * if it is not actually friendly.
 *
 * This cast is contract-aware: if the call returns successfully,
 * `this` is treated as [FriendlyCooperativeBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun CooperativeBattle.asFriendlyCooperative(): FriendlyCooperativeBattle {
    contract {
        returns() implies (this@asFriendlyCooperative is FriendlyCooperativeBattle)
    }
    require(this is FriendlyCooperativeBattle) {
        "Expected FriendlyCooperativeBattle but found ${this::class.simpleName}"
    }
    return this
}

/**
 * Casts this cooperative battle to an [EventCooperativeBattle], throwing an [IllegalArgumentException]
 * if it is not actually competitive.
 *
 * This cast is contract-aware: if the call returns successfully,
 * `this` is treated as [EventCooperativeBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun CooperativeBattle.asEventCooperative(): EventCooperativeBattle {
    contract {
        returns() implies (this@asEventCooperative is EventCooperativeBattle)
    }
    require(this is EventCooperativeBattle) {
        "Expected EventCooperativeBattle but found ${this::class.simpleName}"
    }
    return this
}

/**
 * Casts this cooperative battle to a [LastStandBattle], throwing an [IllegalArgumentException]
 * if it is not a Last Stand battle.
 *
 * This cast is contract-aware: if the call returns successfully,
 * `this` is treated as [LastStandBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun CooperativeBattle.asLastStandBattle(): LastStandBattle {
    contract {
        returns() implies (this@asLastStandBattle is LastStandBattle)
    }
    require(this is LastStandBattle) {
        "Expected LastStandBattle but found ${this::class.simpleName}"
    }
    return this
}

/**
 * Casts this cooperative battle to a [ClassicCooperativeBattle], throwing an [IllegalArgumentException]
 * if it is not a classic cooperative battle.
 *
 * This cast is contract-aware: if the call returns successfully,
 * `this` is treated as [ClassicCooperativeBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun CooperativeBattle.asClassicCooperativeBattle(): ClassicCooperativeBattle {
    contract {
        returns() implies (this@asClassicCooperativeBattle is ClassicCooperativeBattle)
    }
    require(this is ClassicCooperativeBattle) {
        "Expected ClassicCooperativeBattle but found ${this::class.simpleName}"
    }
    return this
}

/**
 * Casts this Last Stand battle to a [FriendlyLastStandBattle], throwing an [IllegalArgumentException]
 * if it is not friendly.
 *
 * This cast is contract-aware: if the call returns successfully,
 * `this` is treated as [FriendlyLastStandBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun LastStandBattle.asFriendlyLastStandBattle(): FriendlyLastStandBattle {
    contract {
        returns() implies (this@asFriendlyLastStandBattle is FriendlyLastStandBattle)
    }
    require(this is FriendlyLastStandBattle) {
        "Expected FriendlyLastStandBattle but found ${this::class.simpleName}"
    }
    return this
}

/**
 * Casts this Last Stand battle to an [EventLastStandBattle], throwing an [IllegalArgumentException]
 * if it is not competitive.
 *
 * This cast is contract-aware: if the call returns successfully,
 * `this` is treated as [EventLastStandBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun LastStandBattle.asEventLastStandBattle(): EventLastStandBattle {
    contract {
        returns() implies (this@asEventLastStandBattle is EventLastStandBattle)
    }
    require(this is EventLastStandBattle) {
        "Expected EventLastStandBattle but found ${this::class.simpleName}"
    }
    return this
}

/**
 * Casts this Classic Cooperative battle to a [FriendlyClassicCooperativeBattle], throwing an [IllegalArgumentException]
 * if it is not friendly.
 *
 * This cast is contract-aware: if the call returns successfully,
 * `this` is treated as [FriendlyClassicCooperativeBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun ClassicCooperativeBattle.asFriendlyClassicCooperativeBattle(): FriendlyClassicCooperativeBattle {
    contract {
        returns() implies (this@asFriendlyClassicCooperativeBattle is FriendlyClassicCooperativeBattle)
    }
    require(this is FriendlyClassicCooperativeBattle) {
        "Expected FriendlyClassicCooperativeBattle but found ${this::class.simpleName}"
    }
    return this
}

/**
 * Casts this Classic Cooperative battle to an [EventClassicCooperativeBattle], throwing an [IllegalArgumentException]
 * if it is not competitive.
 *
 * This cast is contract-aware: if the call returns successfully,
 * `this` is treated as [EventClassicCooperativeBattle].
 */
@OptIn(ExperimentalContracts::class)
public fun ClassicCooperativeBattle.asEventClassicCooperativeBattle(): EventClassicCooperativeBattle {
    contract {
        returns() implies (this@asEventClassicCooperativeBattle is EventClassicCooperativeBattle)
    }
    require(this is EventClassicCooperativeBattle) {
        "Expected EventClassicCooperativeBattle but found ${this::class.simpleName}"
    }
    return this
}
