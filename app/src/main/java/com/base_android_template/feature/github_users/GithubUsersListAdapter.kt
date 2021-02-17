package com.base_android_template.feature.github_users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.base_android_template.databinding.ItemGithubUserBinding
import com.base_android_template.model.response.GithubUserResponse

class GithubUsersListAdapter :
    ListAdapter<GithubUserResponse, GithubUsersListViewHolder>(GithubUsersCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUsersListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return GithubUsersListViewHolder(
            ItemGithubUserBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GithubUsersListViewHolder, position: Int) {
        val item = getItem(position)

        item?.let { holder.bind(it) }
    }

}