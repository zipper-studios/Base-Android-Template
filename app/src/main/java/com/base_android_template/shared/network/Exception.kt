package com.base_android_template.shared.network

sealed class Exception {
    object NetworkException : Exception()
    object ServerException : Exception()
    object SaveGithubUsersException : Exception()
    object EmptyLocalGithubUsersLisException : Exception()
    data class UnknownException(val exception: Throwable) : Exception()
}