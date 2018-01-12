package com.lightningkite.kotlin.lambda

/**
 *
 * Created by joseph on 9/27/17.
 */

/**
 * Invokes all of the functions in this iterable.
 */
fun Iterable<() -> Unit>.invokeAll() {
    for (item in this) {
        item()
    }
}

/**
 * Invokes all of the functions in this iterable with the given arguments.
 */
fun <A> Iterable<(A) -> Unit>.invokeAll(a: A) {
    for (item in this) {
        item(a)
    }
}


/**
 * Invokes all of the functions in this iterable with the given arguments.
 */
fun <A, B> Iterable<(A, B) -> Unit>.invokeAll(a: A, b: B) {
    for (item in this) {
        item(a, b)
    }
}


/**
 * Invokes all of the functions in this iterable with the given arguments.
 */
fun <A, B, C> Iterable<(A, B, C) -> Unit>.invokeAll(a: A, b: B, c: C) {
    for (item in this) {
        item(a, b, c)
    }
}


/**
 * Invokes all of the functions in this iterable with the given arguments.
 */
fun <A, B, C, D> Iterable<(A, B, C, D) -> Unit>.invokeAll(a: A, b: B, c: C, d: D) {
    for (item in this) {
        item(a, b, c, d)
    }
}


/**
 * Adds the lambda to the collection, removing it once it's been invoked.
 */
inline fun <A> MutableCollection<(A) -> Unit>.addInvokeOnce(crossinline lambda: (A) -> Unit) {
    add(object : (A) -> Unit {
        override fun invoke(a: A) {
            lambda.invoke(a)
            remove(this)
        }
    })
}

/**
 * Adds the lambda to the collection, removing it once it's been invoked.
 */
inline fun <A, B> MutableCollection<(A, B) -> Unit>.addInvokeOnce(crossinline lambda: (A, B) -> Unit) {
    add(object : (A, B) -> Unit {
        override fun invoke(a: A, b: B) {
            lambda.invoke(a, b)
            remove(this)
        }
    })
}

/**
 * Adds the lambda to the collection, removing it once it's been invoked.
 */
inline fun <A, B, C> MutableCollection<(A, B, C) -> Unit>.addInvokeOnce(crossinline lambda: (A, B, C) -> Unit) {
    add(object : (A, B, C) -> Unit {
        override fun invoke(a: A, b: B, c: C) {
            lambda.invoke(a, b, c)
            remove(this)
        }
    })
}

/**
 * Adds the lambda to the collection, removing it once it's been invoked.
 * @arg filter Filters out calls that you want to ignore.
 */
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

/**
 * Adds the lambda to the collection, removing it once it's been invoked.
 * @arg filter Filters out calls that you want to ignore.
 */
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

/**
 * Adds the lambda to the collection, removing it once it's been invoked.
 * @arg filter Filters out calls that you want to ignore.
 */
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