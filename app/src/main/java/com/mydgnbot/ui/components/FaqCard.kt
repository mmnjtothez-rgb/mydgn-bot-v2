package com.mydgnbot.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun FaqCard(

    question: String,

    answer: String

) {

    Card(

        modifier = Modifier
            .fillMaxWidth(),

    ) {

        Column(

            modifier = Modifier
                .padding(16.dp)

        ) {

            Text(

                text = question,

                style = MaterialTheme.typography.titleMedium

            )


            Spacer(
                modifier = Modifier.height(8.dp)
            )


            Text(

                text = answer,

                style = MaterialTheme.typography.bodyMedium

            )

        }

    }

}
