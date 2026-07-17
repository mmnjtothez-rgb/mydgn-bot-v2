package com.mydgnbot.domain


sealed class BotState {


    data object Idle : BotState()


    data object Monitoring : BotState()


    data object PlayerFound : BotState()


    data object AwaitingPurchase : BotState()


    data object PurchaseCompleted : BotState()


    data object Offline : BotState()

}
