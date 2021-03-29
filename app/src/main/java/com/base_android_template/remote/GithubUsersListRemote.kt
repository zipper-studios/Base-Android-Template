package com.base_android_template.remote

import com.base_android_template.model.response.GithubUserResponse
import com.base_android_template.utils.Either
import com.base_android_template.usecase.GithubUsersError

interface GithubUsersListRemote {

    suspend fun getGithubUsersList(): Either<GithubUsersError, List<GithubUserResponse>>

}