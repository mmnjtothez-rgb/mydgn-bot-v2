package com.mydgnbot.ui.components


import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

import com.mydgnbot.domain.BotState



@Composable
fun LiveStatusChip(

    status: BotState

) {


    val label = when(status) {

        BotState.Idle ->
            "Idle"

        BotState.Monitoring ->
            "Monitoring"

        BotState.PlayerFound ->
            "Player Found"

        BotState.Loading ->
            "Loading"

        BotState.Buying ->
            "Buying"

        BotState.Completed ->
            "Completed"

        BotState.Error ->
            "Error"

    }



    val color = when(status) {

        BotState.Completed ->
            Color(0xFF4CAF50)

        BotState.Error ->
            Color(0xFFE53935)

        BotState.Buying ->
            Color(0xFFFF9800)

        BotState.PlayerFound ->
            Color(0xFF9C27B0)

        BotState.Monitoring ->
            Color(0xFF2196F3)

        BotState.Loading ->
            Color(0xFF03A9F4)

        BotState.Idle ->
            Color.Gray

    }



    AssistChip(

        onClick = {},

        label = {

            Text(label)

        },

        colors = AssistChipDefaults.assistChipColors(

            containerColor = color.copy(
                alpha = 0.15f
            )

        )

    )

}
