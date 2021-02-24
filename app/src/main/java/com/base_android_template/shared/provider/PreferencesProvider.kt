package com.base_android_template.shared.provider

interface PreferencesProvider {

    fun setPrefLocale(locale: String)

    fun getPrefLocale(): String
}