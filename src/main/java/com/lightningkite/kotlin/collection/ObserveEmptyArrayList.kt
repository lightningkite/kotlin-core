package com.lightningkite.kotlin.collection

import java.util.*

/**
 * Created by joseph on 12/2/16.
 */
abstract class ObserveEmptyArrayList<E>() : ArrayList<E>() {

    abstract fun onNotEmpty(): Unit
    abstract fun onEmpty(): Unit

    var active = false
    private fun checkUp() {
        if (!super.isEmpty() && !active) {
            active = true
            onNotEmpty()
        }
    }

    private fun checkDown() {
        if (super.isEmpty() && active) {
            active = false
            onEmpty()
        }
    }

    override fun add(element: E): Boolean {
        val result = super.add(element)
        checkUp()
        return result
    }

    override fun addAll(elements: Collection<E>): Boolean {
        val result = super.addAll(elements)
        checkUp()
        return result
    }

    override fun clear() {
        super.clear()
        checkDown()
    }

    override fun remove(element: E): Boolean {
        val result = super.remove(element)
        checkDown()
        return result
    }

    override fun removeAll(elements: Collection<E>): Boolean {
        val result = super.removeAll(elements)
        checkDown()
        return result
    }

    override fun retainAll(elements: Collection<E>): Boolean {
        val result = super.retainAll(elements)
        checkDown()
        return result
    }
}