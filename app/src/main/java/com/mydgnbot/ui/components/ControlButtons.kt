package com.mydgnbot.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun ControlButtons() {

    Row(

        horizontalArrangement = Arrangement.spacedBy(12)

    ) {

        OutlinedButton(
            onClick = {}
        ) {

            Text("▶ Start")

        }


        OutlinedButton(
            onClick = {}
        ) {

            Text("■ Stop")

        }

    }

}
