package com.mydgnbot.di

import com.mydgnbot.data.api.MyDGNApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    private const val BASE_URL =
        "https://www.mydgn.com/"



    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {


        return OkHttpClient.Builder()

            .build()

    }




    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient
    ): Retrofit {


        return Retrofit.Builder()

            .baseUrl(BASE_URL)

            .client(client)

            .addConverterFactory(
                GsonConverterFactory.create()
            )

            .build()

    }




    @Provides
    @Singleton
    fun provideMyDGNApi(
        retrofit: Retrofit
    ): MyDGNApi {


        return retrofit
            .create(
                MyDGNApi::class.java
            )

    }

}
