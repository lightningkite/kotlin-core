package com.lightningkite.kotlin.lifecycle

/**
 * Listener for start and stop events on a lifecycle.
 * Created by jivie on 6/1/16.
 */
interface LifecycleListener {
    fun onStart()
    fun onStop()
}