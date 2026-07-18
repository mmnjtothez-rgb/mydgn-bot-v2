package com.mydgnbot.data.model


data class UserSettings(

    val apiUser: String = "",

    val secretKey: String = "",

    val platform: String = "pc",

    val botApp: String = "MyDGNBotV2",

    val playerType: Int = 2,

    val minBuyPrice: Int = 4000,

    val maxBuyPrice: Int = 300000,

    val pollingInterval: Long = 10000L

)
