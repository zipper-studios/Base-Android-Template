package com.base_android_template.usecase

import com.base_android_template.model.response.GithubUserResponse
import com.base_android_template.shared.network.ApiResponse

interface GetGithubUsersUseCase {

    suspend fun getGithubUsers(): ApiResponse<List<GithubUserResponse>, Error>
}