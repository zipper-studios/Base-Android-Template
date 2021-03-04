package com.base_android_template.feature.github_users

import androidx.recyclerview.widget.RecyclerView
import com.base_android_template.databinding.ItemGithubUserBinding
import com.base_android_template.model.entity.GithubUserEntity

class GithubUsersListViewHolder(private val binding: ItemGithubUserBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(githubUserItem: GithubUserEntity) {
        binding.item = githubUserItem
        binding.executePendingBindings()
    }
}