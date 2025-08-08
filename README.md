# Krawl
[![CodeQL Analysis](https://github.com/y9vad9/krawl/actions/workflows/analyse.codeql.yml/badge.svg)](https://github.com/y9vad9/krawl/actions/workflows/analyse.codeql.yml) [![Detekt Checks](https://github.com/y9vad9/krawl/actions/workflows/check.detekt.yml/badge.svg)](https://github.com/y9vad9/krawl/actions/workflows/check.detekt.yml) [![Test Suite](https://github.com/y9vad9/krawl/actions/workflows/check.tests.yml/badge.svg)](https://github.com/y9vad9/krawl/actions/workflows/check.tests.yml) [![Coverage](https://codecov.io/gh/y9vad9/krawl/branch/main/graph/badge.svg)](https://codecov.io/gh/y9vad9/krawl)

Krawl is a [coroutine-based](https://kotlinlang.org/docs/coroutines-overview.html) implementation of the Brawl Stars and Brawlify APIs, written 100% in [Kotlin](https://kotlinlang.org/).

## Why use Krawl
Most libraries for the Brawl Stars and Brawlify APIs, regardless of language, offer little beyond raw JSON mapping. They typically lack type safety, structured domain models, and developer-friendly tooling, forcing you to handle validation and interpretation on your own.

Krawl was built to fix that. It provides a Kotlin-first, type-safe experience designed to simplify API usage without sacrificing correctness or clarity. With rich models, helpful extensions, and thoughtful abstractions, Krawl turns low-level data into high-level utility.

## Status of Krawl
> [!NOTE]
> Currently, this is just an overview of what will be available after a release.

- [x] [Official Brawl Stars API](https://developer.brawlstars.com/#/)
  - [x] Players API
    - [x] Player information
    - [x] Player battlelog
  - [x] Clubs API
    - [x] List of members
    - [x] Club information
  - [x] Rankings API
    - [x] Clubs ranking
    - [x] Brawlers ranking
    - [x] Players ranking
  - [x] Brawlers API
    - [x] List of brawlers
    - [x] Brawler information
  - [x] Events API
    - [x] Event rotation information
- [x] [Official Brawlify API](https://brawlapi.com/)
  - [x] [Events API](https://brawlapi.com/#/endpoints/events)
  - [x] [Brawlers API](https://brawlapi.com/#/endpoints/brawlers)
  - [x] [Maps API](https://brawlapi.com/#/endpoints/maps)
  - [x] [Game Modes API](https://brawlapi.com/#/endpoints/gamemodes)
  - [x] [Icons API](https://brawlapi.com/#/endpoints/icons)
  - [x] [Game Data (Raw files) API](https://brawlapi.com/#/endpoints/game-data)[^1]

[^1]: Game Data (Raw files) API is supported through a Gradle Plugin with code-generation or
using [JsonElement](https://kotlinlang.org/api/kotlinx.serialization/kotlinx-serialization-json/kotlinx.serialization.json/-json-element/) with `brawlify-api`.

## Documentation
- [Wiki](https://krawl.y9vad9.com)
- [Dokka documentation](https://dokka.krawl.y9vad9.com)

## Modules
Krawl is modular. Depending on your needs, you can choose between raw, low-level access and a high-level, type-safe experience.
- `brawlstars-api` and `brawlify-api`: low-level access to the APIs, exposing [`@Serializable`](https://kotlinlang.org/api/kotlinx.serialization/kotlinx-serialization-core/kotlinx.serialization/-serializable/) models that closely follow the original JSON schemas. These modules are used internally by their corresponding high-level modules, but still usable outside their high-level wrappers.
- `brawlstars-core` and `brawlify-core`: high-level access with type-safe models, validation, and Kotlin-first APIs, built on top of the low-level modules.
- `brawlify-gamedata-core` and `brawlify-gamedata-plugin`: access to Brawlify’s Game Data API. This includes raw data through code-generated models and experimental type-safe access to the localization API, implemented on top of the game data layer.

## Implementation
<details>
<summary>Using Version Catalog</summary>

```toml
[versions]
krawl = "0.1.0"

[libraries]
# Low-level access to the APIs
krawl-brawlstars-api = { module = "com.y9vad9.krawl:brawlstars-api", version.ref = "krawl" }
krawl-brawlify-api = { module = "com.y9vad9.krawl:brawlify-api", version.ref = "krawl" }

# High-level, type-safe access
krawl-brawlstars-core = { module = "com.y9vad9.krawl:brawlstars-core", version.ref = "krawl" }
krawl-brawlify-core = { module = "com.y9vad9.krawl:brawlify-core", version.ref = "krawl" }

# Game Data API and experimental localization access
krawl-brawlify-gamedata-core = { module = "com.y9vad9.krawl:brawlify-gamedata-core", version.ref = "krawl" }

[plugins]
krawl-gamedata = { id = "com.y9vad9.krawl.gamedata", version.ref = "krawl" }
```

```kotlin
plugins {
    alias(libs.plugins.krawl.gamedata)
}

repositories {
    mavenCentral()
}

dependencies {
    // For Kotlin Multiplatform Projects
    commonMainImplementation(libs.krawl.brawlstars.api)
    commonMainImplementation(libs.krawl.brawlify.api)

    commonMainImplementation(libs.krawl.brawlstars.core)
    commonMainImplementation(libs.krawl.brawlify.core)
    commonMainImplementation(libs.krawl.brawlify.gamedata.core)
}
```

</details>
<details>
    <summary>Without Version Catalog</summary>

```kotlin
plugins {
    id("com.y9vad9.krawl.gamedata") version "0.1.0"
}

dependencies {
    // Low-level API access
    implementation("com.y9vad9.krawl:brawlstars-api:0.1.0")
    implementation("com.y9vad9.krawl:brawlify-api:0.1.0")

    // Type-safe API access
    implementation("com.y9vad9.krawl:brawlstars-core:0.1.0")
    implementation("com.y9vad9.krawl:brawlify-core:0.1.0")

    // Game Data API with localization support
    implementation("com.y9vad9.krawl:brawlify-gamedata-core:0.1.0")
}
```

</details>
<details>
    <summary>Using Maven</summary>

```xml
<dependencies>
  <!-- Low-level API access -->
  <dependency>
    <groupId>com.y9vad9.krawl</groupId>
    <artifactId>brawlstars-api</artifactId>
    <version>0.1.0</version>
  </dependency>
  <dependency>
    <groupId>com.y9vad9.krawl</groupId>
    <artifactId>brawlify-api</artifactId>
    <version>0.1.0</version>
  </dependency>

  <!-- Type-safe API access -->
  <dependency>
    <groupId>com.y9vad9.krawl</groupId>
    <artifactId>brawlstars-core</artifactId>
    <version>0.1.0</version>
  </dependency>
  <dependency>
    <groupId>com.y9vad9.krawl</groupId>
    <artifactId>brawlify-core</artifactId>
    <version>0.1.0</version>
  </dependency>
</dependencies>
```

> Game Data API is currently supported only through a Gradle Plugin.

</details>

## Contributing
Contributions are welcome! Please create a pull request or open an issue to suggest improvements or report bugs.

## License

This project is licensed under the [MIT License](LICENSE).

______

*This product is not affiliated with, endorsed, sponsored, or specifically approved by Supercell and Supercell is not
responsible for it.
For more information see [Supercell’s Fan Content Policy](https://supercell.com/en/fan-content-policy/).*