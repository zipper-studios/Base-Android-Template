package com.base_android_template.repository

import com.base_android_template.api.GithubUsersApi
import com.base_android_template.model.response.GithubUserResponse
import com.base_android_template.shared.network.ApiResponse

class GithubUsersRepositoryImpl(
    private val githubUsersApi: GithubUsersApi
) :
    GithubUsersRepository {

    override suspend fun getGithubUsers(): ApiResponse<List<GithubUserResponse>, Error> = githubUsersApi.getGithubUsers()
}