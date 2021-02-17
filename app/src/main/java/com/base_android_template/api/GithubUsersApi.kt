package com.base_android_template.api

import com.base_android_template.model.response.GithubUserResponse
import com.base_android_template.shared.network.ApiResponse
import retrofit2.http.GET

interface GithubUsersApi {

    @GET("/users")
    suspend fun getGithubUsers(): ApiResponse<List<GithubUserResponse>, Error>
}