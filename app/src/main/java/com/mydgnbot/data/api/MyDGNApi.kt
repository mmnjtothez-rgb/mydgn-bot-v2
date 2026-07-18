package com.mydgnbot.data.api

import com.mydgnbot.data.model.ApiPlayer
import retrofit2.http.GET
import retrofit2.http.Query

interface MyDGNApi {


    @GET("api/players")
    suspend fun getPlayers(
        @Query("platform")
        platform: String,

        @Query("limit")
        limit: Int = 1
    ): List<ApiPlayer>


    @GET("api/player/status")
    suspend fun getPlayerStatus(
        @Query("transactionID")
        transactionId: Int
    ): ApiPlayer


}
