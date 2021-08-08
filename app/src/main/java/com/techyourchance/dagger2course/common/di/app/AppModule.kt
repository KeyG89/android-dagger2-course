package com.techyourchance.dagger2course.common.di.app

import com.techyourchance.dagger2course.common.di.Retrofit1
import com.techyourchance.dagger2course.common.di.Retrofit2
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.networking.UrlProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    @Retrofit1
    fun retrofit1(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlProvider.getBaseUrl1())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    @Retrofit2
    fun retrofit2(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlProvider.getBaseUrl1())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun urlProvider() = UrlProvider()

    @Singleton
    @Provides
    fun stackoverflowApi(@Retrofit1 retrofit: Retrofit) =
        retrofit.create(StackoverflowApi::class.java)
}
