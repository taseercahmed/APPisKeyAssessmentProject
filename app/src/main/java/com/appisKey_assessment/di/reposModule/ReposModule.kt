package com.appisKey_assessment.di.reposModule

import com.appisKey_assessment.PixApiServices
import com.appisKey_assessment.PixDataRepo
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