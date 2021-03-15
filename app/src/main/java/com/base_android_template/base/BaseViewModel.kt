package com.base_android_template.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.base_android_template.shared.model.NavigationCommand

open class BaseViewModel : ViewModel() {

    val navigationCommand: LiveData<NavigationCommand?>
        get() = _navigationCommand
    val loading: LiveData<Boolean>
        get() = _loading
    val message: LiveData<String>
        get() = _message

    private val _navigationCommand = MutableLiveData<NavigationCommand?>()
    private val _loading = MutableLiveData<Boolean>()
    private val _message = MutableLiveData<String>()

    fun postNavigationCommand(direction: NavDirections) {
        _navigationCommand.postValue(NavigationCommand.PerformNavAction(direction))
    }

    fun postNavigateUpCommand() {
        _navigationCommand.postValue(NavigationCommand.PerformNavUp)
    }

    fun clearLastNavigationCommand() {
        _navigationCommand.value = null
    }

    fun postLoading(loading: Boolean) {
        _loading.postValue(loading)
    }

    fun postMessage(toDisplay: String) {
        _message.postValue(toDisplay)
    }

    fun clearLastMessage() {
        _message.value = ""
    }
}