package com.base_android_template.shared.network

import com.base_android_template.utils.Either
import java.net.UnknownHostException

class ExceptionHandler {

    fun handleGeneralException(exception: Throwable): Either.Failure<Exception> = when (exception) {
        is UnknownHostException -> Either.Failure(Exception.NetworkException)
        else -> Either.Failure(Exception.UnknownException(exception))
    }
}