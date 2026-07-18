package com.mydgnbot.di

import com.mydgnbot.data.api.MyDGNApi
import com.mydgnbot.data.repository.MyDGNRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    @Singleton
    fun provideMyDGNRepository(
        api: MyDGNApi
    ): MyDGNRepository {


        return MyDGNRepository(
            api
        )

    }

}
