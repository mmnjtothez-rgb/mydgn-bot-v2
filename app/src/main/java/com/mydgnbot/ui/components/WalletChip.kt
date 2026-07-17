package com.mydgnbot.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun WalletChip(
    balance: String = "$12.48"
) {

    AssistChip(

        onClick = {},

        leadingIcon = {

            Icon(

                imageVector = Icons.Default.AccountBalanceWallet,

                contentDescription = "Wallet"

            )

        },

        label = {

            Text(balance)

        }

    )

}
