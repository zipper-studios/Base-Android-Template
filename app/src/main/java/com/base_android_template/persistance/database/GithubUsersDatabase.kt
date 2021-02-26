package com.base_android_template.persistance.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.base_android_template.model.response.GithubUserResponse
import com.base_android_template.persistance.dao.GithubUsersDao

@Database(entities = [GithubUserResponse::class], version = 1)
abstract class GithubUsersDatabase : RoomDatabase() {

    abstract fun githubUsersDao(): GithubUsersDao
}