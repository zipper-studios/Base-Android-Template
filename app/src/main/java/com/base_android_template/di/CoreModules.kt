package com.base_android_template.di

import com.base_android_template.shared.BASE_URL
import com.base_android_template.shared.loading.UILoading
import com.base_android_template.shared.loading.UILoadingImplementation
import com.base_android_template.shared.network.ExceptionHandler
import com.base_android_template.shared.network.ExceptionHandlerImpl
import com.base_android_template.shared.provider.PreferencesProvider
import com.base_android_template.shared.provider.PreferencesProviderImpl
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val coreModules = module {

    factory {
        GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }

    factory {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    factory {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .client(get())
            .build()
    }

    factory<PreferencesProvider> { PreferencesProviderImpl() }

    factory<UILoading> { UILoadingImplementation() }

    single<ExceptionHandler> { ExceptionHandlerImpl() }

}

fun createCoreModules() =
    coreModules + apiModule + repositoryModule + useCaseModule + databaseModule