package com.base_android_template.utils.language

import android.app.Application
import android.content.res.Configuration
import android.content.res.Resources
import android.view.ContextThemeWrapper
import java.util.Locale

/**
 * Utility class to change app locale settings.
 */

object LocaleUtils {

    var currentLocale: Locale? = null

    /**
     * Set the new locale
     *
     * @param locale Locale. The new locale with the format en_EN, de_DE, ro_RO, etc
     */
    fun setLocale(locale: Locale?) {
        currentLocale = locale
        currentLocale?.let {
            Locale.setDefault(it)
        }
    }

    /**
     * Update the configuration base on currentLocale.
     * Used for activities
     *
     * @param wrapper ContextThemeWrapper. The activity ContextWrapper
     */
    fun updateConfig(wrapper: ContextThemeWrapper) {
        if (currentLocale != null) {
            val configuration = Configuration()
            configuration.setLocale(currentLocale)
            wrapper.applyOverrideConfiguration(configuration)
        }
    }

    /**
     * Update the configuration base on currentLocale.
     * Used for application
     *
     * @param app Application. The application instance
     * @param configuration Configuration. The new configuration from `onConfigurationChanged` or the
     * existing configuration when initialize the app
     */
    fun updateConfig(app: Application, configuration: Configuration?) {
        if (currentLocale != null) {
            val config = Configuration(configuration)
            config.setLocale(currentLocale)
            val resources: Resources = app.baseContext.resources
            resources.updateConfiguration(config, resources.displayMetrics)
        }
    }
}