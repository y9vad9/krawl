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
   implementation("com.y9vad9.brawlify:core:$version")
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

## Documentation
Documentation is available [here](https://y9vad9.github.io/brawlstars-api-docs/start-page.html) – you can find almost all information about library there.

## License

This project is licensed under the [MIT License](LICENSE).

*This product is not affiliated with, endorsed, sponsored, or specifically approved by Supercell and Supercell is not
responsible for it.
For more information see [Supercell’s Fan Content Policy](https://supercell.com/en/fan-content-policy/).*
