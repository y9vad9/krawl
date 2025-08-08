package com.y9vad9.krawl.player

/**
 * Represents the account-wide experience status of a Brawl Stars player,
 * including both raw experience points and their corresponding experience level.
 *
 * This data is visible on a player’s profile and reflects their long-term playtime
 * and engagement, but does not impact matchmaking, progression speed, or gameplay power.
 *
 * @property points The total number of experience points the player has earned.
 * These are accumulated by completing battles and contribute to level-ups.
 * See [PlayerExpPoints] for details.
 *
 * @property level The current experience level of the player, derived from [points].
 * Higher levels may unlock profile icons or cosmetic rewards. See [PlayerExpLevel].
 *
 * @see <a href="https://brawlstars.fandom.com/wiki/Experience">Brawl Stars Wiki: Experience</a>
 */
public data class PlayerExperience(
    public val points: PlayerExpPoints,
    public val level: PlayerExpLevel,
)
