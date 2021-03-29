package com.base_android_template.feature.settings

import android.widget.RadioGroup
import androidx.core.view.get
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.base_android_template.base.BaseViewModel
import com.base_android_template.shared.Locales
import com.base_android_template.shared.provider.PreferencesProvider
import com.base_android_template.utils.language.LocaleUtils
import java.util.Locale

class SettingsViewModel(private val preferencesProvider: PreferencesProvider) : BaseViewModel() {

    val settingsForm = SettingsForm()
    val recreateActivity: LiveData<Boolean> get() = _recreateActivity

    private val _recreateActivity = MutableLiveData<Boolean>()

    init {
        settingsForm.fields.englishChecked = preferencesProvider.getPrefLocale() == Locales.ENGLISH
    }

    val languageRadioGroupListener: RadioGroup.OnCheckedChangeListener =
        RadioGroup.OnCheckedChangeListener { radioGroup, _ ->
            when (radioGroup.checkedRadioButtonId) {
                radioGroup[0].id -> changeLanguage(Locales.ENGLISH)
                else -> changeLanguage(Locales.ROMANIAN)
            }
        }

    private fun changeLanguage(language: String) {
        LocaleUtils.setLocale(Locale(language))
        preferencesProvider.setPrefLocale(language)
        settingsForm.fields.englishChecked = language == Locales.ENGLISH
        _recreateActivity.value = true
        _recreateActivity.value = false
    }

}