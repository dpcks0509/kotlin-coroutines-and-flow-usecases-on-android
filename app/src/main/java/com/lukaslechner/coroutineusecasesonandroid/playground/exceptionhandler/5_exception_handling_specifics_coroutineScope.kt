package com.lukaslechner.coroutineusecasesonandroid.playground.exceptionhandler

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch {
        try {
            doSomethingSuspend()
        } catch (e: Exception) {
            println("exception caught: $e")
        }
    }
}

private suspend fun doSomethingSuspend() {
    coroutineScope {
        launch {
            throw RuntimeException()
        }
    }
}