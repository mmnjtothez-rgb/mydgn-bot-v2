package com.mydgnbot.data.model


data class StatusRequest(

    val user: String,

    val platform: String,

    val timestamp: Long,

    val hash: String,

    val transactionID: Int,

    val status: String,

    val emailHash: String,

    val code: Int? = null

)
