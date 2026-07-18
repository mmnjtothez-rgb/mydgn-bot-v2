package com.mydgnbot.ui.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun ControlButtons(

    onBuyClick: () -> Unit = {},

    onRefreshClick: () -> Unit = {}

) {


    Row(

        modifier = Modifier

            .fillMaxWidth()

            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),

        horizontalArrangement = Arrangement.spacedBy(
            12.dp
        )

    ) {


        Button(

            onClick = onBuyClick,

            modifier = Modifier

                .weight(1f)

                .height(
                    50.dp
                ),

            colors = ButtonDefaults.buttonColors()

        ) {


            Text(
                text = "Bought"
            )


        }



        Button(

            onClick = onRefreshClick,

            modifier = Modifier

                .weight(1f)

                .height(
                    50.dp
                )

        ) {


            Text(
                text = "Refresh"
            )


        }


    }


}
