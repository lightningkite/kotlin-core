package com.ivieleague.kotlin.external

import com.ivieleague.kotlin.async.doAsync

/**
 * Created by jivie on 6/9/16.
 */
interface ExternalCollection<T> {
    fun fetch(onResult: (List<T>?, String?) -> Unit) {
        doAsync({ fetch() }, { onResult(it.item, it.error) })
    }

    fun fetch(): Response<T>

    data class Response<T>(val item: List<T>?, val error: String?)

    fun item(value: T): ExternalModel<T>
}