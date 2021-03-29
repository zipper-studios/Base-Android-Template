package com.base_android_template.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.base_android_template.shared.model.NavigationCommand
import com.base_android_template.utils.SingleLiveEvent

/**
 * Represents the base class that will be extended by any ViewModel in the app.
 * It contains public methods that can be called from all ViewModels in the hierarchy
 * to send commands to the BaseFragment
 *
 */
open class BaseViewModel : ViewModel() {

    val navigationCommand: SingleLiveEvent<NavigationCommand?>
        get() = _navigationCommand
    val loading: SingleLiveEvent<Boolean>
        get() = _loading
    val message: SingleLiveEvent<String>
        get() = _message
    val messageResId: SingleLiveEvent<Int>
        get() = _messageResId

    private val _navigationCommand = SingleLiveEvent<NavigationCommand?>()
    private val _loading = SingleLiveEvent<Boolean>()
    private val _message = SingleLiveEvent<String>()
    private val _messageResId = SingleLiveEvent<Int>()

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

    /**
     * Call this method when want to display a message in a Toast
     *
     * @param toDisplay String. The message to be displayed
     */
    fun postMessage(toDisplay: String) {
        _message.postValue(toDisplay)
    }

    /**
     * Call this method when want to display a message in a Toast
     *
     * @param id Int. The id of the string to be displayed
     */
    fun postMessageResId(id: Int) {
        _messageResId.postValue(id)
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