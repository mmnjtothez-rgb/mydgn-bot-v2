package com.mydgnbot.ui.components


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Wallet

import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable



@Composable
fun WalletChip(

    amount: String

) {


    AssistChip(

        onClick = {},

        label = {

            Text(amount)

        },


        leadingIcon = {

            Icon(

                Icons.Default.Wallet,

                contentDescription = "Wallet"

            )

        }

    )

}
