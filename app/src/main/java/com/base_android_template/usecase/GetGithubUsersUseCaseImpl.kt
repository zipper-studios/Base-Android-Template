package com.base_android_template.usecase

import com.base_android_template.model.response.GithubUserResponse
import com.base_android_template.repository.GithubUsersRepository
import com.base_android_template.shared.network.ApiResponse

class GetGithubUsersUseCaseImpl internal constructor(
    private val githubUsersRepository: GithubUsersRepository
) : GetGithubUsersUseCase {

    override suspend fun getGithubUsers(): ApiResponse<List<GithubUserResponse>, Error> =
        githubUsersRepository.getGithubUsers()
}