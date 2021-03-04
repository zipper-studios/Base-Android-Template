package com.base_android_template.usecase

import com.base_android_template.model.entity.GithubUserEntity
import com.base_android_template.utils.Either
import com.base_android_template.shared.network.Exception

interface GetGithubUsersUseCase {

    suspend fun getRemoteAndSaveLocalGithubUsers(): Either<Exception, List<GithubUserEntity>>

    suspend fun getLocalGithubUsers(): Either<Exception, List<GithubUserEntity>>
}