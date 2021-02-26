package com.base_android_template.persistance.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.base_android_template.model.response.GithubUserResponse

@Dao
interface GithubUsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(usersList: List<GithubUserResponse>)
}