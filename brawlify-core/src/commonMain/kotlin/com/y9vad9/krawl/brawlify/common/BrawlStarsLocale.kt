package com.y9vad9.krawl.brawlify.common

import kotlin.jvm.JvmInline

/**
 * Represents a supported localization language for Brawl Stars, used to retrieve
 * translated game content via the Brawlify API.
 *
 * Each locale corresponds to a language code used in the remote localization dataset
 * (e.g., `localization/de`, `localization/jp`). These codes determine which CSV-based
 * translation file should be loaded for names, descriptions, and other localized game metadata.
 *
 * @property rawString The Brawlify localization key (language code), typically used to form the path to a CSV file.
 */
@JvmInline
public value class BrawlStarsLocale(public val rawString: String) {
    public companion object {
        /** Arabic (العربية) localization, code: `"ar"` */
        public val ARABIC: BrawlStarsLocale = BrawlStarsLocale("ar")

        /** Simplified Chinese (简体中文) localization, code: `"cn"` */
        public val CHINESE_SIMPLIFIED: BrawlStarsLocale = BrawlStarsLocale("cn")

        /** Traditional Chinese (繁體中文) localization, code: `"cnt"` */
        public val CHINESE_TRADITIONAL: BrawlStarsLocale = BrawlStarsLocale("cnt")

        /** German (Deutsch) localization, code: `"de"` */
        public val GERMAN: BrawlStarsLocale = BrawlStarsLocale("de")

        /** Spanish (Español) localization, code: `"es"` */
        public val SPANISH: BrawlStarsLocale = BrawlStarsLocale("es")

        /** Finnish (Suomi) localization, code: `"fi"` */
        public val FINNISH: BrawlStarsLocale = BrawlStarsLocale("fi")

        /** French (Français) localization, code: `"fr"` */
        public val FRENCH: BrawlStarsLocale = BrawlStarsLocale("fr")

        /** Hebrew (עברית) localization, code: `"he"` */
        public val HEBREW: BrawlStarsLocale = BrawlStarsLocale("he")

        /** Indonesian (Bahasa Indonesia) localization, code: `"id"` */
        public val INDONESIAN: BrawlStarsLocale = BrawlStarsLocale("id")

        /** Italian (Italiano) localization, code: `"it"` */
        public val ITALIAN: BrawlStarsLocale = BrawlStarsLocale("it")

        /** Japanese (日本語) localization, code: `"jp"` */
        public val JAPANESE: BrawlStarsLocale = BrawlStarsLocale("jp")

        /** Korean (한국어) localization, code: `"kr"` */
        public val KOREAN: BrawlStarsLocale = BrawlStarsLocale("kr")

        /** Malay (Bahasa Melayu) localization, code: `"ms"` */
        public val MALAY: BrawlStarsLocale = BrawlStarsLocale("ms")

        /** Dutch (Nederlands) localization, code: `"nl"` */
        public val DUTCH: BrawlStarsLocale = BrawlStarsLocale("nl")

        /** Polish (Polski) localization, code: `"pl"` */
        public val POLISH: BrawlStarsLocale = BrawlStarsLocale("pl")

        /** Portuguese (Português) localization, code: `"pt"` */
        public val PORTUGUESE: BrawlStarsLocale = BrawlStarsLocale("pt")

        /** Russian (Русский) localization, code: `"ru"` */
        public val RUSSIAN: BrawlStarsLocale = BrawlStarsLocale("ru")

        /** Thai (ไทย) localization, code: `"th"` */
        public val THAI: BrawlStarsLocale = BrawlStarsLocale("th")

        /** Turkish (Türkçe) localization, code: `"tr"` */
        public val TURKISH: BrawlStarsLocale = BrawlStarsLocale("tr")

        /** Vietnamese (Tiếng Việt) localization, code: `"vi"` */
        public val VIETNAMESE: BrawlStarsLocale = BrawlStarsLocale("vi")

        /** All well-known supported locales recognized by the Brawlify game data API. */
        public val WELL_KNOWN: List<BrawlStarsLocale> = listOf(
            ARABIC,
            CHINESE_SIMPLIFIED,
            CHINESE_TRADITIONAL,
            GERMAN,
            SPANISH,
            FINNISH,
            FRENCH,
            HEBREW,
            INDONESIAN,
            ITALIAN,
            JAPANESE,
            KOREAN,
            MALAY,
            DUTCH,
            POLISH,
            PORTUGUESE,
            RUSSIAN,
            THAI,
            TURKISH,
            VIETNAMESE,
        )
    }
}
