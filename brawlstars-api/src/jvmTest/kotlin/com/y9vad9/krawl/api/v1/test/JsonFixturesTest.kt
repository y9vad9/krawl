package com.y9vad9.krawl.api.v1.test

import kotlinx.serialization.json.Json

abstract class JsonFixturesTest : FixtureTest() {
    protected val json: Json = Json {
        ignoreUnknownKeys = false
    }
}
