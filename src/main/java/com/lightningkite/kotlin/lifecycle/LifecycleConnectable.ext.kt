package com.lightningkite.kotlin.lifecycle

/**
 * Extensions to attach things to lifecycles.
 * Created by jivie on 6/1/16.
 */

fun <T> LifecycleConnectable.listen(collection: MutableCollection<T>, item: T) {
    connect(object : LifecycleListener {
        override fun onStart() {
            collection.add(item)
        }

        override fun onStop() {
            collection.remove(item)
        }
    })
}

fun <A, B> LifecycleConnectable.listen(eventA: MutableCollection<(A) -> Unit>, eventB: MutableCollection<(B) -> Unit>, listener: () -> Unit) {
    connect(object : LifecycleListener {
        val listenerA = { it: A -> listener() }
        val listenerB = { it: B -> listener() }

        override fun onStart() {
            eventA.add(listenerA)
            eventB.add(listenerB)
        }

        override fun onStop() {
            eventA.remove(listenerA)
            eventB.remove(listenerB)
        }
    })
}

fun <A, B, C> LifecycleConnectable.listen(
        eventA: MutableCollection<(A) -> Unit>,
        eventB: MutableCollection<(B) -> Unit>,
        eventC: MutableCollection<(C) -> Unit>,
        listener: () -> Unit
) {
    connect(object : LifecycleListener {
        val listenerA = { it: A -> listener() }
        val listenerB = { it: B -> listener() }
        val listenerC = { it: C -> listener() }

        override fun onStart() {
            eventA.add(listenerA)
            eventB.add(listenerB)
            eventC.add(listenerC)
        }

        override fun onStop() {
            eventA.remove(listenerA)
            eventB.remove(listenerB)
            eventC.remove(listenerC)
        }
    })
}

fun <T> LifecycleConnectable.bind(event: MutableCollection<(T) -> Unit>, firstRunValue: T, listener: (T) -> Unit) {
    connect(object : LifecycleListener {
        override fun onStart() {
            event.add(listener)
            listener(firstRunValue)
        }

        override fun onStop() {
            event.remove(listener)
        }
    })
}

fun LifecycleConnectable.bind(event: MutableCollection<() -> Unit>, listener: () -> Unit) {
    connect(object : LifecycleListener {
        override fun onStart() {
            event.add(listener)
            listener()
        }

        override fun onStop() {
            event.remove(listener)
        }
    })
}