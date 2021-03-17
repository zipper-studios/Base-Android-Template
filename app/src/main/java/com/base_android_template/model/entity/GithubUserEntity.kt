package com.base_android_template.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import com.base_android_template.model.response.GithubUserResponse

@Entity(
    primaryKeys = ["id"],
    indices = [Index("id")]
)
data class GithubUserEntity(
    @ColumnInfo(name = "login")
    val login: String,

    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "node_id")
    val nodeId: String,

    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String,

    @ColumnInfo(name = "gravatar_id")
    val grAvatarId: String,

    @ColumnInfo(name = "url")
    val url: String,

    @ColumnInfo(name = "html_url")
    val htmlUrl: String,

    @ColumnInfo(name = "followers_url")
    val followersUrl: String,

    @ColumnInfo(name = "following_url")
    val followingUrl: String,

    @ColumnInfo(name = "gists_url")
    val gistsUrl: String,

    @ColumnInfo(name = "starred_url")
    val starredUrl: String,

    @ColumnInfo(name = "subscriptions_url")
    val subscriptionsUrl: String,

    @ColumnInfo(name = "organizations_url")
    val organizationsUrl: String,

    @ColumnInfo(name = "repos_url")
    val reposUrl: String,

    @ColumnInfo(name = "events_url")
    val eventsUrl: String,

    @ColumnInfo(name = "received_events_url")
    val receivedEventsUrl: String,

    @ColumnInfo(name = "type")
    val type: String,

    @ColumnInfo(name = "site_admin")
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