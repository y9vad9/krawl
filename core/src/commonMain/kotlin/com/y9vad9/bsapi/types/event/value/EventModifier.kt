package com.y9vad9.bsapi.types.event.value

import com.y9vad9.bsapi.types.ValueConstructor
import kotlinx.serialization.Serializable

@JvmInline
@Serializable
public value class EventModifier private constructor(public val raw: String) {
    public companion object : ValueConstructor<EventModifier, String> {
        public val NONE: EventModifier = EventModifier("none")
        public val ENERGY_DRINK: EventModifier = EventModifier("energyDrink")
        public val ANGRY_ROBO: EventModifier = EventModifier("angryRobo")
        public val METEOR_SHOWER: EventModifier = EventModifier("meteorShower")
        public val GRAVEYARD_SHIFT: EventModifier = EventModifier("graveyardShift")
        public val HEALING_MUSHROOMS: EventModifier = EventModifier("healingMushrooms")
        public val BOSS_FIGHT_ROCKETS: EventModifier = EventModifier("bossFightRockets")
        public val TAKEDOWN_LASERS: EventModifier = EventModifier("takedownLasers")
        public val TAKEDOWN_CHAIN_LIGHTNING: EventModifier = EventModifier("takedownChainLightning")
        public val TAKEDOWN_ROCKETS: EventModifier = EventModifier("takedownRockets")
        public val WAVES: EventModifier = EventModifier("waves")
        public val HAUNTED_BALL: EventModifier = EventModifier("hauntedBall")
        public val SUPER_CHARGE: EventModifier = EventModifier("superCharge")
        public val FAST_BRAWLERS: EventModifier = EventModifier("fastBrawlers")
        public val SHOWDOWN_PLUS: EventModifier = EventModifier("showdown+")
        public val PEEK_A_BOO: EventModifier = EventModifier("peekABoo")
        public val BURNING_BALL: EventModifier = EventModifier("burningBall")

        override fun create(value: String): Result<EventModifier> {
            return Result.success(EventModifier(value))
        }
    }
}