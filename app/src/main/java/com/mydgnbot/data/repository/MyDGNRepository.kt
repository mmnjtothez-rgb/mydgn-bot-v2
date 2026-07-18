package com.mydgnbot.data.repository

import com.mydgnbot.data.api.RetrofitClient
import com.mydgnbot.data.model.ApiPlayer
import com.mydgnbot.data.model.Player
import com.mydgnbot.data.model.toPlayer

class MyDGNRepository {

    private val api = RetrofitClient.api

    suspend fun getTransfer(
        user: String,
        platform: String,
        timestamp: Long,
        hash: String,
        maximumBuyOutPrice: Int,
        minimumBuyOutPrice: Int,
        botApp: String,
        playerType: Int
    ): Result<Player> {

        return try {

            val response: ApiPlayer = api.getTransfer(
                user = user,
                platform = platform,
                timestamp = timestamp,
                hash = hash,
                maximumBuyOutPrice = maximumBuyOutPrice,
                minimumBuyOutPrice = minimumBuyOutPrice,
                botApp = botApp,
                playerType = playerType
            )

            Result.success(response.toPlayer())

        } catch (e: Exception) {

            Result.failure(e)

        }
    }

    suspend fun bought(
        user: String,
        platform: String,
        timestamp: Long,
        hash: String,
        transactionId: Int,
        emailHash: String
    ) = api.updateStatus(
        user = user,
        platform = platform,
        timestamp = timestamp,
        hash = hash,
        transactionId = transactionId,
        status = "bought",
        emailHash = emailHash
    )

    suspend fun cancel(
        user: String,
        platform: String,
        timestamp: Long,
        hash: String,
        transactionId: Int
    ) = api.updateStatus(
        user = user,
        platform = platform,
        timestamp = timestamp,
        hash = hash,
        transactionId = transactionId,
        status = "cancel",
        emailHash = ""
    )

}
