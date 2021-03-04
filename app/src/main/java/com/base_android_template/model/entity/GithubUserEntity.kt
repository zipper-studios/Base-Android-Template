package com.base_android_template.model.entity

import androidx.room.Entity
import androidx.room.Index
import com.base_android_template.model.response.GithubUserResponse
import com.google.gson.annotations.SerializedName

@Entity(
    primaryKeys = ["id"],
    indices = [Index("id")]
)
data class GithubUserEntity(
    @field:SerializedName("login")
    val login: String = "",

    @field:SerializedName("id")
    val id: Int = 0,

    @field:SerializedName("node_id")
    val nodeId: String = "",

    @field:SerializedName("avatar_url")
    val avatarUrl: String = "",

    @field:SerializedName("gravatar_id")
    val grAvatarId: String = "",

    @field:SerializedName("url")
    val url: String = "",

    @field:SerializedName("html_url")
    val htmlUrl: String = "",

    @field:SerializedName("followers_url")
    val followersUrl: String = "",

    @field:SerializedName("following_url")
    val followingUrl: String = "",

    @field:SerializedName("gists_url")
    val gistsUrl: String = "",

    @field:SerializedName("starred_url")
    val starredUrl: String = "",

    @field:SerializedName("subscriptions_url")
    val subscriptionsUrl: String = "",

    @field:SerializedName("organizations_url")
    val organizationsUrl: String = "",

    @field:SerializedName("repos_url")
    val reposUrl: String = "",

    @field:SerializedName("events_url")
    val eventsUrl: String = "",

    @field:SerializedName("received_events_url")
    val receivedEventsUrl: String = "",

    @field:SerializedName("type")
    val type: String = "",

    @field:SerializedName("site_admin")
    val siteAdmin: String = ""
) {
    companion object {
        fun mapToGithubUserEntity(githubUserResponse: GithubUserResponse) =
            GithubUserEntity(
                login = githubUserResponse.login.orEmpty(),
                id = githubUserResponse.id,
                nodeId = githubUserResponse.nodeId.orEmpty(),
                avatarUrl = githubUserResponse.avatarUrl.orEmpty(),
                grAvatarId = githubUserResponse.grAvatarId.orEmpty(),
                url = githubUserResponse.url.orEmpty(),
                htmlUrl = githubUserResponse.htmlUrl.orEmpty(),
                followersUrl = githubUserResponse.followersUrl.orEmpty(),
                followingUrl = githubUserResponse.followingUrl.orEmpty(),
                gistsUrl = githubUserResponse.gistsUrl.orEmpty(),
                starredUrl = githubUserResponse.starredUrl.orEmpty(),
                subscriptionsUrl = githubUserResponse.subscriptionsUrl.orEmpty(),
                organizationsUrl = githubUserResponse.organizationsUrl.orEmpty(),
                reposUrl = githubUserResponse.reposUrl.orEmpty(),
                eventsUrl = githubUserResponse.eventsUrl.orEmpty(),
                receivedEventsUrl = githubUserResponse.receivedEventsUrl.orEmpty(),
                type = githubUserResponse.type.orEmpty(),
                siteAdmin = githubUserResponse.siteAdmin.orEmpty()
            )
    }
}