package com.base_android_template.shared.network

import java.io.IOException

sealed class ApiResponse<out T : Any, out U : Any> {
    /**
     * Success response with body
     */
    data class Success<T : Any>(val body: T?) : ApiResponse<T, Nothing>()

    /**
     * Failure response with body
     */
    data class ServerError<U : Any>(val body: U, val code: Int) : ApiResponse<Nothing, U>()

    /**
     * Network error
     */
    data class NetworkError(val error: IOException) : ApiResponse<Nothing, Nothing>()

    /**
     * For example, json parsing error
     */
    data class UnknownError(val error: Throwable?) : ApiResponse<Nothing, Nothing>()

    fun fold(
        funSuccess: (T?) -> Any,
        funFailure: (Error) -> Any
    ): Any =
        when (this) {
            is Success -> funSuccess(body)
            is ServerError -> funFailure(Error.ServerError(body))
            is NetworkError -> funFailure(Error.NetworkError(error))
            is UnknownError -> funFailure(Error.UnknownError(error))
        }
}