package com.base_android_template.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.base_android_template.shared.model.NavigationCommand

open class BaseViewModel : ViewModel() {

    val navigationCommand: LiveData<NavigationCommand?>
        get() = _navigationCommand

    private val _navigationCommand = MutableLiveData<NavigationCommand?>()

    fun postNavigationCommand(direction: NavDirections) {
        _navigationCommand.postValue(NavigationCommand.PerformNavAction(direction))
    }

    fun postNavigateUpCommand() {
        _navigationCommand.postValue(NavigationCommand.PerformNavUp)
    }

    fun clearLastNavigationCommand() {
        _navigationCommand.value = null
    }
}