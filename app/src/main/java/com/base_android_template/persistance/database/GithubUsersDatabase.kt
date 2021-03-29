package com.base_android_template.persistance.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.base_android_template.model.entity.GithubUserEntity
import com.base_android_template.persistance.dao.GithubUsersListDao

@Database(entities = [GithubUserEntity::class], version = 1)
abstract class GithubUsersDatabase : RoomDatabase() {

    abstract fun githubUsersListDao(): GithubUsersListDao
}