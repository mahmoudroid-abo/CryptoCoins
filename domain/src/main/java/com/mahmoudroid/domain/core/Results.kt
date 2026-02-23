package com.mahmoudroid.domain.core

sealed class Results<out T> {
    data class Success<T>(val data: T) : Results<T>()
    data class Failure(val throwable: Throwable) : Results<Nothing>()
}