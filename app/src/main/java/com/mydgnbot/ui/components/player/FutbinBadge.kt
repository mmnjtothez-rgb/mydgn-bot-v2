package com.mydgnbot.ui.components.player


import androidx.compose.material3.*
import androidx.compose.runtime.Composable



@Composable
fun FutbinBadge(

    price: String?

) {


    AssistChip(

        onClick = {

            // FUTBIN popup later

        },


        label = {

            Text(

                text = "🟢 FUTBIN ${price ?: "-"}"

            )

        }

    )


}
