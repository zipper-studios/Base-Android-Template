package com.base_android_template

import android.app.Application
import com.base_android_template.di.createCoreModules
import com.base_android_template.feature.github_users.githubUsersModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(getAppModules())
        }
    }

    private fun getAppModules() = createCoreModules() +
            githubUsersModule
}