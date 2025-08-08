package com.y9vad9.krawl.player

import com.y9vad9.krawl.brawler.Brawlers
import com.y9vad9.krawl.common.PlayerNameColor

/**
 * Represents a player in Brawl Stars, including their metadata, progression, and roster.
 *
 * This class models the top-level state of a player, capturing identity, progression,
 * challenge status, club affiliation, and their owned brawlers.
 *
 * @property tag The unique player identifier (e.g., "#ABCD1234").
 * @property name The display name of the player.
 * @property nameColor Color in the HEX format that is used for [name].
 * @property progression Overall progression details such as total trophies, experience, etc.
 * @property championship The player's status in the Championship Challenge.
 * @property records Personal bests and time-based statistics for special game modes.
 * @property club Information about the club the player belongs to.
 * @property brawlers The full set of brawlers owned by the player with their equipment and progression.
 */
public data class Player(
    public val tag: PlayerTag,
    public val name: PlayerName,
    public val nameColor: PlayerNameColor,
    public val progression: PlayerProgression,
    public val championship: PlayerChampionshipQualification,
    public val records: PlayerRecords,
    public val club: PlayerClub,
    public val brawlers: Brawlers,
)
