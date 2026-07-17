package com.mydgnbot.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ControlButtons() {

    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        OutlinedButton(
            onClick = {}
        ) {

            Icon(
                Icons.Default.PlayArrow,
                null
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text("Start")

        }

        OutlinedButton(
            onClick = {}
        ) {

            Icon(
                Icons.Default.Stop,
                null
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text("Stop")

        }

    }

}
