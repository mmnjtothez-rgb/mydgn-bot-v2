package com.mydgnbot.data.api

import com.mydgnbot.data.model.ApiPlayer
import com.mydgnbot.data.model.StatusResponse
import com.mydgnbot.data.model.StatusRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface MyDGNApi {


    @GET("transfers")
    suspend fun getTransfer(

        @Query("user")
        user: String,

        @Query("platform")
        platform: String,

        @Query("timestamp")
        timestamp: Long,

        @Query("hash")
        hash: String,

        @Query("maximumBuyOutPrice")
        maximumBuyOutPrice: Int,

        @Query("minimumBuyOutPrice")
        minimumBuyOutPrice: Int,

        @Query("botapp")
        botApp: String,

        @Query("playerType")
        playerType: Int

    ): ApiPlayer



    @POST("status")
    suspend fun updateStatus(

        @Body
        request: StatusRequest

    ): StatusResponse


}
