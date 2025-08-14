package com.y9vad9.krawl.event

import kotlin.jvm.JvmInline

/**
 * Represents a specific gameplay modifier applied to a Brawl Stars event.
 *
 * Modifiers change the rules of a match by introducing unique mechanics or challenges.
 * Some modifiers are exclusive to special event types (e.g. Takedown, Boss Fight).
 *
 * @property raw Raw string representation used by the Brawl Stars API.
 */
@JvmInline
public value class EventModifier private constructor(public val raw: String) {
    public companion object {
        /** No modifier is applied to the event. */
        public val NONE: EventModifier = EventModifier("none")

        /** Periodic energy drinks spawn on the map and provide burst power. */
        public val ENERGY_DRINK: EventModifier = EventModifier("energyDrink")

        /** An angry Robo chases the nearest player. Common in Showdown variants. */
        public val ANGRY_ROBO: EventModifier = EventModifier("angryRobo")

        /** Meteors fall periodically from the sky, dealing heavy area damage. */
        public val METEOR_SHOWER: EventModifier = EventModifier("meteorShower")

        /** Players gradually lose health unless damaging enemies. */
        public val GRAVEYARD_SHIFT: EventModifier = EventModifier("graveyardShift")

        /** Healing mushrooms randomly spawn, restoring health to nearby players. */
        public val HEALING_MUSHROOMS: EventModifier = EventModifier("healingMushrooms")

        /** Rockets from Boss Fight mode rain down randomly across the map. */
        public val BOSS_FIGHT_ROCKETS: EventModifier = EventModifier("bossFightRockets")

        /** Takedown-specific laser attack. Hits multiple players. */
        public val TAKEDOWN_LASERS: EventModifier = EventModifier("takedownLasers")

        /** Takedown-specific modifier: chain lightning bounces between players. */
        public val TAKEDOWN_CHAIN_LIGHTNING: EventModifier = EventModifier("takedownChainLightning")

        /** Takedown-specific modifier: homing rockets strike players. */
        public val TAKEDOWN_ROCKETS: EventModifier = EventModifier("takedownRockets")

        /** Waves of enemies or hazards periodically appear. */
        public val WAVES: EventModifier = EventModifier("waves")

        /** In Brawl Ball, the ball behaves as if haunted, causing erratic movement. */
        public val HAUNTED_BALL: EventModifier = EventModifier("hauntedBall")

        /** Super meter charges faster for all players. */
        public val SUPER_CHARGE: EventModifier = EventModifier("superCharge")

        /** All brawlers move faster than normal. */
        public val FAST_BRAWLERS: EventModifier = EventModifier("fastBrawlers")

        /** The Showdown+ variant where points are gained/lost based on performance. */
        public val SHOWDOWN_PLUS: EventModifier = EventModifier("showdown+")

        /** Enemies within bushes are revealed briefly when nearby. */
        public val PEEK_A_BOO: EventModifier = EventModifier("peekABoo")

        /** Brawl Ball modifier where the ball burns players on contact. */
        public val BURNING_BALL: EventModifier = EventModifier("burningBall")
    }
}

/** Returns `true` if this modifier indicates no special gameplay changes.*/
public val EventModifier.isNone: Boolean
    get() = this == EventModifier.NONE

/** Returns `true` if this modifier causes periodic energy drinks to spawn on the map. */
public val EventModifier.isEnergyDrink: Boolean
    get() = this == EventModifier.ENERGY_DRINK

/** Returns `true` if this modifier causes an angry Robo to chase players. */
public val EventModifier.isAngryRobo: Boolean
    get() = this == EventModifier.ANGRY_ROBO

/** Returns `true` if this modifier causes meteors to fall periodically. */
public val EventModifier.isMeteorShower: Boolean
    get() = this == EventModifier.METEOR_SHOWER

/** Returns `true` if this modifier causes players to lose health gradually unless damaging enemies. */
public val EventModifier.isGraveyardShift: Boolean
    get() = this == EventModifier.GRAVEYARD_SHIFT

/** Returns `true` if this modifier spawns healing mushrooms that restore health. */
public val EventModifier.isHealingMushrooms: Boolean
    get() = this == EventModifier.HEALING_MUSHROOMS

/** Returns `true` if this modifier causes rockets to rain down as in Boss Fight mode. */
public val EventModifier.isBossFightRockets: Boolean
    get() = this == EventModifier.BOSS_FIGHT_ROCKETS

/** Returns `true` if this is the Takedown lasers attack modifier. */
public val EventModifier.isTakedownLasers: Boolean
    get() = this == EventModifier.TAKEDOWN_LASERS

/** Returns `true` if this is the Takedown chain lightning modifier. */
public val EventModifier.isTakedownChainLightning: Boolean
    get() = this == EventModifier.TAKEDOWN_CHAIN_LIGHTNING

/** Returns `true` if this is the Takedown homing rockets modifier. */
public val EventModifier.isTakedownRockets: Boolean
    get() = this == EventModifier.TAKEDOWN_ROCKETS

/** Returns `true` if this modifier causes waves of enemies or hazards to appear. */
public val EventModifier.isWaves: Boolean
    get() = this == EventModifier.WAVES

/** Returns `true` if this modifier makes the ball behave as haunted in Brawl Ball mode. */
public val EventModifier.isHauntedBall: Boolean
    get() = this == EventModifier.HAUNTED_BALL

/** Returns `true` if this modifier causes the super meter to charge faster. */
public val EventModifier.isSuperCharge: Boolean
    get() = this == EventModifier.SUPER_CHARGE

/** Returns `true` if this modifier makes all brawlers move faster than normal. */
public val EventModifier.isFastBrawlers: Boolean
    get() = this == EventModifier.FAST_BRAWLERS

/** Returns `true` if this modifier is the Showdown+ variant with performance-based scoring. */
public val EventModifier.isShowdownPlus: Boolean
    get() = this == EventModifier.SHOWDOWN_PLUS

/** Returns `true` if this modifier reveals enemies briefly when near bushes. */
public val EventModifier.isPeekABoo: Boolean
    get() = this == EventModifier.PEEK_A_BOO

/** Returns `true` if this modifier causes the ball to burn players on contact in Brawl Ball. */
public val EventModifier.isBurningBall: Boolean
    get() = this == EventModifier.BURNING_BALL
