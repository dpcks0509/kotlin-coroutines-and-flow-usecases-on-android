package com.lukaslechner.coroutineusecasesonandroid.playground.exceptionhandler

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun main() {
    val scope = CoroutineScope(Job())

    scope.launch {
        try {
            launch {
                functionThatThrows()
            }
        } catch (e: Exception) {
            println("exception caught: $e")
        }
    }

    Thread.sleep(100)
}

private fun functionThatThrows() {
    throw RuntimeException()
}