package com.lightningkite.kotlin.date

import java.util.*

/**
 * Creates a calendar from a date using the local time zone.
 */
fun Date.toCalendar(): Calendar {
    val cal = Calendar.getInstance()
    cal.time = this
    return cal
}

/**
 * Returns the year of the calendar using [Calendar.YEAR].
 */
var Calendar.year: Int
    get() = get(Calendar.YEAR)
    set(value) = set(Calendar.YEAR, value)

/**
 * Returns the month of the calendar using [Calendar.MONTH].
 */
var Calendar.month: Int
    get() = get(Calendar.MONTH)
    set(value) = set(Calendar.MONTH, value)

/**
 * Returns the weekInMonth of the calendar using [Calendar.WEEK_OF_MONTH].
 */
var Calendar.weekInMonth: Int
    get() = get(Calendar.WEEK_OF_MONTH)
    set(value) = set(Calendar.WEEK_OF_MONTH, value)

/**
 * Returns the dayOfMonth of the calendar using [Calendar.DAY_OF_MONTH].
 */
var Calendar.dayOfMonth: Int
    get() = get(Calendar.DAY_OF_MONTH)
    set(value) = set(Calendar.DAY_OF_MONTH, value)

/**
 * Returns the dayOfWeek of the calendar using [Calendar.DAY_OF_WEEK].
 */
var Calendar.dayOfWeek: Int
    get() = get(Calendar.DAY_OF_WEEK)
    set(value) = set(Calendar.DAY_OF_WEEK, value)

/**
 * Returns the hourOfDay of the calendar using [Calendar.HOUR_OF_DAY].
 */
var Calendar.hourOfDay: Int
    get() = get(Calendar.HOUR_OF_DAY)
    set(value) = set(Calendar.HOUR_OF_DAY, value)

/**
 * Returns the minute of the calendar using [Calendar.MINUTE].
 */
var Calendar.minute: Int
    get() = get(Calendar.MINUTE)
    set(value) = set(Calendar.MINUTE, value)

/**
 * Returns the second of the calendar using [Calendar.SECOND].
 */
var Calendar.second: Int
    get() = get(Calendar.SECOND)
    set(value) = set(Calendar.SECOND, value)

/**
 * Returns the millisecond of the calendar using [Calendar.MILLISECOND].
 */
var Calendar.millisecond: Int
    get() = get(Calendar.MILLISECOND)
    set(value) = set(Calendar.MILLISECOND, value)