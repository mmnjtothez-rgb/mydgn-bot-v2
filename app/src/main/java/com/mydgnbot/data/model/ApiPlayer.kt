package com.mydgnbot.data.model


data class ApiPlayer(

    val code: Int,

    val transactionID: Int,

    val tradeID: String,

    val status: String,

    val platform: String,


    val assetID: Long,

    val resourceID: Long,

    val baseID: Long,


    val playerName: String,

    val rating: Int,


    val startPrice: Int,

    val coinAmount: Int,


    val paymentInUsd: Double,


    val cardValue: Int,


    val ea_expires_at: Long,


    val owners: Int,


    val chemistry_style: String?,


    // Optional enrichment fields

    val nationality: String? = null,

    val club: String? = null,

    val cardTitle: String? = null,

    val cardRarity: String? = null,

    val imageUrl: String? = null

)
