package com.y9vad9.krawl.test

import kotlinx.serialization.json.Json

abstract class WithJsonFixturesTest : WithFixtureTest() {
    protected val json: Json = Json {
        ignoreUnknownKeys = false
    }
}
