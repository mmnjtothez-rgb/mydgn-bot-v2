package com.mydgnbot.ui.components.player

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ActionButtons(

    onBought: () -> Unit,

    onCancel: () -> Unit,

    modifier: Modifier = Modifier,

    enabled: Boolean = true

) {


    Row(

        modifier =
            modifier.fillMaxWidth(),

        horizontalArrangement =
            Arrangement.spacedBy(12.dp)

    ) {


        OutlinedButton(

            onClick = onCancel,

            enabled = enabled,

            modifier =
                Modifier.weight(1f)

        ) {

            Text(
                text = "Cancel"
            )

        }



        Button(

            onClick = onBought,

            enabled = enabled,

            modifier =
                Modifier.weight(1f)

        ) {

            Text(
                text = "✓ Bought"
            )

        }


    }

}
