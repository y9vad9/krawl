package com.y9vad9.krawl.brawler

import com.y9vad9.krawl.brawler.BrawlerId.Companion.MAX_VALUE
import com.y9vad9.krawl.brawler.BrawlerId.Companion.MIN_VALUE
import com.y9vad9.krawl.brawler.BrawlerId.Companion.create
import com.y9vad9.krawl.brawler.BrawlerId.Companion.createOrNull
import com.y9vad9.krawl.brawler.BrawlerId.Companion.createOrThrow

/**
 * Represents a unique identifier for a Brawler in Brawl Stars.
 *
 * This class wraps an integer ID that identifies a specific brawler.
 * Valid IDs fall within a predefined range ([MIN_VALUE] to [MAX_VALUE]).
 * Sorting by [BrawlerId] compares the underlying integer values.
 *
 * Use [create], [createOrNull], or [createOrThrow] to safely construct a [BrawlerId] instance.
 */
@JvmInline
public value class BrawlerId private constructor(
    /** The underlying integer value of the brawler ID. */
    public val int: Int,
) : Comparable<BrawlerId> {

    /** Constants with constraints and validation */
    public companion object {
        /** Minimum valid value for a brawler ID. */
        public const val MIN_VALUE: Int = 16_000_000

        /** Maximum valid value for a brawler ID. */
        public const val MAX_VALUE: Int = 16_000_500

        /** Valid range of brawler ID values. */
        public val VALUE_RANGE: IntRange = MIN_VALUE..MAX_VALUE

        /**
         * Returns `true` if the given [input] is within the valid brawler ID range.
         *
         * This function performs a sanity check to ensure [input] falls within
         * the expected ID range for brawlers.
         */
        public fun isValid(input: Int): Boolean =
            input in VALUE_RANGE

        /**
         * Attempts to create a [BrawlerId] from the given [input].
         *
         * Returns a [Result.success] containing a valid [BrawlerId], or
         * a [Result.failure] with an [IllegalArgumentException] if [input] is invalid.
         */
        public fun create(input: Int): Result<BrawlerId> =
            if (isValid(input)) Result.success(BrawlerId(input))
            else Result.failure(IllegalArgumentException("Invalid brawler ID: $input"))

        /**
         * Creates a [BrawlerId] from [input] or throws [IllegalArgumentException] if invalid.
         */
        public fun createOrThrow(input: Int): BrawlerId =
            create(input).getOrThrow()

        /**
         * Creates a [BrawlerId] from [input], or returns `null` if invalid.
         */
        public fun createOrNull(input: Int): BrawlerId? =
            create(input).getOrNull()

        /**
         * Constant for Brawler ID representing Shelly.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Shelly)**
         */
        public val SHELLY: BrawlerId = BrawlerId(16_000_000)

        /**
         * Constant for Brawler ID representing Colt.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Colt)**
         */
        public val COLT: BrawlerId = BrawlerId(16_000_001)

        /**
         * Constant for Brawler ID representing Bull.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Bull)**
         */
        public val BULL: BrawlerId = BrawlerId(16_000_002)

        /**
         * Constant for Brawler ID representing Brock.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Brock)**
         */
        public val BROCK: BrawlerId = BrawlerId(16_000_003)

        /**
         * Constant for Brawler ID representing Rico.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Rico)**
         */
        public val RICO: BrawlerId = BrawlerId(16_000_004)

        /**
         * Constant for Brawler ID representing Spike.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Spike)**
         */
        public val SPIKE: BrawlerId = BrawlerId(16_000_005)

        /**
         * Constant for Brawler ID representing Barley.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Barley)**
         */
        public val BARLEY: BrawlerId = BrawlerId(16_000_006)

        /**
         * Constant for Brawler ID representing Jessie.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Jessie)**
         */
        public val JESSIE: BrawlerId = BrawlerId(16_000_007)

        /**
         * Constant for Brawler ID representing Nita.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Nita)**
         */
        public val NITA: BrawlerId = BrawlerId(16_000_008)

        /**
         * Constant for Brawler ID representing Dynamike.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Dynamike)**
         */
        public val DYNAMIKE: BrawlerId = BrawlerId(16_000_009)

        /**
         * Constant for Brawler ID representing El Primo.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/El-Primo)**
         */
        public val EL_PRIMO: BrawlerId = BrawlerId(16_000_010)

        /**
         * Constant for Brawler ID representing Mortis.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Mortis)**
         */
        public val MORTIS: BrawlerId = BrawlerId(16_000_011)

        /**
         * Constant for Brawler ID representing Crow.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Crow)**
         */
        public val CROW: BrawlerId = BrawlerId(16_000_012)

        /**
         * Constant for Brawler ID representing Poco.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Poco)**
         */
        public val POCO: BrawlerId = BrawlerId(16_000_013)

        /**
         * Constant for Brawler ID representing Bo.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Bo)**
         */
        public val BO: BrawlerId = BrawlerId(16_000_014)

        /**
         * Constant for Brawler ID representing Piper.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Piper)**
         */
        public val PIPER: BrawlerId = BrawlerId(16_000_015)

        /**
         * Constant for Brawler ID representing Pam.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Pam)**
         */
        public val PAM: BrawlerId = BrawlerId(16_000_016)

        /**
         * Constant for Brawler ID representing Tara.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Tara)**
         */
        public val TARA: BrawlerId = BrawlerId(16_000_017)

        /**
         * Constant for Brawler ID representing Darryl.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Darryl)**
         */
        public val DARRYL: BrawlerId = BrawlerId(16_000_018)

        /**
         * Constant for Brawler ID representing Penny.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Penny)**
         */
        public val PENNY: BrawlerId = BrawlerId(16_000_019)

        /**
         * Constant for Brawler ID representing Frank.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Frank)**
         */
        public val FRANK: BrawlerId = BrawlerId(16_000_020)

        /**
         * Constant for Brawler ID representing Gene.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Gene)**
         */
        public val GENE: BrawlerId = BrawlerId(16_000_021)

        /**
         * Constant for Brawler ID representing Tick.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Tick)**
         */
        public val TICK: BrawlerId = BrawlerId(16_000_022)

        /**
         * Constant for Brawler ID representing Leon.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Leon)**
         */
        public val LEON: BrawlerId = BrawlerId(16_000_023)

        /**
         * Constant for Brawler ID representing Rosa.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Rosa)**
         */
        public val ROSA: BrawlerId = BrawlerId(16_000_024)

        /**
         * Constant for Brawler ID representing Carl.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Carl)**
         */
        public val CARL: BrawlerId = BrawlerId(16_000_025)

        /**
         * Constant for Brawler ID representing Bibi.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Bibi)**
         */
        public val BIBI: BrawlerId = BrawlerId(16_000_026)

        /**
         * Constant for Brawler ID representing 8-Bit.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/8-Bit)**
         */
        public val EIGHT_BIT: BrawlerId = BrawlerId(16_000_027)

        /**
         * Constant for Brawler ID representing Sandy.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Sandy)**
         */
        public val SANDY: BrawlerId = BrawlerId(16_000_028)

        /**
         * Constant for Brawler ID representing Bea.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Bea)**
         */
        public val BEA: BrawlerId = BrawlerId(16_000_029)

        /**
         * Constant for Brawler ID representing Emz.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Emz)**
         */
        public val EMZ: BrawlerId = BrawlerId(16_000_030)

        /**
         * Constant for Brawler ID representing Mr. P.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Mr-P)**
         */
        public val MR_P: BrawlerId = BrawlerId(16_000_031)

        /**
         * Constant for Brawler ID representing Max.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Max)**
         */
        public val MAX: BrawlerId = BrawlerId(16_000_032)

        /**
         * Constant for Brawler ID representing Jacky.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Jacky)**
         */
        public val JACKY: BrawlerId = BrawlerId(16_000_034)

        /**
         * Constant for Brawler ID representing Gale.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Gale)**
         */
        public val GALE: BrawlerId = BrawlerId(16_000_035)

        /**
         * Constant for Brawler ID representing Nani.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Nani)**
         */
        public val NANI: BrawlerId = BrawlerId(16_000_036)

        /**
         * Constant for Brawler ID representing Sprout.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Sprout)**
         */
        public val SPROUT: BrawlerId = BrawlerId(16_000_037)

        /**
         * Constant for Brawler ID representing Surge.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Surge)**
         */
        public val SURGE: BrawlerId = BrawlerId(16_000_038)

        /**
         * Constant for Brawler ID representing Colette.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Colette)**
         */
        public val COLETTE: BrawlerId = BrawlerId(16_000_039)

        /**
         * Constant for Brawler ID representing Amber.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Amber)**
         */
        public val AMBER: BrawlerId = BrawlerId(16_000_040)

        /**
         * Constant for Brawler ID representing Lou.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Lou)**
         */
        public val LOU: BrawlerId = BrawlerId(16_000_041)

        /**
         * Constant for Brawler ID representing Byron.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Byron)**
         */
        public val BYRON: BrawlerId = BrawlerId(16_000_042)

        /**
         * Constant for Brawler ID representing Edgar.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Edgar)**
         */
        public val EDGAR: BrawlerId = BrawlerId(16_000_043)

        /**
         * Constant for Brawler ID representing Ruffs.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Ruffs)**
         */
        public val RUFFS: BrawlerId = BrawlerId(16_000_044)

        /**
         * Constant for Brawler ID representing Stu.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Stu)**
         */
        public val STU: BrawlerId = BrawlerId(16_000_045)

        /**
         * Constant for Brawler ID representing Belle.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Belle)**
         */
        public val BELLE: BrawlerId = BrawlerId(16_000_046)

        /**
         * Constant for Brawler ID representing Squeak.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Squeak)**
         */
        public val SQUEAK: BrawlerId = BrawlerId(16_000_047)

        /**
         * Constant for Brawler ID representing Grom.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Grom)**
         */
        public val GROM: BrawlerId = BrawlerId(16_000_048)

        /**
         * Constant for Brawler ID representing Buzz.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Buzz)**
         */
        public val BUZZ: BrawlerId = BrawlerId(16_000_049)

        /**
         * Constant for Brawler ID representing Griff.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Griff)**
         */
        public val GRIFF: BrawlerId = BrawlerId(16_000_050)

        /**
         * Constant for Brawler ID representing Ash.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Ash)**
         */
        public val ASH: BrawlerId = BrawlerId(16_000_051)

        /**
         * Constant for Brawler ID representing Meg.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Meg)**
         */
        public val MEG: BrawlerId = BrawlerId(16_000_052)

        /**
         * Constant for Brawler ID representing Lola.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Lola)**
         */
        public val LOLA: BrawlerId = BrawlerId(16_000_053)

        /**
         * Constant for Brawler ID representing Fang.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Fang)**
         */
        public val FANG: BrawlerId = BrawlerId(16_000_054)

        /**
         * Constant for Brawler ID representing Eve.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Eve)**
         */
        public val EVE: BrawlerId = BrawlerId(16_000_056)

        /**
         * Constant for Brawler ID representing Janet.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Janet)**
         */
        public val JANET: BrawlerId = BrawlerId(16_000_057)

        /**
         * Constant for Brawler ID representing Bonnie.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Bonnie)**
         */
        public val BONNIE: BrawlerId = BrawlerId(16_000_058)

        /**
         * Constant for Brawler ID representing Otis.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Otis)**
         */
        public val OTIS: BrawlerId = BrawlerId(16_000_059)

        /**
         * Constant for Brawler ID representing Sam.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Sam)**
         */
        public val SAM: BrawlerId = BrawlerId(16_000_060)

        /**
         * Constant for Brawler ID representing Gus.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Gus)**
         */
        public val GUS: BrawlerId = BrawlerId(16_000_061)

        /**
         * Constant for Brawler ID representing Buster.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Buster)**
         */
        public val BUSTER: BrawlerId = BrawlerId(16_000_062)

        /**
         * Constant for Brawler ID representing Chester.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Chester)**
         */
        public val CHESTER: BrawlerId = BrawlerId(16_000_063)

        /**
         * Constant for Brawler ID representing Gray.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Gray)**
         */
        public val GRAY: BrawlerId = BrawlerId(16_000_064)

        /**
         * Constant for Brawler ID representing Mandy.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Mandy)**
         */
        public val MANDY: BrawlerId = BrawlerId(16_000_065)

        /**
         * Constant for Brawler ID representing R-T.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/R-T)**
         */
        public val R_T: BrawlerId = BrawlerId(16_000_066)

        /**
         * Constant for Brawler ID representing Willow.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Willow)**
         */
        public val WILLOW: BrawlerId = BrawlerId(16_000_067)

        /**
         * Constant for Brawler ID representing Maisie.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Maisie)**
         */
        public val MAISIE: BrawlerId = BrawlerId(16_000_068)

        /**
         * Constant for Brawler ID representing Hank.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Hank)**
         */
        public val HANK: BrawlerId = BrawlerId(16_000_069)

        /**
         * Constant for Brawler ID representing Cordelius.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Cordelius)**
         */
        public val CORDELIUS: BrawlerId = BrawlerId(16_000_070)

        /**
         * Constant for Brawler ID representing Doug.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Doug)**
         */
        public val DOUG: BrawlerId = BrawlerId(16_000_071)

        /**
         * Constant for Brawler ID representing Pearl.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Pearl)**
         */
        public val PEARL: BrawlerId = BrawlerId(16_000_072)

        /**
         * Constant for Brawler ID representing Chuck.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Chuck)**
         */
        public val CHUCK: BrawlerId = BrawlerId(16_000_073)

        /**
         * Constant for Brawler ID representing Charlie.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Charlie)**
         */
        public val CHARLIE: BrawlerId = BrawlerId(16_000_074)

        /**
         * Constant for Brawler ID representing Mico.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Mico)**
         */
        public val MICO: BrawlerId = BrawlerId(16_000_075)

        /**
         * Constant for Brawler ID representing Kit.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Kit)**
         */
        public val KIT: BrawlerId = BrawlerId(16_000_076)

        /**
         * Constant for Brawler ID representing Larry & Lawrie.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Larry-&-Lawrie)**
         */
        public val LARRY_AND_LAWRIE: BrawlerId = BrawlerId(16_000_077)

        /**
         * Constant for Brawler ID representing Melodie.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Melodie)**
         */
        public val MELODIE: BrawlerId = BrawlerId(16_000_078)

        /**
         * Constant for Brawler ID representing Angelo.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Angelo)**
         */
        public val ANGELO: BrawlerId = BrawlerId(16_000_079)

        /**
         * Constant for Brawler ID representing Draco.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Draco)**
         */
        public val DRACO: BrawlerId = BrawlerId(16_000_080)

        /**
         * Constant for Brawler ID representing Lily.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Lily)**
         */
        public val LILY: BrawlerId = BrawlerId(16_000_081)

        /**
         * Constant for Brawler ID representing Berry.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Berry)**
         */
        public val BERRY: BrawlerId = BrawlerId(16_000_082)

        /**
         * Constant for Brawler ID representing Clancy.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Clancy)**
         */
        public val CLANCY: BrawlerId = BrawlerId(16_000_083)

        /**
         * Constant for Brawler ID representing Moe.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Moe)**
         */
        public val MOE: BrawlerId = BrawlerId(16_000_084)

        /**
         * Constant for Brawler ID representing Kenji.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Kenji)**
         */
        public val KENJI: BrawlerId = BrawlerId(16_000_085)

        /**
         * Constant for Brawler ID representing Shade.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Shade)**
         */
        public val SHADE: BrawlerId = BrawlerId(16_000_086)

        /**
         * Constant for Brawler ID representing Juju.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Juju)**
         */
        public val JUJU: BrawlerId = BrawlerId(16_000_087)

        /**
         * Constant for Brawler ID representing Buzz Lightyear.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Buzz-Lightyear)**
         */
        public val BUZZ_LIGHTYEAR: BrawlerId = BrawlerId(16_000_088)

        /**
         * Constant for Brawler ID representing Meeple.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Meeple)**
         */
        public val MEEPLE: BrawlerId = BrawlerId(16_000_089)

        /**
         * Constant for Brawler ID representing Ollie.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Ollie)**
         */
        public val OLLIE: BrawlerId = BrawlerId(16_000_090)

        /**
         * Constant for Brawler ID representing Lumi.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Lumi)**
         */
        public val LUMI: BrawlerId = BrawlerId(16_000_091)

        /**
         * Constant for Brawler ID representing Finx.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Finx)**
         */
        public val FINX: BrawlerId = BrawlerId(16_000_092)

        /**
         * Constant for Brawler ID representing Jae-Yong.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Jae-Yong)**
         */
        public val JAE_YONG: BrawlerId = BrawlerId(16_000_093)

        /**
         * Constant for Brawler ID representing Kaze.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Kaze)**
         */
        public val KAZE: BrawlerId = BrawlerId(16_000_094)

        /**
         * Constant for Brawler ID representing Alli.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Alli)**
         */
        public val ALLI: BrawlerId = BrawlerId(16_000_095)

        /**
         * Constant for Brawler ID representing Trunk.
         * **[Learn more about Brawler on Brawlify](https://brawlify.com/brawlers/detail/Trunk)**
         */
        public val TRUNK: BrawlerId = BrawlerId(16_000_096)
    }

    /**
     * Compares this [BrawlerId] with another based on their integer values.
     *
     * @param other The other [BrawlerId] to compare against.
     * @return A negative integer, zero, or a positive integer as this ID
     * is less than, equal to, or greater than the other ID.
     */
    override fun compareTo(other: BrawlerId): Int = int.compareTo(other.int)
}
