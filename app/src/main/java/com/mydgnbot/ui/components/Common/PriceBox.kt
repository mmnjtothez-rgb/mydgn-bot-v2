package com.mydgnbot.ui.components.common

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun PriceBox(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {


    ElevatedCard(
        modifier = modifier
    ) {


        Column(
            modifier =
                Modifier.padding(12.dp),

            verticalArrangement =
                Arrangement.spacedBy(4.dp)

        ) {


            Text(
                text = title,

                style =
                    MaterialTheme.typography.labelMedium
            )


            Text(
                text = value,

                style =
                    MaterialTheme.typography.titleLarge
            )


        }

    }

}
