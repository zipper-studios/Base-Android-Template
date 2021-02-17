package com.base_android_template.di

import com.base_android_template.GetGithubUsersUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetGithubUsersUseCase( githubUsersRepository = get()) }
}