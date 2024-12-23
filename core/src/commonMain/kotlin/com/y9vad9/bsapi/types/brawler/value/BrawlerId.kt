package com.y9vad9.bsapi.types.brawler.value

import com.y9vad9.bsapi.types.ValueConstructor
import com.y9vad9.bsapi.types.brawler.value.BrawlerId.Companion
import com.y9vad9.bsapi.types.exception.CreationFailure
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * Brawler's unique identifier. For predefined constants, please refer to [Companion].
 * Sorting mechanism based on this class will return brawlers from newest to oldest and vice-versa.
 */
@Serializable
@JvmInline
public value class BrawlerId private constructor(public val value: Int) : Comparable<BrawlerId> {
    public companion object : ValueConstructor<BrawlerId, Int> {
        public val SHELLY: BrawlerId = BrawlerId(16000000)
        public val COLT: BrawlerId = BrawlerId(16000001)
        public val BULL: BrawlerId = BrawlerId(16000002)
        public val BROCK: BrawlerId = BrawlerId(16000003)
        public val RICO: BrawlerId = BrawlerId(16000004)
        public val SPIKE: BrawlerId = BrawlerId(16000005)
        public val BARLEY: BrawlerId = BrawlerId(16000006)
        public val JESSIE: BrawlerId = BrawlerId(16000007)
        public val NITA: BrawlerId = BrawlerId(16000008)
        public val DYNAMIKE: BrawlerId = BrawlerId(16000009)
        public val EL_PRIMO: BrawlerId = BrawlerId(16000010)
        public val MORTIS: BrawlerId = BrawlerId(16000011)
        public val CROW: BrawlerId = BrawlerId(16000012)
        public val POCO: BrawlerId = BrawlerId(16000013)
        public val BO: BrawlerId = BrawlerId(16000014)
        public val PIPER: BrawlerId = BrawlerId(16000015)
        public val PAM: BrawlerId = BrawlerId(16000016)
        public val TARA: BrawlerId = BrawlerId(16000017)
        public val DARRYL: BrawlerId = BrawlerId(16000018)
        public val PENNY: BrawlerId = BrawlerId(16000019)
        public val FRANK: BrawlerId = BrawlerId(16000020)
        public val GENE: BrawlerId = BrawlerId(16000021)
        public val TICK: BrawlerId = BrawlerId(16000022)
        public val LEON: BrawlerId = BrawlerId(16000023)
        public val ROSA: BrawlerId = BrawlerId(16000024)
        public val CARL: BrawlerId = BrawlerId(16000025)
        public val BIBI: BrawlerId = BrawlerId(16000026)
        public val EIGHT_BIT: BrawlerId = BrawlerId(16000027)
        public val SANDY: BrawlerId = BrawlerId(16000028)
        public val BEA: BrawlerId = BrawlerId(16000029)
        public val EMZ: BrawlerId = BrawlerId(16000030)
        public val MR_P: BrawlerId = BrawlerId(16000031)
        public val MAX: BrawlerId = BrawlerId(16000032)
        public val JACKY: BrawlerId = BrawlerId(16000034)
        public val GALE: BrawlerId = BrawlerId(16000035)
        public val NANI: BrawlerId = BrawlerId(16000036)
        public val SPROUT: BrawlerId = BrawlerId(16000037)
        public val SURGE: BrawlerId = BrawlerId(16000038)
        public val COLETTE: BrawlerId = BrawlerId(16000039)
        public val AMBER: BrawlerId = BrawlerId(16000040)
        public val LOU: BrawlerId = BrawlerId(16000041)
        public val BYRON: BrawlerId = BrawlerId(16000042)
        public val EDGAR: BrawlerId = BrawlerId(16000043)
        public val RUFFS: BrawlerId = BrawlerId(16000044)
        public val STU: BrawlerId = BrawlerId(16000045)
        public val BELLE: BrawlerId = BrawlerId(16000046)
        public val SQUEAK: BrawlerId = BrawlerId(16000047)
        public val GROM: BrawlerId = BrawlerId(16000048)
        public val BUZZ: BrawlerId = BrawlerId(16000049)
        public val GRIFF: BrawlerId = BrawlerId(16000050)
        public val ASH: BrawlerId = BrawlerId(16000051)
        public val MEG: BrawlerId = BrawlerId(16000052)
        public val LOLA: BrawlerId = BrawlerId(16000053)
        public val FANG: BrawlerId = BrawlerId(16000054)
        public val EVE: BrawlerId = BrawlerId(16000056)
        public val JANET: BrawlerId = BrawlerId(16000057)
        public val BONNIE: BrawlerId = BrawlerId(16000058)
        public val OTIS: BrawlerId = BrawlerId(16000059)
        public val SAM: BrawlerId = BrawlerId(16000060)
        public val GUS: BrawlerId = BrawlerId(16000061)
        public val BUSTER: BrawlerId = BrawlerId(16000062)
        public val CHESTER: BrawlerId = BrawlerId(16000063)
        public val GRAY: BrawlerId = BrawlerId(16000064)
        public val MANDY: BrawlerId = BrawlerId(16000065)
        public val RT: BrawlerId = BrawlerId(16000066)
        public val WILLOW: BrawlerId = BrawlerId(16000067)
        public val MAISIE: BrawlerId = BrawlerId(16000068)
        public val HANK: BrawlerId = BrawlerId(16000069)
        public val CORDELIUS: BrawlerId = BrawlerId(16000070)
        public val DOUG: BrawlerId = BrawlerId(16000071)
        public val PEARL: BrawlerId = BrawlerId(16000072)
        public val CHUCK: BrawlerId = BrawlerId(16000073)
        public val CHARLIE: BrawlerId = BrawlerId(16000074)
        public val MICO: BrawlerId = BrawlerId(16000075)
        public val KIT: BrawlerId = BrawlerId(16000076)
        public val LARRY_AND_LAWRIE: BrawlerId = BrawlerId(16000077)
        public val MELODIE: BrawlerId = BrawlerId(16000078)
        public val ANGELO: BrawlerId = BrawlerId(16000079)
        public val DRACO: BrawlerId = BrawlerId(16000080)
        public val LILY: BrawlerId = BrawlerId(16000081)
        public val BERRY: BrawlerId = BrawlerId(16000082)
        public val CLANCY: BrawlerId = BrawlerId(16000083)
        public val MOE: BrawlerId = BrawlerId(16000084)
        public val KENJI: BrawlerId = BrawlerId(16000085)
        public val SHADE: BrawlerId = BrawlerId(16000086)
        public val JUJU: BrawlerId = BrawlerId(16000087)
        public val MEEPLE: BrawlerId = BrawlerId(16000089)
        public val OLLIE: BrawlerId = BrawlerId(16000090)

        override fun create(value: Int): Result<BrawlerId> {
            if (value < 16000000)
                return Result.failure(CreationFailure.MinValueFailure(16000000))
            return Result.success(BrawlerId(value))
        }
    }

    override fun compareTo(other: BrawlerId): Int {
        return value.compareTo(other.value)
    }
}