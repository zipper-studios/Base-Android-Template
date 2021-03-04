package com.base_android_template.remote

import com.base_android_template.model.response.GithubUserResponse
import com.base_android_template.utils.Either
import com.base_android_template.shared.network.Exception

interface GithubUsersListRemote {

    suspend fun getGithubUsersList(): Either<Exception, List<GithubUserResponse>>

}