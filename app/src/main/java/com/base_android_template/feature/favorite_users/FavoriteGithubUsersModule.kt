package com.base_android_template.feature.favorite_users

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteGithubUsersModule = module {
    viewModel { FavoriteGithubUsersViewModel() }
}