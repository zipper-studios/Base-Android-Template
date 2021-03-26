package com.base_android_template.shared.network

import com.base_android_template.utils.Either

interface ExceptionHandler {

    fun handleGeneralException(exception: Throwable): Either.Failure<Exception>
}