package com.lightningkite.kotlin.lifecycle

import java.io.Closeable
import java.util.*

/**
 * A lifecycle that is started immediately and stops upon being closed.
 * Created by jivie on 6/28/16.
 */
class CloseLifecycle() : LifecycleConnectable, Closeable {
    val toRemove = ArrayList<LifecycleListener>()
    override fun connect(listener: LifecycleListener) {
        listener.onStart()
        toRemove.add(listener)
    }

    override fun close() {
        toRemove.forEach { it.onStop() }
        toRemove.clear()
    }

}