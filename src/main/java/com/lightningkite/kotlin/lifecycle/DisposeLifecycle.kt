package com.lightningkite.kotlin.lifecycle

import com.lightningkite.kotlin.Disposable
import java.util.*

/**
 * Created by jivie on 6/28/16.
 */
class DisposeLifecycle() : LifecycleConnectable, Disposable {
    val toRemove = ArrayList<LifecycleListener>()
    override fun connect(listener: LifecycleListener) {
        listener.onStart()
        toRemove.add(listener)
    }

    override fun dispose() {
        toRemove.forEach { it.onStop() }
        toRemove.clear()
    }

}