package com.ivieleague.kotlin.external

import com.ivieleague.kotlin.async.doAsync

/**
 * An object that can save, delete, and fetch a new copy of data.
 *
 * Created by jivie on 6/8/16.
 */
interface ExternalModel<T> {

    val value: T?

    fun save(copy: T, onResult: (T?, String?) -> Unit) {
        doAsync({ save(copy) }, { onResult(it.item, it.error) })
    }

    fun delete(onResult: (String?) -> Unit) {
        doAsync({ delete() }, { onResult(it.error) })
    }

    fun fetch(onResult: (T?, String?) -> Unit) {
        doAsync({ fetch() }, { onResult(it.item, it.error) })
    }

    fun save(copy: T): Response<T>
    fun delete(): Response<T>
    fun fetch(): Response<T>

    data class Response<T>(val item: T?, val error: String?)
}