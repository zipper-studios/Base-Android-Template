package com.base_android_template

import com.base_android_template.model.GithubUserModel
import com.base_android_template.repository.GithubUsersRepository
import com.base_android_template.shared.network.ApiResponse
import java.util.UUID

class GetGithubUsersUseCase internal constructor(
    private val githubUsersRepository: GithubUsersRepository
) {

    suspend operator fun invoke(): ApiResponse<List<GithubUserModel>, Error> =
        githubUsersRepository.getGithubUsers()

}