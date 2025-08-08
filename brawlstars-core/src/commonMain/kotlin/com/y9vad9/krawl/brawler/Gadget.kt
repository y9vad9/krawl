package com.y9vad9.krawl.brawler

/**
 * Represents a Gadget in Brawl Stars.
 *
 * A Gadget is a special item that brawlers can equip to gain unique abilities
 * during battles. Each gadget is identified by a unique [id] and has a
 * human-readable [name].
 *
 * @property id The unique identifier of the gadget.
 * @property name The display name of the gadget.
 */
public data class Gadget(
    /**
     * The unique identifier for this gadget.
     */
    public val id: GadgetId,

    /**
     * The name of this gadget, as shown in-game.
     */
    public val name: GearName,
)
