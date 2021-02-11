package com.base_android_template.di

import com.base_android_template.repository.GithubUsersRepository
import com.base_android_template.repository.GithubUsersRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<GithubUsersRepository> { GithubUsersRepositoryImpl(githubUsersApi = get()) }
}