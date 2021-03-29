package com.base_android_template.remote

import com.base_android_template.model.response.GithubUserResponse
import com.base_android_template.usecase.GithubUsersError
import com.base_android_template.utils.Either
import retrofit2.Response
import java.io.IOException

class GithubUsersListRemoteImpl(
    private val githubUsersListService: GithubUsersApi
) : GithubUsersListRemote {

    override suspend fun getGithubUsersList(): Either<GithubUsersError, List<GithubUserResponse>> =
        makeRequest {
            githubUsersListService.getGithubUsers()
        }

    private suspend fun makeRequest(block: suspend () -> Response<List<GithubUserResponse>>): Either<GithubUsersError, List<GithubUserResponse>> {
        return try {
            val response = block.invoke()
            handleResponse(response)
        } catch (exception: IOException) {
            Either.Failure(GithubUsersError.GeneralError)
        }
    }

    private fun handleResponse(response: Response<List<GithubUserResponse>>): Either<GithubUsersError, List<GithubUserResponse>> {
        return if (response.isSuccessful) {
            handleSuccess(response)
        } else {
            Either.Failure(GithubUsersError.GeneralError)
        }
    }

    private fun handleSuccess(response: Response<List<GithubUserResponse>>): Either.Success<List<GithubUserResponse>> {
        val githubUsersList = response.body() ?: listOf()
        return Either.Success(githubUsersList)
    }
}