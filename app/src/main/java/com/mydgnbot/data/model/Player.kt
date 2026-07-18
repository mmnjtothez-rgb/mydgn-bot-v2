package com.mydgnbot.data.model


data class Player(

    val id: String,

    val name: String,

    val rating: Int,

    val position: String,


    // Player identity
    val nationality: String = "",

    val nationalityFlag: String? = null,

    val club: String = "",


    // Card information
    val cardTitle: String = "",

    val cardRarity: String = "",


    // Market information
    val chemistryStyle: String,

    val owners: Int,

    val marketTime: String,


    val startingBid: Int,

    val buyNow: Int,


    // Account/payment
    val account: String,

    val payment: String,

    val transactionId: String,


    // Prices
    val myDgnPrice: String,

    val futbinPrice: String? = null,


    // Visual
    val imageUrl: String? = null

)
