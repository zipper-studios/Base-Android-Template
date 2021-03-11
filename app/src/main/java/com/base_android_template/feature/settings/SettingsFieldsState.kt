package com.base_android_template.feature.settings

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.base_android_template.BR

data class SettingsFieldsState(
    var _englishChecked: Boolean = false
) :
    BaseObservable() {

    var englishChecked: Boolean
        @Bindable get() = _englishChecked
        set(value) {
            _englishChecked = value
            notifyPropertyChanged(BR.englishChecked)
        }
}
