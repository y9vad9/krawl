package com.y9vad9.brawlstars.exception

import io.ktor.http.*

public sealed class BrawlStarsAPIException(
    message: String,
) : Exception(message) {
    public class BadRequest : BrawlStarsAPIException(
        message = """
            Client provided incorrect parameters for the request.
            
            Shouldn't happen: please report – https://github.com/y9vad9/brawlstars-api/issues.
        """.trimIndent()
    )
    public class AccessDenied : BrawlStarsAPIException(
        "Access denied, either because of missing/incorrect credentials or used API token does not grant access to the requested resource."
    )
    public class LimitsExceeded : BrawlStarsAPIException(
        message = "Request was throttled, because amount of requests was above the threshold defined for the used API token."
    )
    public class InternalServerError : BrawlStarsAPIException(
        message = "Unknown error happened when handling the request."
    )
    public class UnderMaintenance : BrawlStarsAPIException(
        message = "Service is temporarily unavailable because of maintenance."
    )

    @Suppress("CanBeParameter")
    public class RawHttpError(
        public val httpStatusCode: HttpStatusCode
    ) : BrawlStarsAPIException(
        message = httpStatusCode.toString()
    )
}