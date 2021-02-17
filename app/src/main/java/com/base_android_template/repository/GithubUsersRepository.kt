package com.base_android_template.repository

import com.base_android_template.model.GithubUserModel
import com.base_android_template.shared.network.ApiResponse

interface GithubUsersRepository {

    suspend fun getGithubUsers(): ApiResponse<List<GithubUserModel>, Error>
}