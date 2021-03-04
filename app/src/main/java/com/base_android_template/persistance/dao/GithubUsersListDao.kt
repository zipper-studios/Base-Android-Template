package com.base_android_template.persistance.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.base_android_template.model.entity.GithubUserEntity

@Dao
interface GithubUsersListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGithubUsers(usersList: List<GithubUserEntity>)

    @Query("SELECT * FROM GithubUserEntity")
    suspend fun getGithubUsers(): List<GithubUserEntity>?

    @Query("DELETE FROM GithubUserEntity")
    suspend fun deleteGithubUsers()
}