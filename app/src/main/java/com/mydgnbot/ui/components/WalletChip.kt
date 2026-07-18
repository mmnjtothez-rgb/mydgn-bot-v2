package com.mydgnbot.ui.components


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance

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


        leadingIcon = {

            Icon(

                imageVector = Icons.Default.AccountBalance,

                contentDescription = "Wallet"

            )

        },


        label = {

            Text(amount)

        }

    )

}
