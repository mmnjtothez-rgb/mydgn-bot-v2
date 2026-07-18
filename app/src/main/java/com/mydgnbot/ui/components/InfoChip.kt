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


    val displayText =
        when {

            text.isNotEmpty() ->
                text

            title.isNotEmpty() && value.isNotEmpty() ->
                "$title $value"

            title.isNotEmpty() ->
                title

            value.isNotEmpty() ->
                value

            else ->
                ""

        }



    AssistChip(

        onClick = {},

        label = {

            Text(displayText)

        }

    )

}
