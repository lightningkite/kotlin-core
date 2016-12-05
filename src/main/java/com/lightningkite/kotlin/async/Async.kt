package com.lightningkite.kotlin.async

import java.util.concurrent.*

/**
 * Various functions to do things asynchronously.
 * Created by jivie on 9/2/15.
 */

object Async {
    val runnableQueue = LinkedBlockingQueue<Runnable>();
    private val NUMBER_OF_CORES: Int = Runtime.getRuntime().availableProcessors();
    private val KEEP_ALIVE_TIME: Long = 1;
    private val KEEP_ALIVE_TIME_UNIT: TimeUnit = TimeUnit.SECONDS;
    val threadPool = ThreadPoolExecutor(
            NUMBER_OF_CORES, // Initial pool size
            NUMBER_OF_CORES, // Max pool size
            KEEP_ALIVE_TIME,
            KEEP_ALIVE_TIME_UNIT,
            runnableQueue
    );
    var uiThreadInterface: AsyncInterface = object : AsyncInterface {
        override fun sendToThread(action: () -> Unit) = doAsync(action)
    }
}

inline fun <T> (() -> T).invokeAsync() {
    Async.threadPool.execute({
        invoke()
    })
}

inline fun <T> (() -> T).invokeAsyncFuture(): Future<T> = Async.threadPool.submit(this)

inline fun (() -> Unit).invokeUIThread() {
    Async.uiThreadInterface.sendToThread(this)
}

@JvmName("invokeUIThreadT")
inline fun <T> (() -> T).invokeUIThread() {
    Async.uiThreadInterface.sendToThread { invoke() }
}

inline fun <T> (() -> T).invokeAsync(crossinline callback: (T) -> Unit) {
    Async.threadPool.execute({
        val result = invoke()
        Async.uiThreadInterface.sendToThread { callback.invoke(result) }
    })
}

/**
 * Runs [action] asynchronously.
 * @param action The lambda to run asynchronously.
 */
fun <T> doAsync(action: () -> T) {
    Async.threadPool.execute({
        val result = action()
    })
}

/**
 * Runs [action] asynchronously with its result being dealt with on the UI thread in [uiThread].
 * @param action The lambda to run asynchronously.
 * @param uiThread The lambda to run with the result of [action] on the UI thread.
 */
fun <T> doAsync(action: () -> T, uiThread: (T) -> Unit) {
    Async.threadPool.execute({
        try {
            val result = action()
            Async.uiThreadInterface.sendToThread {
                uiThread(result)
            }
        } catch(e: Exception) {
            Async.uiThreadInterface.sendToThread {
                throw e
            }
        }
    })
}

/**
 * Posts [action] to the main thread.
 * @param action The lambda to run asynchronously.
 */
fun doUiThread(action: () -> Unit) {
    Async.uiThreadInterface.sendToThread(action)
}

fun <A, B> parallel(a: () -> A, b: () -> B): () -> Pair<A, B> {
    return {
        val futureA = FutureTask {
            a.invoke()
        }
        val futureB = FutureTask {
            b.invoke()
        }
        Thread(futureA).start()
        Thread(futureB).start()
        futureA.get() to futureB.get()
    }
}

fun <A, B, C> parallel(a: () -> A, b: () -> B, c: () -> C): () -> Triple<A, B, C> {
    return {
        val futureA = FutureTask {
            a.invoke()
        }
        val futureB = FutureTask {
            b.invoke()
        }
        val futureC = FutureTask {
            c.invoke()
        }
        Thread(futureA).start()
        Thread(futureB).start()
        Thread(futureC).start()
        Triple(futureA.get(), futureB.get(), futureC.get())
    }
}

@JvmName("parallelShorthand")
fun <T> List<() -> T>.parallel(): () -> List<T> = parallel(this)

fun <T> parallel(tasks: List<() -> T>): () -> List<T> {
    if (tasks.isEmpty()) return { listOf() }
    else {
        return {
            try {
                val results = tasks.subList(0, tasks.size - 1).map {
                    val future = FutureTask {
                        it.invoke()
                    }
                    Thread(future) to future
                }.map { it.first.start(); it.second }.map { it.get() }.toMutableList()
                results += tasks.last().invoke()
                results
            } catch(e: Exception) {
                e.printStackTrace()
                tasks.map { it() }
            }
        }
    }
}


//Weird async stuff below

inline fun <T> List<T>.withEachAsync(doTask: T.(() -> Unit) -> Unit, crossinline onAllComplete: () -> Unit) {
    if (isEmpty()) {
        onAllComplete()
        return
    }
    var itemsToGo = size
    for (item in this) {
        item.doTask {
            itemsToGo--
            if (itemsToGo <= 0) {
                onAllComplete()
            }
        }
    }
}

inline fun <T, MUTABLE, RESULT> List<T>.withReduceAsync(
        doTask: T.((RESULT) -> Unit) -> Unit,
        initialValue: MUTABLE,
        crossinline combine: MUTABLE.(RESULT) -> Unit,
        crossinline onAllComplete: (MUTABLE) -> Unit
) {
    if (isEmpty()) {
        onAllComplete(initialValue)
        return
    }
    var total = initialValue
    var itemsToGo = size
    for (item in this) {
        item.doTask {
            combine(total, it)
            itemsToGo--
            if (itemsToGo <= 0) {
                onAllComplete(total)
            }
        }
    }
}

inline fun parallelAsyncs(tasks: Collection<(() -> Unit) -> Unit>, crossinline onComplete: () -> Unit) {
    if (tasks.isEmpty()) {
        onComplete()
        return
    }
    var itemsToGo = tasks.size
    for (item in tasks) {
        item {
            itemsToGo--
            if (itemsToGo <= 0) {
                onComplete()
            }
        }
    }
}

inline fun parallelAsyncs(vararg tasks: (() -> Unit) -> Unit, crossinline onComplete: () -> Unit) {
    if (tasks.isEmpty()) {
        onComplete()
        return
    }
    var itemsToGo = tasks.size
    for (item in tasks) {
        item {
            itemsToGo--
            if (itemsToGo <= 0) {
                onComplete()
            }
        }
    }
}