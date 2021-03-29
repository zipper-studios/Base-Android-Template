package com.base_android_template.di

import android.content.Context
import androidx.room.Room
import com.base_android_template.persistance.database.GithubUsersDatabase
import org.koin.dsl.module

val databaseModule = module {
    fun provideGithubUsersListDatabase(context: Context): GithubUsersDatabase =
        Room.databaseBuilder(context, GithubUsersDatabase::class.java, "github_users_database")
            .build()

    single { provideGithubUsersListDatabase(get()) }
}