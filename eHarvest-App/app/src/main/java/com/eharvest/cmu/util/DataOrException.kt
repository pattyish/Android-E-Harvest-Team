package com.eharvest.cmu.util

data class DataOrException<T, E : Exception?>(
    var data: T? = null,
    var e: E? = null
)