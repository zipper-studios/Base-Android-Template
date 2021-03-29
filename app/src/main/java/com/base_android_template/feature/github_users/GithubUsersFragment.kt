package com.base_android_template.feature.github_users

import com.base_android_template.R
import com.base_android_template.base.BaseFragment
import com.base_android_template.databinding.FragmentGithubUsersBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GithubUsersFragment :
    BaseFragment<FragmentGithubUsersBinding, GithubUsersViewModel>(R.layout.fragment_github_users) {

    override val viewModel: GithubUsersViewModel by viewModel()
}