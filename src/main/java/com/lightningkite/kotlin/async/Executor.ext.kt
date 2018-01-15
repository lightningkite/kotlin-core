package com.lightningkite.kotlin.async

import java.util.concurrent.Executor
import java.util.concurrent.Future
import java.util.concurrent.FutureTask

fun <T> Executor.submit(task: () -> T): Future<T> {
    val ftask = FutureTask<T>(task)
    execute(ftask)
    return ftask
}

inline fun <T> Executor.execute(crossinline task: () -> T) {
    execute { task() }
}
fun <T> (() -> T).invokeFuture(executor: Executor) = executor.submit(this)
fun <T> (() -> T).invokeOn(executor: Executor) = executor.execute { this.invoke() }
fun <A> (() -> A).thenOn(executor: Executor, next: (A) -> Unit): () -> Unit {
    return {
        val result = this.invoke()
        executor.execute { next(result) }
    }
}