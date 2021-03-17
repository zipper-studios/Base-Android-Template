package com.base_android_template.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.base_android_template.shared.model.NavigationCommand

/**
 * Represents the base class that will be extended by any ViewModel in the app.
 * It contains public methods that can be called from all ViewModels in the hierarchy
 * to send commands to the BaseFragment
 *
 */
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

    /**
     * Call this method when want to navigate between fragments via NavDirections
     *
     * @param direction NavDirections. The generated method for navigation action
     * that you've defined in the nav graph
     */
    fun postNavigationCommand(direction: NavDirections) {
        _navigationCommand.postValue(NavigationCommand.PerformNavAction(direction))
    }

    /**
     * Call this method when want to navigate up in fragments
     *
     */
    fun postNavigateUpCommand() {
        _navigationCommand.postValue(NavigationCommand.PerformNavUp)
    }

    fun clearLastNavigationCommand() {
        _navigationCommand.value = null
    }

    /**
     * Call this method when want to display a message in a Toast
     *
     * @param toDisplay String. The message to be displayed
     */
    fun postMessage(toDisplay: String) {
        _message.postValue(toDisplay)
    }

    fun clearLastMessage() {
        _message.value = ""
    }

    /**
     * Call this method when want to show/hide the loading progress bar
     *
     * @param loading Boolean. If:
     * - true: show the loading progress bar
     * - false: hide th loading progress bar
     */
    fun postLoading(loading: Boolean) {
        _loading.postValue(loading)
    }

}