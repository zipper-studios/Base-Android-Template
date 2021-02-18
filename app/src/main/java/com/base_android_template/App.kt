package com.base_android_template

import android.app.Application
import com.base_android_template.di.createCoreModules
import com.base_android_template.feature.github_users.githubUsersModule
import com.orhanobut.hawk.Hawk
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(getAppModules())
        }

        Hawk.init(this).build()

        initCalligraphy()
    }

    private fun getAppModules() = createCoreModules() +
            githubUsersModule

    private fun initCalligraphy() {
        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath("fonts/lato_regular.ttf")
                            .build()
                    )
                )
                .build()
        )
    }
}