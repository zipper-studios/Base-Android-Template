package com.base_android_template.di

import com.base_android_template.remote.GithubUsersApi
import com.base_android_template.remote.GithubUsersListRemote
import com.base_android_template.remote.GithubUsersListRemoteImpl
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    fun provideUserApi(retrofit: Retrofit): GithubUsersApi =
        retrofit.create(GithubUsersApi::class.java)

    single<GithubUsersListRemote> {
        GithubUsersListRemoteImpl(
            githubUsersListService = get(),
            exceptionHandler = get()
        )
    }

    single { provideUserApi(get()) }
}