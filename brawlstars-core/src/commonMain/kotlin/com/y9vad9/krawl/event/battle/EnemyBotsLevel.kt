package com.y9vad9.krawl.event.battle

/**
 * Represents a specific difficulty level for the **Last Stand** game mode in Brawl Stars.
 *
 * A [EnemyBotsLevel] is composed of:
 * - A numeric [id] ([EnemyBotsLevelId]) — used internally to determine difficulty ordering.
 * - A human-readable [name] ([EnemyBotsLevelName]) — displayed in-game and in API responses.
 *
 * Difficulty levels progress in increasing order of challenge:
 * 1. Hard
 * 2. Expert
 * 3. Master
 * 4. Insane
 * 5. Insane II
 * 6. Insane III
 * 7. Insane IV
 *
 * This type pairs both the numeric and textual representations to allow for
 * consistent and type-safe handling of Last Stand levels in domain logic.
 *
 * @property id   The unique numeric identifier for this Last Stand difficulty level.
 * @property name The display name for this difficulty level, as shown in-game.
 */
public data class EnemyBotsLevel(
    public val id: EnemyBotsLevelId,
    public val name: EnemyBotsLevelName,
)

// --- Specific level checks ---

/** Returns `true` if this level is exactly [EnemyBotsLevelId.HARD]. */
public fun EnemyBotsLevel.isHard(): Boolean = id.isHard()

/** Returns `true` if this level is exactly [EnemyBotsLevelId.EXPERT]. */
public fun EnemyBotsLevel.isExpert(): Boolean = id.isExpert()

/** Returns `true` if this level is exactly [EnemyBotsLevelId.MASTER]. */
public fun EnemyBotsLevel.isMaster(): Boolean = id.isMaster()

/** Returns `true` if this level is exactly [EnemyBotsLevelId.INSANE]. */
public fun EnemyBotsLevel.isInsane(): Boolean = id.isInsane()

/** Returns `true` if this level is exactly [EnemyBotsLevelId.INSANE_2]. */
public fun EnemyBotsLevel.isInsane2(): Boolean = id.isInsane2()

/** Returns `true` if this level is exactly [EnemyBotsLevelId.INSANE_3]. */
public fun EnemyBotsLevel.isInsane3(): Boolean = id.isInsane3()

/** Returns `true` if this level is exactly [EnemyBotsLevelId.INSANE_4]. */
public fun EnemyBotsLevel.isInsane4(): Boolean = id.isInsane4()

// --- Tier / range checks ---

/**
 * Returns `true` if this level is at most **Expert** difficulty.
 *
 * This includes:
 * - Hard
 * - Expert
 */
public fun EnemyBotsLevel.isAtMostExpert(): Boolean = id.isAtMostExpert()

/**
 * Returns `true` if this level is at least **Master** difficulty.
 *
 * This includes:
 * - Master
 * - Insane
 * - Insane II
 * - Insane III
 * - Insane IV
 */
public fun EnemyBotsLevel.isAtLeastMaster(): Boolean = id.isAtLeastMaster()

/**
 * Returns `true` if this level is at least **Insane** difficulty.
 *
 * This includes:
 * - Insane
 * - Insane II
 * - Insane III
 * - Insane IV
 */
public fun EnemyBotsLevel.isAtLeastInsane(): Boolean = id.isAtLeastInsane()

/**
 * Returns `true` if this level is in the **Insane tier**.
 *
 * This tier includes:
 * - Insane
 * - Insane II
 * - Insane III
 * - Insane IV
 */
public fun EnemyBotsLevel.isInsaneTier(): Boolean = id.isInsaneTier()
