package com.lightningkite.kotlin

/**
 * Created by josep on 2/15/2017.
 */
inline fun <T> T.aside(action:(T)->Unit):T{
    action(this)
    return this
}