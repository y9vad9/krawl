# Brawl Stars API

This library provides a robust and type-safe way to interact with the official Brawl Stars and Brawlify APIs.
Designed for developers who need reliable data handling, it offers type-safe inter-usable types, predefined constraints, and utility functions to improve integration and reduce errors.

### Features:

- **Official Brawl Stars API Client**: Supports [official Brawl Stars API](https://developer.brawlstars.com/#/documentation).
- **Brawlify API Client**: Supports [Brawlify API](https://brawlapi.com/#/) with type-safe integration with official Brawl Stars API.

Supports two targets: Kotlin/JVM and Kotlin/JS; other will be available [upon request](https://github.com/y9vad9/brawlstars-api/issues/new).

## Installation

Add the following dependency to your `build.gradle.kts`:

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    // official BS API
    implementation("com.y9vad9.brawlstars:core:$version")
    // Brawlify API
    implementation("com.y9vad9.brawlstars:brawlify:$version")
}
```

## Usage

### Fetching Player Data

1. **Define your client:**

   Use the library’s prebuilt API client to interact with endpoints:

   ```kotlin
   val client = BrawlStarsClient(apiKey = "your-api-key", engine = CIO)
   ```
   Regarding `engine` parameter, please refer to
   the [Ktor Documentation on client engines](https://ktor.io/docs/client-engines.html).

2. **Fetch player details:**

   ```kotlin
   // error-proof way of passing player's tag, to avoid,
   // for example, unnecessary API calls and validation on your side:
   val playerTag: PlayerTag = PlayerTag.createOr("9V8LCUC0G") { // accepts both with hashtag and without
       error("Invalid player tag!")
   }
   val player = client.getPlayer(playerTag)
   player.onSuccess {
       println("Player Name: ${it.name}, Trophies: ${it.trophies}")
   }.onFailure {
       println("Error fetching player: ${it.message}")
   }
   ```
   Library enforces type safety with validated value classes. For
   the reference, take a look
   at [PlayerTag](core/src/commonMain/kotlin/com/y9vad9/brawlstars/types/player/value/PlayerTag.kt).

### Fetching Battle Data

1. **Retrieve battle logs:**

   ```kotlin
   // if you're sure about input tag, you can use unsafe-way 
   // of institating
   val playerTag: PlayerTag = PlayerTag.createUnsafe("9V8LCUC0G")
   
   val battles = client.getBattleLogs(playerTag)
   battles.onSuccess {
       it.forEach { battle ->
           if (battle.type.isRankedGameMode) {
              println("This is ranked game mode!")
              val stage = battle.getRankedStage(playerTag)
  
              if (stage >= RankedStage.DIAMOND_ONE)
                print("In this match was picking stage.")
           }
   
           println("Battle Mode: ${battle.mode}, Result: ${battle.result}")
       }
   }.onFailure {
       println("Error fetching battles: ${it.message}")
   }
   ```

## Dependencies

The library internally uses:

- **Ktor Client**: For HTTP requests.
- **Kotlinx.Serialization**: For JSON parsing.
- **Kotlinx.Coroutines**: For asynchronous operations.
- **Kotlinx.DateTime**: For handling date/time in API responses.

## Contributing

Contributions are welcome! Please create a pull request or open an issue to suggest improvements or report bugs.

## License

This project is licensed under the [MIT License](LICENSE).

*This product is not affiliated with, endorsed, sponsored, or specifically approved by Supercell and Supercell is not
responsible for it.
For more information see [Supercell’s Fan Content Policy](https://supercell.com/en/fan-content-policy/).*
