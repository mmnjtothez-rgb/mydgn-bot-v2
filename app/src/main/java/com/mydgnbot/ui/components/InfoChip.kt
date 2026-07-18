package com.mydgnbot.ui.components


import androidx.compose.material3.AssistChip
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable


@Composable
fun InfoChip(
    text: String = "",
    title: String = "",
    value: String = ""
) {

    val label =
        when {
            text.isNotBlank() -> text
            title.isNotBlank() && value.isNotBlank() ->
                "$title $value"
            title.isNotBlank() ->
                title
            value.isNotBlank() ->
                value
            else ->
                ""
        }


    AssistChip(

        onClick = {},

        label = {
            Text(label)
        }

    )

}
