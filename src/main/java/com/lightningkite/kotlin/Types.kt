package com.lightningkite.kotlin

inline fun <reified T : Any> Any.cast() = this as T
inline fun <reified T : Any> Any.castOrNull() = this as? T