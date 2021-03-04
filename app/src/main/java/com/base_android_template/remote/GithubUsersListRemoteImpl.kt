package com.base_android_template.remote

import com.base_android_template.model.response.GithubUserResponse
import com.base_android_template.utils.Either
import com.base_android_template.shared.network.Exception
import com.base_android_template.shared.network.ExceptionHandler
import com.base_android_template.shared.network.NetworkHandler
import retrofit2.Response

class GithubUsersListRemoteImpl(
    private val githubUsersListService: GithubUsersApi,
    private val networkHandler: NetworkHandler,
    private val exceptionHandler: ExceptionHandler
) : GithubUsersListRemote {

    override suspend fun getGithubUsersList(): Either<Exception, List<GithubUserResponse>> = makeRequest {
        githubUsersListService.getGithubUsers()
    }

    private suspend fun makeRequest(block: suspend () -> Response<List<GithubUserResponse>>): Either<Exception, List<GithubUserResponse>> {
        if (!networkHandler.hasNetworkConnection()) {
            return Either.Failure(Exception.NetworkException)
        }
        return try {
            val response = block.invoke()
            handleResponse(response)
        } catch (exception: Throwable) {
            exceptionHandler.handleGeneralException(exception)
        }
    }

    private fun handleResponse(response: Response<List<GithubUserResponse>>): Either<Exception, List<GithubUserResponse>> {
        return if (response.isSuccessful) {
            handleSuccess(response)
        } else {
            Either.Failure(Exception.ServerException)
        }
    }

    private fun handleSuccess(response: Response<List<GithubUserResponse>>): Either.Success<List<GithubUserResponse>> {
        val githubUsersList = response.body() ?: listOf()
        return Either.Success(githubUsersList)
    }
}