package com.ivieleague.kotlin.text

/**
 * Various extensions for String.
 * Created by jivie on 6/1/16.
 */


val EmailRegularExpression: Regex = "[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}".toRegex(RegexOption.IGNORE_CASE)

inline fun String.isEmail(): Boolean {
    return matches(EmailRegularExpression)
}