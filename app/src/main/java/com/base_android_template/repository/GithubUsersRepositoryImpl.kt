package com.base_android_template.repository

import com.base_android_template.model.response.GithubUserResponse
import com.base_android_template.remote.GithubUsersListRemote
import com.base_android_template.utils.Either
import com.base_android_template.shared.network.Exception

class GithubUsersRepositoryImpl(
    private val githubUsersListRemote: GithubUsersListRemote
) :
    GithubUsersRepository {

    override suspend fun getLocalGithubUsers(): Either<Exception, List<GithubUserResponse>> =
        githubUsersListRemote.getGithubUsersList()
}