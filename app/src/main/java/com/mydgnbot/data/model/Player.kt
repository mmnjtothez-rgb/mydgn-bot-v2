package com.mydgnbot.data.model


fun ApiPlayer.toPlayer(): Player {


    return Player(

        id = transactionID.toString(),

        name = playerName,

        rating = rating,

        position = "ST",

        chemistryStyle =
            chemistry_style ?: "None",

        owners = owners,

        marketTime =
            ea_expires_at.toString(),

        startingBid =
            startPrice,

        buyNow =
            coinAmount,

        account = "",

        payment =
            "$paymentInUsd USD",

        transactionId =
            transactionID.toString(),

        myDgnPrice =
            cardValue.toString(),

        imageUrl = null

    )

}
