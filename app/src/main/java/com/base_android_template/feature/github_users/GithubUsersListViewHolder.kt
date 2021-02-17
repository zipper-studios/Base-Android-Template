package com.base_android_template.feature.github_users

import androidx.recyclerview.widget.RecyclerView
import com.base_android_template.databinding.ItemGithubUserBinding
import com.base_android_template.model.response.GithubUserResponse

class GithubUsersListViewHolder(private val binding: ItemGithubUserBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(githubUserResponse: GithubUserResponse) {
        binding.item = githubUserResponse
        binding.executePendingBindings()
    }
}