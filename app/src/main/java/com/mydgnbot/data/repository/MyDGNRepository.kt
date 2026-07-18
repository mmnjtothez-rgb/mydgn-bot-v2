package com.mydgnbot.data.repository

import com.mydgnbot.data.api.RetrofitClient
import com.mydgnbot.data.model.ApiPlayer
import com.mydgnbot.data.model.Player
import com.mydgnbot.data.model.toPlayer


class MyDGNRepository {


    private val api =
        RetrofitClient.api



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


            val response =
                api.getTransfer(

                    user = user,

                    platform = platform,

                    timestamp = timestamp,

                    hash = hash,

                    maximumBuyOutPrice =
                        maximumBuyOutPrice,

                    minimumBuyOutPrice =
                        minimumBuyOutPrice,

                    botApp = botApp,

                    playerType = playerType

                )


            Result.success(
                response.toPlayer()
            )


        } catch (e: Exception) {


            Result.failure(
                e
            )

        }

    }



    suspend fun updateStatus(
        user: String,
        platform: String,
        timestamp: Long,
        hash: String,
        transactionId: Int,
        status: String,
        emailHash: String,
        code: Int? = null
    ): Result<Boolean> {


        return try {


            val response =
                api.updateStatus(

                    user = user,

                    platform = platform,

                    timestamp = timestamp,

                    hash = hash,

                    transactionId = transactionId,

                    status = status,

                    emailHash = emailHash,

                    code = code

                )


            if (response.code == 200) {

                Result.success(true)

            } else {

                Result.failure(
                    Exception(
                        "Status update failed"
                    )
                )

            }


        } catch (e: Exception) {


            Result.failure(
                e
            )

        }

    }

}
