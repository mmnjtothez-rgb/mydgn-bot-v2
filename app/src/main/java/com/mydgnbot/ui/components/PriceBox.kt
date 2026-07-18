package com.mydgnbot.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun PriceBox(

    title: String,

    price: String,

    modifier: Modifier = Modifier

) {

    Card(

        modifier = modifier

    ) {


        Column(

            modifier =
            Modifier.padding(12.dp),

            horizontalAlignment =
            androidx.compose.ui.Alignment.CenterHorizontally

        ) {


            Text(

                text = title,

                style =
                MaterialTheme.typography.labelMedium

            )


            Spacer(
                Modifier.height(6.dp)
            )


            Text(

                text = price,

                style =
                MaterialTheme.typography.titleLarge

            )


        }

    }

}
