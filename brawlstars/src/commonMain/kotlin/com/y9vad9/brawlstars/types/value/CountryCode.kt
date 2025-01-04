package com.y9vad9.brawlstars.types.value

import com.y9vad9.ktiny.kotlidator.ValidationException
import com.y9vad9.ktiny.kotlidator.ValueFactory
import com.y9vad9.ktiny.kotlidator.rule.StringLengthRangeValidationRule
import com.y9vad9.ktiny.kotlidator.rule.StringLengthValidationRule
import com.y9vad9.ktiny.kotlidator.rule.ValidationRule
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class CountryCode private constructor(public val value: String) {
    public companion object : ValueFactory<CountryCode, String> {
        override val rules: List<ValidationRule<String>> = listOf(
            StringLengthRangeValidationRule(2..6)
        )

        public const val REQUIRED_SIZE: Int = 2

        /**
         * Used to provide information about global instead of localized information.
         */
        public val GLOBAL: CountryCode = CountryCode("global")

        public val UKRAINE: CountryCode = CountryCode("UA")
        public val GERMANY: CountryCode = CountryCode("DE")
        public val CZECH_REPUBLIC: CountryCode = CountryCode("CZ")
        public val SLOVAKIA: CountryCode = CountryCode("SK")
        public val AUSTRIA: CountryCode = CountryCode("AT")
        public val USA: CountryCode = CountryCode("US")
        public val CANADA: CountryCode = CountryCode("CA")
        public val BRAZIL: CountryCode = CountryCode("BR")
        public val MEXICO: CountryCode = CountryCode("MX")
        public val JAPAN: CountryCode = CountryCode("JP")
        public val SOUTH_KOREA: CountryCode = CountryCode("KR")
        public val INDIA: CountryCode = CountryCode("IN")
        public val INDONESIA: CountryCode = CountryCode("ID")
        public val PHILIPPINES: CountryCode = CountryCode("PH")
        public val THAILAND: CountryCode = CountryCode("TH")
        public val VIETNAM: CountryCode = CountryCode("VN")
        public val TURKEY: CountryCode = CountryCode("TR")
        public val FRANCE: CountryCode = CountryCode("FR")
        public val ITALY: CountryCode = CountryCode("IT")
        public val SPAIN: CountryCode = CountryCode("ES")
        public val POLAND: CountryCode = CountryCode("PL")
        public val NETHERLANDS: CountryCode = CountryCode("NL")
        public val BELGIUM: CountryCode = CountryCode("BE")
        public val SWEDEN: CountryCode = CountryCode("SE")
        public val NORWAY: CountryCode = CountryCode("NO")
        public val DENMARK: CountryCode = CountryCode("DK")
        public val FINLAND: CountryCode = CountryCode("FI")
        public val AUSTRALIA: CountryCode = CountryCode("AU")
        public val NEW_ZEALAND: CountryCode = CountryCode("NZ")
        public val ARGENTINA: CountryCode = CountryCode("AR")
        public val CHILE: CountryCode = CountryCode("CL")
        public val COLOMBIA: CountryCode = CountryCode("CO")
        public val PERU: CountryCode = CountryCode("PE")
        public val EGYPT: CountryCode = CountryCode("EG")
        public val SAUDI_ARABIA: CountryCode = CountryCode("SA")
        public val UNITED_ARAB_EMIRATES: CountryCode = CountryCode("AE")
        public val ISRAEL: CountryCode = CountryCode("IL")
        public val SINGAPORE: CountryCode = CountryCode("SG")
        public val MALAYSIA: CountryCode = CountryCode("MY")

        override fun create(value: String): Result<CountryCode> {
            return when {
                value == GLOBAL.value -> Result.success(GLOBAL)
                value.length == REQUIRED_SIZE -> Result.success(CountryCode(value))
                else -> Result.failure(ValidationException(StringLengthValidationRule.Failure(2)))
            }
        }
    }
}