package com.lightningkite.kotlin.lambda

/**
 *
 * Created by joseph on 9/2/16.
 */
class CooldownLambda(val time: Long, val inner: () -> Unit) : () -> Unit {
    var lastTime = 0L
    override fun invoke() {
        val now = System.currentTimeMillis()
        if (now - lastTime > time) {
            inner()
            lastTime = now
        }
    }
}

fun (() -> Unit).cooldown(time: Long): () -> Unit = CooldownLambda(time, this)