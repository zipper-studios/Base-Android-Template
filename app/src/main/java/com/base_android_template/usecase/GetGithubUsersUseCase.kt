package com.base_android_template.usecase

import com.base_android_template.model.entity.GithubUserEntity
import com.base_android_template.utils.Either

interface GetGithubUsersUseCase {

    suspend fun getRemoteAndSaveLocalGithubUsers(): Either<GithubUsersError, List<GithubUserEntity>>

    suspend fun getLocalGithubUsers(): Either<GithubUsersError, List<GithubUserEntity>>
}