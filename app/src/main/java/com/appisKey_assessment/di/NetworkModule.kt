package com.appisKey_assessment.di

import com.appisKey_assessment.data.remote.PixApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideGetInfoApi(): PixApiServices {
        return Retrofit.Builder()
            .baseUrl(PixApiServices.BASE_URL)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PixApiServices::class.java)
    }

    fun getClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            .connectTimeout(50, TimeUnit.SECONDS)
            .writeTimeout(50, TimeUnit.SECONDS) // write timeout
            .readTimeout(50, TimeUnit.SECONDS) // read timeout
            .build()
        return client
    }


}