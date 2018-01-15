package com.lightningkite.kotlin.lambda

/**
 *
 * Created by joseph on 11/14/16.
 */

/**
 * Appends more functionality to a lambda.
 */
infix fun <A, B> (() -> A).then(next: (A) -> B): () -> B {
    return { this.invoke().let(next) }
}

/**
 * Used to formally declare that you are creating a lambda.  Works when syntax doesn't.
 */
fun <Z> lambda(it: () -> Z) = it

/**
 * Used to formally declare that you are creating a lambda.  Works when syntax doesn't.
 */
fun <Z, A> lambda(it: (A) -> Z) = it

/**
 * Used to formally declare that you are creating a lambda.  Works when syntax doesn't.
 */
fun <Z, A, B> lambda(it: (A, B) -> Z) = it

/**
 * Used to formally declare that you are creating a lambda.  Works when syntax doesn't.
 */
fun <Z, A, B, C> lambda(it: (A, B, C) -> Z) = it

/**
 * Used to formally declare that you are creating a lambda.  Works when syntax doesn't.
 */
fun <Z, A, B, C, D> lambda(it: (A, B, C, D) -> Z) = it

/**
 * Used to formally declare that you are creating a lambda.  Works when syntax doesn't.
 */
fun <Z, A, B, C, D, E> lambda(it: (A, B, C, D, E) -> Z) = it