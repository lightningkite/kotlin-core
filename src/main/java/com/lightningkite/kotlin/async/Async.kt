package com.lightningkite.kotlin.async

import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * A publicly available [ThreadPoolExecutor] that uses all of the processors available.
 */
object Async : ThreadPoolExecutor(
        Runtime.getRuntime().availableProcessors(),
        Runtime.getRuntime().availableProcessors(),
        1,
        TimeUnit.SECONDS,
        LinkedBlockingQueue<Runnable>()
)