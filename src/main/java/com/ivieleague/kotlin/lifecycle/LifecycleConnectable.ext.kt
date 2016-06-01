package com.ivieleague.kotlin.lifecycle

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