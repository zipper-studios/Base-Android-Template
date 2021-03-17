package com.base_android_template.feature.github_users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.base_android_template.base.BaseViewModel
import com.base_android_template.shared.network.Exception
import com.base_android_template.usecase.GetGithubUsersUseCase
import kotlinx.coroutines.launch
import timber.log.Timber

class GithubUsersViewModel(
    private val getGithubUsersUseCase: GetGithubUsersUseCase
) :
    BaseViewModel() {

    val githubUsersListAdapter = GithubUsersListAdapter()
    val exception: LiveData<Exception> get() = _exception

    private val _exception = MutableLiveData<Exception>()

    init {
        getLocalCartItems()
    }

    private fun getLocalCartItems() {
        postLoading(true)
        viewModelScope.launch {
            getGithubUsersUseCase.getLocalGithubUsers().fold(
                {
                    handleException(it)
                },
                {
                    githubUsersListAdapter.submitList(it)
                    postLoading(false)
                }
            )
        }
    }

    fun getRemoteGithubUsers() {
        viewModelScope.launch {
            getGithubUsersUseCase.getRemoteAndSaveLocalGithubUsers().fold(
                {
                    postLoading(false)
                    handleException(it)
                },
                {
                    githubUsersListAdapter.submitList(it)
                    postLoading(false)
                }
            )
        }
    }

    private fun handleException(exception: Exception) {
        Timber.d(exception.toString())
        postLoading(false)
        _exception.value = exception
    }
}