package com.ivieleague.kotlin.collection

import java.util.*

/**
 * Created by jivie on 4/6/16.
 */
fun <T> stackOf(vararg items: T): Stack<T> {
    val stack = Stack<T>()
    for(i in items.size - 1 downTo 0) {
        stack.push(items[i])
    }
    return stack
}