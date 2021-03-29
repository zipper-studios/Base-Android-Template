package com.base_android_template.di

import com.base_android_template.persistance.database.GithubUsersDatabase
import com.base_android_template.repository.GithubUsersRepository
import com.base_android_template.usecase.GetGithubUsersUseCase
import com.base_android_template.usecase.GetGithubUsersUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {

    fun getGithubUsersUseCase(
        githubUsersRepository: GithubUsersRepository,
        githubUsersDatabase: GithubUsersDatabase,
    ): GetGithubUsersUseCase = GetGithubUsersUseCaseImpl(
        githubUsersRepository = githubUsersRepository,
        githubUsersListDao = githubUsersDatabase.githubUsersListDao()
    )

    factory { getGithubUsersUseCase(get(), get()) }
}