package com.y9vad9.krawl.event

/**
 * Represents a set of gameplay modifiers applied to a single Brawl Stars event.
 *
 * Some events may have multiple modifiers applied at once. This class wraps the
 * modifiers in a typed set to provide expressive utility operations.
 *
 * @property list The set of individual [EventModifier] instances applied.
 */
@JvmInline
public value class EventModifiers(public val list: Set<EventModifier>) {
    /**
     * Returns true if this event has at least one modifier applied.
     */
    public fun hasAny(): Boolean = list.isNotEmpty() || list.contains(EventModifier.NONE)

    /**
     * Returns true if the specified [modifier] is present in the modifier set.
     */
    public fun has(modifier: EventModifier): Boolean = list.contains(modifier)
}

/**
 * Returns true if this event has no modifiers applied.
 */
public val EventModifiers.isEmpty: Boolean get() = list.isEmpty()

/**
 * Returns true if this event has exactly one modifier.
 */
public val EventModifiers.isSingular: Boolean get() = list.size == 1

/**
 * Returns true if this event has multiple modifiers.
 */
public val EventModifiers.isComposite: Boolean get() = list.size > 1

/**
 * Returns true if the event has the [EventModifier.NONE] marker, which explicitly
 * indicates no gameplay-affecting modifiers are present.
 */
public val EventModifiers.explicitlyNone: Boolean
    get() = list.contains(EventModifier.NONE)

/**
 * Returns a human-readable list of modifier names for display or logging.
 */
public val EventModifiers.readableNames: List<String> get() = list.map { it.raw }

/**
 * Whether this event includes no modifiers.
 */
public val EventModifiers.hasNone: Boolean get() = has(EventModifier.NONE)

/**
 * Whether the Energy Drink modifier is active.
 */
public val EventModifiers.hasEnergyDrink: Boolean get() = has(EventModifier.ENERGY_DRINK)

/**
 * Whether the Angry Robo modifier is active.
 */
public val EventModifiers.hasAngryRobo: Boolean get() = has(EventModifier.ANGRY_ROBO)

/**
 * Whether the Meteor Shower modifier is active.
 */
public val EventModifiers.hasMeteorShower: Boolean get() = has(EventModifier.METEOR_SHOWER)

/**
 * Whether the Graveyard Shift modifier is active.
 */
public val EventModifiers.hasGraveyardShift: Boolean get() = has(EventModifier.GRAVEYARD_SHIFT)

/**
 * Whether the Healing Mushrooms modifier is active.
 */
public val EventModifiers.hasHealingMushrooms: Boolean get() = has(EventModifier.HEALING_MUSHROOMS)

/**
 * Whether the Boss Fight Rockets modifier is active.
 */
public val EventModifiers.hasBossFightRockets: Boolean get() = has(EventModifier.BOSS_FIGHT_ROCKETS)

/**
 * Whether the Takedown Lasers modifier is active.
 */
public val EventModifiers.hasTakedownLasers: Boolean get() = has(EventModifier.TAKEDOWN_LASERS)

/**
 * Whether the Takedown Chain Lightning modifier is active.
 */
public val EventModifiers.hasTakedownChainLightning: Boolean get() = has(EventModifier.TAKEDOWN_CHAIN_LIGHTNING)

/**
 * Whether the Takedown Rockets modifier is active.
 */
public val EventModifiers.hasTakedownRockets: Boolean get() = has(EventModifier.TAKEDOWN_ROCKETS)

/**
 * Whether the Waves modifier is active.
 */
public val EventModifiers.hasWaves: Boolean get() = has(EventModifier.WAVES)

/**
 * Whether the Haunted Ball modifier is active.
 */
public val EventModifiers.hasHauntedBall: Boolean get() = has(EventModifier.HAUNTED_BALL)

/**
 * Whether the Super Charge modifier is active.
 */
public val EventModifiers.hasSuperCharge: Boolean get() = has(EventModifier.SUPER_CHARGE)

/**
 * Whether the Fast Brawlers modifier is active.
 */
public val EventModifiers.hasFastBrawlers: Boolean get() = has(EventModifier.FAST_BRAWLERS)

/**
 * Whether the Showdown+ modifier is active.
 */
public val EventModifiers.hasShowdownPlus: Boolean get() = has(EventModifier.SHOWDOWN_PLUS)

/**
 * Whether the Peek-A-Boo modifier is active.
 */
public val EventModifiers.hasPeekABoo: Boolean get() = has(EventModifier.PEEK_A_BOO)

/**
 * Whether the Burning Ball modifier is active.
 */
public val EventModifiers.hasBurningBall: Boolean get() = has(EventModifier.BURNING_BALL)
