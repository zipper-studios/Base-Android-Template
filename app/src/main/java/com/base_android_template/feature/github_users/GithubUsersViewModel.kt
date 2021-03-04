package com.base_android_template.feature.github_users

import androidx.lifecycle.viewModelScope
import com.base_android_template.base.BaseViewModel
import com.base_android_template.usecase.GetGithubUsersUseCase
import kotlinx.coroutines.launch
import timber.log.Timber

class GithubUsersViewModel(
    private val getGithubUsersUseCase: GetGithubUsersUseCase
) :
    BaseViewModel() {

    val githubUsersListAdapter = GithubUsersListAdapter()

    init {
        getLocalCartItems()
    }

    private fun getLocalCartItems() {
        viewModelScope.launch {
            getGithubUsersUseCase.getLocalGithubUsers().fold(
                {
                    getRemoteGithubUsers()
                },
                {
                    githubUsersListAdapter.submitList(it)
                }
            )
        }
    }

    private fun getRemoteGithubUsers() {
        viewModelScope.launch {
            getGithubUsersUseCase.getRemoteAndSaveLocalGithubUsers().fold(
                {
                    Timber.d(
                        GithubUsersViewModel::class.simpleName,
                        "Error fetching Github users list"
                    )
                },
                {
                    githubUsersListAdapter.submitList(it)
                }
            )
        }
    }
}