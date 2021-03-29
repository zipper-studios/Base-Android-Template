package com.base_android_template.repository

import com.base_android_template.model.response.GithubUserResponse
import com.base_android_template.utils.Either
import com.base_android_template.usecase.GithubUsersError

interface GithubUsersRepository {

    suspend fun getLocalGithubUsers(): Either<GithubUsersError, List<GithubUserResponse>>
}