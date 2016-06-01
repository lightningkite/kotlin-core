package com.ivieleague.kotlin.async

/**
 * Created by jivie on 6/1/16.
 */
interface AsyncInterface {
    fun sendToThread(action: () -> Unit)
}