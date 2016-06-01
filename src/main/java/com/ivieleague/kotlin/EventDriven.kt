package com.ivieleague.kotlin

/**
 * Various functions for event-driven programming.
 * Created by josep on 5/31/2016.
 */

inline fun Collection<()->Unit>.runAll(){
    for(item in this){
        item()
    }
}
inline fun <A> Collection<(A)->Unit>.runAll(a:A){
    for(item in this){
        item(a)
    }
}
inline fun <A, B> Collection<(A, B)->Unit>.runAll(a:A, b:B){
    for(item in this){
        item(a, b)
    }
}
inline fun <A, B, C> Collection<(A, B, C)->Unit>.runAll(a:A, b:B, c:C){
    for(item in this){
        item(a, b, c)
    }
}
inline fun <A, B, C, D> Collection<(A, B, C, D)->Unit>.runAll(a:A, b:B, c:C, d:D){
    for(item in this){
        item(a, b, c, d)
    }
}