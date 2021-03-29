package com.base_android_template.feature.github_users

import androidx.recyclerview.widget.DiffUtil
import com.base_android_template.model.entity.GithubUserEntity

class GithubUsersCallback : DiffUtil.ItemCallback<GithubUserEntity>() {
    override fun areItemsTheSame(
        oldItem: GithubUserEntity,
        newItem: GithubUserEntity
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: GithubUserEntity,
        newItem: GithubUserEntity
    ): Boolean = oldItem == newItem

}