package com.base_android_template.feature.favorite_users

import com.base_android_template.R
import com.base_android_template.base.BaseFragment
import com.base_android_template.databinding.FragmentFavoriteGithubUsersBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteGithubUsersFragment :
    BaseFragment<FragmentFavoriteGithubUsersBinding, FavoriteGithubUsersViewModel>(R.layout.fragment_favorite_github_users) {

    override val viewModel: FavoriteGithubUsersViewModel by viewModel()

}