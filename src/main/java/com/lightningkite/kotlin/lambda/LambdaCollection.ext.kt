package com.lightningkite.kotlin.lambda

/**
 *
 * Created by joseph on 9/27/17.
 */

inline fun <A> MutableCollection<(A) -> Unit>.addInvokeOnce(crossinline lambda: (A) -> Unit) {
    add(object : (A) -> Unit {
        override fun invoke(a: A) {
            lambda.invoke(a)
            remove(this)
        }
    })
}

inline fun <A, B> MutableCollection<(A, B) -> Unit>.addInvokeOnce(crossinline lambda: (A, B) -> Unit) {
    add(object : (A, B) -> Unit {
        override fun invoke(a: A, b: B) {
            lambda.invoke(a, b)
            remove(this)
        }
    })
}

inline fun <A, B, C> MutableCollection<(A, B, C) -> Unit>.addInvokeOnce(crossinline lambda: (A, B, C) -> Unit) {
    add(object : (A, B, C) -> Unit {
        override fun invoke(a: A, b: B, c: C) {
            lambda.invoke(a, b, c)
            remove(this)
        }
    })
}

inline fun <A> MutableCollection<(A) -> Unit>.addInvokeOnce(crossinline filter: (A) -> Boolean, crossinline lambda: (A) -> Unit) {
    add(object : (A) -> Unit {
        override fun invoke(a: A) {
            if (filter.invoke(a)) {
                lambda.invoke(a)
                remove(this)
            }
        }
    })
}

inline fun <A, B> MutableCollection<(A, B) -> Unit>.addInvokeOnce(crossinline filter: (A, B) -> Boolean, crossinline lambda: (A, B) -> Unit) {
    add(object : (A, B) -> Unit {
        override fun invoke(a: A, b: B) {
            if (filter.invoke(a, b)) {
                lambda.invoke(a, b)
                remove(this)
            }
        }
    })
}

inline fun <A, B, C> MutableCollection<(A, B, C) -> Unit>.addInvokeOnce(crossinline filter: (A, B, C) -> Boolean, crossinline lambda: (A, B, C) -> Unit) {
    add(object : (A, B, C) -> Unit {
        override fun invoke(a: A, b: B, c: C) {
            if (filter.invoke(a, b, c)) {
                lambda.invoke(a, b, c)
                remove(this)
            }
        }
    })
}