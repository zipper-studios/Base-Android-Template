package com.base_android_template.di

import com.base_android_template.feature.github_users.githubUsersModule

fun getAppModules() = createCoreModules() + githubUsersModule