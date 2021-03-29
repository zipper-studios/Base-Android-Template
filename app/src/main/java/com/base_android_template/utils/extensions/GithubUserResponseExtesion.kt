package com.base_android_template.utils.extensions

import com.base_android_template.model.entity.GithubUserEntity
import com.base_android_template.model.response.GithubUserResponse

fun GithubUserResponse.mapToGithubUserEntity(): GithubUserEntity =
    GithubUserEntity(
        login = this.login.orEmpty(),
        id = this.id,
        nodeId = this.nodeId.orEmpty(),
        avatarUrl = this.avatarUrl.orEmpty(),
        grAvatarId = this.grAvatarId.orEmpty(),
        url = this.url.orEmpty(),
        htmlUrl = this.htmlUrl.orEmpty(),
        followersUrl = this.followersUrl.orEmpty(),
        followingUrl = this.followingUrl.orEmpty(),
        gistsUrl = this.gistsUrl.orEmpty(),
        starredUrl = this.starredUrl.orEmpty(),
        subscriptionsUrl = this.subscriptionsUrl.orEmpty(),
        organizationsUrl = this.organizationsUrl.orEmpty(),
        reposUrl = this.reposUrl.orEmpty(),
        eventsUrl = this.eventsUrl.orEmpty(),
        receivedEventsUrl = this.receivedEventsUrl.orEmpty(),
        type = this.type.orEmpty(),
        siteAdmin = this.siteAdmin
    )