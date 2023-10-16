package com.appisKey_assessment.di


import com.appisKey_assessment.data.remote.PixApiServices
import com.appisKey_assessment.data.repos.PixDataRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ReposModule() {

    @Singleton
    @Provides
    fun providePixRepo(pixApiServices: PixApiServices): PixDataRepo {
        return PixDataRepo(pixApiServices)
    }
}