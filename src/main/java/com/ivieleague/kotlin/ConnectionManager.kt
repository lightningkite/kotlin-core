package com.ivieleague.kotlin

import java.util.*

/**
 * Created by jivie on 6/1/16.
 */
class ConnectionManager {
    val connections = ArrayList<Connection>()
    var running = false

    fun <T : Any> addConnection(holder: MutableCollection<T>, item: T) {
        val newConnection = Connection(holder as MutableCollection<Any>, item)
        connections.add(newConnection)
        if (running)
            newConnection.start()
    }

    fun start() {
        if (running) return
        running = true
        for (connection in connections) {
            connection.start()
        }
    }

    fun stop() {
        if (!running) return
        running = false
        for (connection in connections) {
            connection.stop()
        }
    }

    class Connection(val holder: MutableCollection<Any>, val item: Any) {
        fun start() = holder.add(item)
        fun stop() = holder.remove(item)
    }
}