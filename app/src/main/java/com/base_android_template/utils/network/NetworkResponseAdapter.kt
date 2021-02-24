package com.base_android_template.utils.network

import com.base_android_template.shared.network.ApiResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Converter
import java.lang.reflect.Type

class NetworkResponseAdapter<S : Any, E : Any>(
    private val successType: Type,
    private val errorBodyConverter: Converter<ResponseBody, E>
) : CallAdapter<S, Call<ApiResponse<S, E>>> {

    override fun responseType(): Type = successType

    override fun adapt(call: Call<S>): Call<ApiResponse<S, E>> {
        return NetworkResponseCall(
            call,
            errorBodyConverter
        )
    }
}