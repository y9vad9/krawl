package com.y9vad9.brawlstars.types.event.value

import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.factory
import com.y9vad9.ktiny.kotlidator.rule.StringIsNotBlankRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
public value class EventMode private constructor(public val raw: String) : Comparable<EventMode> {
    public companion object : ValueFactory<EventMode, String> by factory(
        rules = listOf(StringIsNotBlankRule),
        constructor = ::EventMode,
    ) {
        public val BRAWL_BALL: EventMode = EventMode("brawlBall")
        public val SOLO_SHOWDOWN: EventMode = EventMode("soloShowdown")
        public val DUO_SHOWDOWN: EventMode = EventMode("duoShowdown")
        public val GEM_GRAB: EventMode = EventMode("gemGrab")
        public val HOT_ZONE: EventMode = EventMode("hotZone")
        public val DUELS: EventMode = EventMode("duels")
        public val KNOCKOUT: EventMode = EventMode("knockout")
        public val HEIST: EventMode = EventMode("heist")
        public val BOUNTY: EventMode = EventMode("bounty")
        public val SIEGE: EventMode = EventMode("siege")
        public val BIG_GAME: EventMode = EventMode("bigGame")
        public val BOSS_FIGHT: EventMode = EventMode("bossFight")
        public val ROBO_RUMBLE: EventMode = EventMode("roboRumble")
        public val TAKEDOWN: EventMode = EventMode("takedown")
        public val LONE_STAR: EventMode = EventMode("loneStar")
        public val PRESENT_PLUNDER: EventMode = EventMode("presentPlunder")
        public val SUPER_CITY_RAMPAGE: EventMode = EventMode("superCityRampage")
        public val VOLLEYBRAWL: EventMode = EventMode("volleyBrawl")
        public val BASKET_BRAWL: EventMode = EventMode("basketBrawl")
        public val HOLD_THE_TROPHY: EventMode = EventMode("holdTheTrophy")
        public val TROPHY_THIEVES: EventMode = EventMode("trophyThieves")
        public val WIPE_OUT: EventMode = EventMode("wipeout")
        public val PAYLOAD: EventMode = EventMode("payload")
        public val BOT_DROP: EventMode = EventMode("botDrop")
        public val HUNTERS: EventMode = EventMode("hunters")
        public val LAST_STAND: EventMode = EventMode("lastStand")
        public val SNOWTEL_THIEVES: EventMode = EventMode("snowtelThieves")
        public val PUMPKIN_PLUNDER: EventMode = EventMode("pumpkinPlunder")
        public val TROPHY_ESCAPE: EventMode = EventMode("trophyEscape")
        public val WIPE_OUT_5V5: EventMode = EventMode("wipeout5v5")
        public val KNOCKOUT_5V5: EventMode = EventMode("knockout5v5")
        public val GEM_GRAB_5V5: EventMode = EventMode("gemGrab5v5")
        public val BRAWL_BALL_5V5: EventMode = EventMode("brawlBall5v5")
        public val GODZILLA_CITY_SMASH: EventMode = EventMode("godzillaCitySmash")
        public val PAINT_BRAWL: EventMode = EventMode("paintBrawl")
        public val TRIO_SHOWDOWN: EventMode = EventMode("trioShowdown")
        public val ZOMBIE_PLUNDER: EventMode = EventMode("zombiePlunder")
        public val JELLY_FISHING: EventMode = EventMode("jellyfishing")
        public val SPIRIT_WARS: EventMode = EventMode("spiritWars")
        public val HOLIDAY_HAVOC: EventMode = EventMode("holidayHavoc")

        /**
         * This [EventMode] represents unknown yet for official Brawl Stars API event mode.
         */
        public val UNKNOWN: EventMode = EventMode("unknown")
    }

    override fun compareTo(other: EventMode): Int {
        return raw.lowercase().compareTo(other.raw.lowercase())
    }
}

public val EventMode.isShowdown: Boolean
    get() = this == EventMode.SOLO_SHOWDOWN || this == EventMode.DUO_SHOWDOWN || this == EventMode.TRIO_SHOWDOWN