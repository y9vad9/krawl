package com.y9vad9.krawl.event

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * Represents a Brawl Stars event context in battle logs.
 *
 * An event refers to the origin of the map and mode in a match:
 * - [OfficialEvent]: Played on an official Supercell map in a public queue.
 * - [MapMakerEvent]: Played on a community-created map, either in matchmaking
 *   (e.g., Candidates/Winners of the Day) or in a friendly room.
 *
 * These types appear in match metadata but may carry varying levels of detail,
 * depending on their source and API availability.
 */
public sealed interface Event

/**
 * Returns `true` if this [Event] is an [OfficialEvent], which represents a
 * standard match played on an official Supercell map.
 */
@OptIn(ExperimentalContracts::class)
public fun Event.isOfficial(): Boolean {
    contract {
        returns(true) implies (this@isOfficial is OfficialEvent)
    }
    return this is OfficialEvent
}

/**
 * Returns `true` if this [Event] is a [MapMakerEvent], which represents
 * a custom map event, either in matchmaking or a friendly room.
 */
@OptIn(ExperimentalContracts::class)
public fun Event.isMapMaker(): Boolean {
    contract {
        returns(true) implies (this@isMapMaker is MapMakerEvent)
    }
    return this is MapMakerEvent
}
