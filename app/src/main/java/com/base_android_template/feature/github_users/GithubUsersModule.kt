package com.base_android_template.feature.github_users

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val githubUsersModule = module {
    viewModel { GithubUsersViewModel(getGithubUsersUseCase = get()) }
}