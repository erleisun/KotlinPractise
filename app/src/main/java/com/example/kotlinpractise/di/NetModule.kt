package com.example.kotlinpractise.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * 提供  okHttp和 retrofit到模块
 */
@InstallIn(ApplicationComponent::class) //表示全局的生命周期
@Module
object NetModule {

    @Singleton
    @Provides
    fun providesOKHttp(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit { //此处的参数由上面的方法提供
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("123")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}