package com.mydgnbot.data.repository

import com.mydgnbot.data.api.MyDGNApi
import com.mydgnbot.data.model.Player
import com.mydgnbot.data.model.toPlayer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyDGNRepository(
    private val api: MyDGNApi
) {


    suspend fun findPlayer(
        platform: String
    ): Player? {

        return withContext(
            Dispatchers.IO
        ) {

            val response =
                api.getPlayers(
                    platform = platform
                )


            response
                .firstOrNull()
                ?.toPlayer()

        }

    }


    suspend fun checkPlayer(
        transactionId: Int
    ): Player? {

        return withContext(
            Dispatchers.IO
        ) {

            api.getPlayerStatus(
                transactionId
            )
            .toPlayer()

        }

    }

}
