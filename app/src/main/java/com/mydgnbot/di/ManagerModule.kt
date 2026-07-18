package com.mydgnbot.di

import com.mydgnbot.domain.manager.CountdownManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ManagerModule {


    @Provides
    @Singleton
    fun provideCountdownManager():

            CountdownManager {


        return CountdownManager()

    }

}
