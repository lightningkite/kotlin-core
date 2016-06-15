package com.lightningkite.kotlin.math

/**
 * Created by jivie on 5/19/16.
 */
inline fun Byte.toIntUnsigned(): Int {
    return (this.toInt() + 0xFF) and 0xFF
}