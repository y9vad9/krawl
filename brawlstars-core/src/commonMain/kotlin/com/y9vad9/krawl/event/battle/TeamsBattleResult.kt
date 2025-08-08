package com.y9vad9.krawl.event.battle

/**
 * Represents the result of a team-based battle in Brawl Stars.
 *
 * This enum distinguishes between the three possible outcomes a team can experience:
 * - [VICTORY]: The team won the match.
 * - [DRAW]: The match ended with no winner or loser.
 * - [DEFEAT]: The team lost the match.
 */
public enum class TeamsBattleResult {
    /** The team successfully won the battle. */
    VICTORY,

    /** The battle ended without a winner or loser. */
    DRAW,

    /** The team lost the battle. */
    DEFEAT,
}
