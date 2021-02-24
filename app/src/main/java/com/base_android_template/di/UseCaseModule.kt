package com.base_android_template.di

import com.base_android_template.usecase.GetGithubUsersUseCase
import com.base_android_template.usecase.GetGithubUsersUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetGithubUsersUseCase> { GetGithubUsersUseCaseImpl(githubUsersRepository = get()) }
}