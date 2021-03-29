package com.base_android_template.repository

import com.base_android_template.model.response.GithubUserResponse
import com.base_android_template.remote.GithubUsersListRemote
import com.base_android_template.utils.Either
import com.base_android_template.usecase.GithubUsersError

class GithubUsersRepositoryImpl(
    private val githubUsersListRemote: GithubUsersListRemote
) :
    GithubUsersRepository {

    override suspend fun getLocalGithubUsers(): Either<GithubUsersError, List<GithubUserResponse>> =
        githubUsersListRemote.getGithubUsersList()
}