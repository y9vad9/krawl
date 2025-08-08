package com.y9vad9.krawl.event

/**
 * Represents a map maker event in both matchmaking and friendly rooms.
 *
 * This includes:
 * - Candidates of the Day / Winners of the Day (public matchmaking)
 * - Friendly matches using custom community maps
 *
 * The Brawl Stars API provides no reliable metadata for these events,
 * so this type carries no additional information.
 */
public data object MapMakerEvent : Event
