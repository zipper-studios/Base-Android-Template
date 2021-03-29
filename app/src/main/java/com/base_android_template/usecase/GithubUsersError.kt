package com.base_android_template.usecase

sealed class GithubUsersError {
    object EmptyLocalGithubUsersListException : GithubUsersError()
    object GeneralError :GithubUsersError()
}