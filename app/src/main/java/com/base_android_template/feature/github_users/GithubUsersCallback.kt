package com.base_android_template.feature.github_users

import androidx.recyclerview.widget.DiffUtil
import com.base_android_template.model.response.GithubUserResponse

class GithubUsersCallback : DiffUtil.ItemCallback<GithubUserResponse>() {
    override fun areItemsTheSame(
        oldItem: GithubUserResponse,
        newItem: GithubUserResponse
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: GithubUserResponse,
        newItem: GithubUserResponse
    ): Boolean = oldItem == newItem

}