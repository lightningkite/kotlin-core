package com.lightningkite.kotlin.lambda

/**
 * Created by joseph on 11/14/16.
 */
inline fun <A, B> (() -> A).map(noinline mapper: (A) -> B): () -> B {
    return { this.invoke().let(mapper) }
}