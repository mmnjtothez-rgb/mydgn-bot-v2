package com.mydgnbot.data.repository

import com.mydgnbot.data.api.MyDGNApi
import com.mydgnbot.data.model.Player
import com.mydgnbot.data.model.toPlayer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MyDGNRepository @Inject constructor(
    private val api: MyDGNApi
) {

    suspend fun findPlayer(platform: String): Player? =
        withContext(Dispatchers.IO) {
            api.getPlayers(platform)
                .firstOrNull()
                ?.toPlayer()
        }

    suspend fun checkPlayer(transactionId: Int): Player? =
        withContext(Dispatchers.IO) {
            api.getPlayerStatus(transactionId)
                .toPlayer()
        }
}
