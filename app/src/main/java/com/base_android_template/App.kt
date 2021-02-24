package com.base_android_template

import android.app.Application
import android.content.res.Configuration
import com.base_android_template.di.getAppModules
import com.base_android_template.shared.Locales
import com.base_android_template.utils.language.LocaleUtils
import com.orhanobut.hawk.Hawk
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import java.util.Locale

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(getAppModules())
        }

        initLocale()

        Hawk.init(this).build()

        initCalligraphy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleUtils.updateConfig(this, newConfig)
    }

    private fun initLocale() {
        val locale = Locale(Locales.ENGLISH)
        LocaleUtils.setLocale(locale)
        LocaleUtils.updateConfig(this, baseContext.resources.configuration)
    }

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