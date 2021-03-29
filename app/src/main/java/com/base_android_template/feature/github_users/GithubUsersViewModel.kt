package com.base_android_template.feature.github_users

import androidx.lifecycle.viewModelScope
import com.base_android_template.R
import com.base_android_template.base.BaseViewModel
import com.base_android_template.usecase.GetGithubUsersUseCase
import com.base_android_template.usecase.GithubUsersError
import kotlinx.coroutines.launch

class GithubUsersViewModel(
    private val getGithubUsersUseCase: GetGithubUsersUseCase
) :
    BaseViewModel() {

    val githubUsersListAdapter = GithubUsersListAdapter()

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

    private fun getRemoteGithubUsers() {
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
        postLoading(false)
        handleGithubUsersError(githubUsersError)
    }

    private fun handleGithubUsersError(githubUsersError: GithubUsersError) {
        when (githubUsersError) {
            is GithubUsersError.EmptyLocalGithubUsersListException -> {
                getRemoteGithubUsers()
            }
            else -> {
                postMessageResId(R.string.error_fetching_users_list)
            }
        }
    }
}