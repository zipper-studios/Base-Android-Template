package com.base_android_template.di

import com.base_android_template.api.GithubUsersApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    fun provideUserApi(retrofit: Retrofit): GithubUsersApi {
        return retrofit.create(GithubUsersApi::class.java)
    }

    single { provideUserApi(get()) }
}