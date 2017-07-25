package com.lightningkite.kotlin

/**
 * Various functions for event-driven programming.
 * Created by josep on 5/31/2016.
 */

@Deprecated("Use invokeAll instead.", ReplaceWith("invokeAll()")) inline fun Iterable<() -> Unit>.runAll() = invokeAll()

inline fun Iterable<() -> Unit>.invokeAll() {
    for (item in this) {
        item()
    }
}

@Deprecated("Use invokeAll instead.", ReplaceWith("invokeAll(a)")) inline fun <A> Iterable<(A) -> Unit>.runAll(a: A) = invokeAll(a)
inline fun <A> Iterable<(A) -> Unit>.invokeAll(a: A) {
    for (item in this) {
        item(a)
    }
}

@Deprecated("Use invokeAll instead.", ReplaceWith("invokeAll(a, b)")) inline fun <A, B> Iterable<(A, B) -> Unit>.runAll(a: A, b: B) = invokeAll(a, b)
inline fun <A, B> Iterable<(A, B) -> Unit>.invokeAll(a: A, b: B) {
    for (item in this) {
        item(a, b)
    }
}

@Deprecated("Use invokeAll instead.", ReplaceWith("invokeAll(a, b, c)")) inline fun <A, B, C> Iterable<(A, B, C) -> Unit>.runAll(a: A, b: B, c: C) = invokeAll(a, b, c)
inline fun <A, B, C> Iterable<(A, B, C) -> Unit>.invokeAll(a: A, b: B, c: C) {
    for (item in this) {
        item(a, b, c)
    }
}

@Deprecated("Use invokeAll instead.", ReplaceWith("invokeAll(a, b, c, d)")) inline fun <A, B, C, D> Iterable<(A, B, C, D) -> Unit>.runAll(a: A, b: B, c: C, d: D) = invokeAll(a, b, c, d)
inline fun <A, B, C, D> Iterable<(A, B, C, D) -> Unit>.invokeAll(a: A, b: B, c: C, d: D) {
    for (item in this) {
        item(a, b, c, d)
    }
}