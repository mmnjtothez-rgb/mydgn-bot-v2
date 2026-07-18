package com.mydgnbot.domain


sealed class BotState {


    object Stopped : BotState()


    object Starting : BotState()


    object Monitoring : BotState()


    object Searching : BotState()


    data class PlayerFound(
        val playerName: String
    ) : BotState()


    data class Error(
        val message: String
    ) : BotState()

}
