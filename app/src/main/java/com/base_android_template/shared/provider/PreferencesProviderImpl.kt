package com.base_android_template.shared.provider

import com.base_android_template.shared.HawkKeys.HAWK_PREF_LOCALE
import com.base_android_template.shared.Locales
import com.orhanobut.hawk.Hawk

class PreferencesProviderImpl : PreferencesProvider {

    override fun setPrefLocale(locale: String) {
        Hawk.put(HAWK_PREF_LOCALE, locale)
    }

    override fun getPrefLocale(): String = Hawk.get(HAWK_PREF_LOCALE, Locales.ENGLISH )
}