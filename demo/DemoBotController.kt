package com.mydgnbot.demo

import com.mydgnbot.data.model.demoPlayer
import kotlinx.coroutines.delay


class DemoBotController {


    suspend fun findPlayer(): Boolean {

        // Simulate MyDGN API delay

        delay(3000)


        return true

    }


    fun getPlayer() =
        demoPlayer


}
