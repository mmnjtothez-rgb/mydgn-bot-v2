package com.mydgnbot.ui.components


import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun BoughtButton(

    onClick: () -> Unit

) {

    Button(

        onClick = onClick

    ) {

        Text(
            "✓ I Bought This Player"
        )

    }

}
