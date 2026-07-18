package com.mydgnbot.data.model


data class ApiPlayer(

    val code: Int,
    
    val lockExpires: Long,
    
    val customerID: Int,
    
    val resourceID: Long
    
    val baseID: Long
    
    val cardValue: Int
    
    val IsIcon: Int,
    
    val isAtMinPrice: Boolean
    
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

    val chemistry_style: String?

)
