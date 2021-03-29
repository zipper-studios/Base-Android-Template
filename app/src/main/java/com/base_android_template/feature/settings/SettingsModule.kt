package com.base_android_template.feature.settings

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val settingsModule = module {
    viewModel { SettingsViewModel(preferencesProvider = get()) }
}