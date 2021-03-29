package com.base_android_template.feature.github_users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.base_android_template.base.BaseViewModel
import com.base_android_template.usecase.GetGithubUsersUseCase
import com.base_android_template.usecase.GithubUsersError
import kotlinx.coroutines.launch
import timber.log.Timber

class GithubUsersViewModel(
    private val getGithubUsersUseCase: GetGithubUsersUseCase
) :
    BaseViewModel() {

    val githubUsersListAdapter = GithubUsersListAdapter()
    val githubUsersError: LiveData<GithubUsersError> get() = _githubUsersError

    private val _githubUsersError = MutableLiveData<GithubUsersError>()

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

    private fun handleException(githubUsersError: GithubUsersError) {
        Timber.d(this.githubUsersError.toString())
        postLoading(false)
        _githubUsersError.value = githubUsersError
    }
}