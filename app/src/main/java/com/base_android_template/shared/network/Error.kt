package com.base_android_template.shared.network

import java.io.IOException

sealed class Error {
    data class ServerError<U : Any>(val errorResponse: U) : Error()

    data class NetworkError(val error: IOException) : Error()

    data class UnknownError(val exception: Throwable?) : Error()
}

