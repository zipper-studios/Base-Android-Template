package com.base_android_template.feature.github_users

import android.os.Bundle
import com.base_android_template.R
import com.base_android_template.base.BaseFragment
import com.base_android_template.databinding.FragmentGithubUsersBinding
import com.base_android_template.shared.network.Exception
import org.koin.androidx.viewmodel.ext.android.viewModel

class GithubUsersFragment :
    BaseFragment<FragmentGithubUsersBinding, GithubUsersViewModel>(R.layout.fragment_github_users) {

    override val viewModel: GithubUsersViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.exception.observe(viewLifecycleOwner, {
            when (it) {
                is Exception.EmptyLocalGithubUsersLisException -> {
                    viewModel.getRemoteGithubUsers()
                }
                else -> {
                    viewModel.postMessage(getString(R.string.error_fetching_users_list))
                }
            }
        })
    }
}