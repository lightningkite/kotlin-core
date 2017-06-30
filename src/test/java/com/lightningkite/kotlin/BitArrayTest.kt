package com.lightningkite.kotlin

import com.lightningkite.kotlin.bytes.toBitArray
import org.junit.Test
import org.junit.Assert.*

class BitArrayTest {

    @Test
    fun testIntBitArray() {
        var intArray = 0.toBitArray()
        intArray.forEach {
            assertFalse(it)
        }
        assertEquals(0, intArray.value)
        intArray[0] = true
        assertEquals(1, intArray.value)
        intArray[4] = true
        intArray.forEachIndexed { index, b ->
            when(index) {
                0 -> assertTrue(b)
                4 -> assertTrue(b)
                else -> assertFalse(b)
            }
        }
        intArray[31] = true
        assertTrue(intArray[31])
        for(i in 0..31) {
            intArray[i] = true
        }
        intArray.forEach { assertTrue(it) }
    }

    @Test
    fun testLongArray() {
        var longArray = 0L.toBitArray()
        longArray.forEach {
            assertFalse(it)
        }
        assertEquals(0, longArray.value)
        longArray[0] = true
        assertEquals(1, longArray.value)
        longArray[4] = true
        longArray.forEachIndexed { index, b ->
            when(index) {
                0 -> assertTrue(b)
                4 -> assertTrue(b)
                else -> assertFalse(b)
            }
        }
        longArray[31] = true
        assertTrue(longArray[31])
        for(i in 0..63) {
            longArray[i] = true
        }
        longArray.forEach { assertTrue(it) }
    }
}