package com.base_android_template.di

import com.base_android_template.usecase.GetGithubUsersUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetGithubUsersUseCase( githubUsersRepository = get()) }
}