package com.y9vad9.krawl

/**
 * Annotation-marker that is used to notify call-site that provided data is incompleted
 * due to incompleteness of data provided by Brawl Stars API or due to lack of contextual
 * information.
 */
@RequiresOptIn(
    level = RequiresOptIn.Level.WARNING,
    message = "This API may provide incomplete data that might be not totally correct.",
)
public annotation class IncompleteReturningData
