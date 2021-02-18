package com.base_android_template.utils.language

import android.app.Application
import android.content.res.Configuration
import android.content.res.Resources
import android.view.ContextThemeWrapper
import java.util.Locale

object LocaleUtils {

    var currentLocale: Locale? = null

    fun setLocale(locale: Locale?) {
        currentLocale = locale
        currentLocale?.let {
            Locale.setDefault(it)
        }
    }

    fun updateConfig(wrapper: ContextThemeWrapper) {
        if (currentLocale != null) {
            val configuration = Configuration()
            configuration.setLocale(currentLocale)
            wrapper.applyOverrideConfiguration(configuration)
        }
    }

    fun updateConfig(app: Application, configuration: Configuration?) {
        if (currentLocale != null) {
            val config = Configuration(configuration)
            config.setLocale(currentLocale)
            val resources: Resources = app.baseContext.resources
            resources.updateConfiguration(config, resources.displayMetrics)
        }
    }
}