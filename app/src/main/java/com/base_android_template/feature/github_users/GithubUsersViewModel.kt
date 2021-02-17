package com.base_android_template.feature.github_users

import androidx.lifecycle.viewModelScope
import com.base_android_template.GetGithubUsersUseCase
import com.base_android_template.base.BaseViewModel
import kotlinx.coroutines.launch

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
            getGithubUsersUseCase().fold({
               githubUsersListAdapter.submitList(it)
            }, {
            })
        }
    }
}