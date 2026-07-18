package com.mydgnbot.ui.components


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings

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

                imageVector = Icons.Default.Settings,

                contentDescription = "Wallet"

            )

        },


        label = {

            Text(amount)

        }

    )

}
