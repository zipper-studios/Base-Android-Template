package com.base_android_template.repository

import com.base_android_template.model.response.GithubUserResponse
import com.base_android_template.shared.network.ApiResponse

interface GithubUsersRepository {

    suspend fun getGithubUsers(): ApiResponse<List<GithubUserResponse>, Error>
}