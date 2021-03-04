package com.base_android_template.remote

import com.base_android_template.model.response.GithubUserResponse
import retrofit2.Response
import retrofit2.http.GET

interface GithubUsersApi {

    @GET("/users")
    suspend fun getGithubUsers(): Response<List<GithubUserResponse>>
}