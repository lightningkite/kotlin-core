package com.ivieleague.kotlin.lifecycle

/**
 * Used to interface with different components that have different lifecycles.
 * Created by jivie on 6/1/16.
 */
interface LifecycleConnectable {
    fun connect(listener: LifecycleListener)
}