package com.mydgnbot.data.model

data class Player(

    val id: String,

    val name: String,

    val rating: Int,

    val position: String,

    val chemistryStyle: String,

    val owners: Int,

    val marketTime: String,

    val startingBid: Int,

    val buyNow: Int,

    val account: String,

    val payment: String,

    val transactionId: String,

    val myDgnPrice: String,

    val imageUrl: String?

)
