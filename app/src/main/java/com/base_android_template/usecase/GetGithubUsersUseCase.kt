package com.base_android_template.usecase

import com.base_android_template.model.response.GithubUserResponse
import com.base_android_template.repository.GithubUsersRepository
import com.base_android_template.shared.network.ApiResponse

class GetGithubUsersUseCase internal constructor(
    private val githubUsersRepository: GithubUsersRepository
) {

    suspend operator fun invoke(): ApiResponse<List<GithubUserResponse>, Error> =
        githubUsersRepository.getGithubUsers()

}