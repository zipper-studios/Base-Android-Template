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
        getGithubUsers()
    }

    private fun getGithubUsers() {
        viewModelScope.launch {
            getGithubUsersUseCase.getGithubUsers().fold({
                githubUsersListAdapter.submitList(it)
            }, {
                Timber.d(
                    GithubUsersViewModel::class.simpleName,
                    "Error fetching Github users list"
                )
            })
        }
    }
}