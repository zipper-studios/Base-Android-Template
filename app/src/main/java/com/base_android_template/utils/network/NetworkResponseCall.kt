package com.base_android_template.utils.network

import com.base_android_template.shared.network.ApiResponse
import okhttp3.Request
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response
import java.io.EOFException
import java.io.IOException

internal class NetworkResponseCall<S : Any, E : Any>(
    private val delegate: Call<S>,
    private val errorConverter: Converter<ResponseBody, E>
) : Call<ApiResponse<S, E>> {

    override fun enqueue(callback: Callback<ApiResponse<S, E>>) {
        return delegate.enqueue(object : Callback<S> {
            override fun onResponse(call: Call<S>, response: Response<S>) {
                var error: E? = null
                response.errorBody()?.let {
                    error = try {
                        errorConverter.convert(it)
                    } catch (c: EOFException) {
                        null
                    }
                }
                val body = response.body()
                val code = response.code()

                if (response.isSuccessful) {
                    postSuccessfulResponse(body, callback)
                } else {
                    postFailedResponse(error, callback, code)
                }
            }

            override fun onFailure(call: Call<S>, throwable: Throwable) {
                val networkResponse = when (throwable) {
                    is IOException -> ApiResponse.NetworkError(throwable)
                    else -> ApiResponse.UnknownError(throwable)
                }
                callback.onResponse(this@NetworkResponseCall, Response.success(networkResponse))
            }

        })
    }

    private fun postFailedResponse(
        error: E?,
        callback: Callback<ApiResponse<S, E>>,
        code: Int
    ) {
        error?.let {
            callback.onResponse(
                this@NetworkResponseCall,
                Response.success(ApiResponse.ServerError(it, code))
            )
        } ?: callback.onResponse(
            this@NetworkResponseCall,
            Response.success(ApiResponse.UnknownError(null))
        )
    }

    private fun postSuccessfulResponse(
        body: S?,
        callback: Callback<ApiResponse<S, E>>
    ) {
        callback.onResponse(
            this@NetworkResponseCall,
            Response.success(ApiResponse.Success(body))
        )
    }

    override fun isExecuted() = delegate.isExecuted

    override fun clone() =
        NetworkResponseCall(
            delegate.clone(),
            errorConverter
        )

    override fun isCanceled() = delegate.isCanceled

    override fun cancel() = delegate.cancel()

    override fun execute(): Response<ApiResponse<S, E>> {
        throw UnsupportedOperationException("NetworkResponseCall doesn't support execute")
    }

    override fun request(): Request = delegate.request()
}