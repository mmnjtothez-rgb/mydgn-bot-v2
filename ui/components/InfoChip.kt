package com.mydgnbot.ui.components


import androidx.compose.material3.*
import androidx.compose.runtime.Composable



@Composable
fun InfoChip(

    title: String,

    value: String

) {


    AssistChip(

        onClick = {},

        label = {

            Text(
                "$title: $value"
            )

        }

    )


}
