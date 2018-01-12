package com.lightningkite.kotlin.lambda

/**
 *
 * Created by joseph on 11/14/16.
 */
@Deprecated("Use 'then' instead.", ReplaceWith("then(mapper)"))
fun <A, B> (() -> A).map(mapper: (A) -> B): () -> B = then(mapper)

@Deprecated("Use 'then' instead.", ReplaceWith("then(mapper)"))
fun <A, B> (() -> A).transform(mapper: (A) -> B): () -> B = then(mapper)

/**
 * Appends more functionality to a lambda.
 */
infix fun <A, B> (() -> A).then(next: (A) -> B): () -> B {
    return { this.invoke().let(next) }
}

/**
 * Used to formally declare that you are creating a lambda.  Works when syntax doesn't sometimes.
 */
fun <Z> lambda(it: () -> Z) = it

/**
 * Used to formally declare that you are creating a lambda.  Works when syntax doesn't sometimes.
 */
fun <Z, A> lambda(it: (A) -> Z) = it

/**
 * Used to formally declare that you are creating a lambda.  Works when syntax doesn't sometimes.
 */
fun <Z, A, B> lambda(it: (A, B) -> Z) = it

/**
 * Used to formally declare that you are creating a lambda.  Works when syntax doesn't sometimes.
 */
fun <Z, A, B, C> lambda(it: (A, B, C) -> Z) = it

/**
 * Used to formally declare that you are creating a lambda.  Works when syntax doesn't sometimes.
 */
fun <Z, A, B, C, D> lambda(it: (A, B, C, D) -> Z) = it

/**
 * Used to formally declare that you are creating a lambda.  Works when syntax doesn't sometimes.
 */
fun <Z, A, B, C, D, E> lambda(it: (A, B, C, D, E) -> Z) = it