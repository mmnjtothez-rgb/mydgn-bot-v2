package com.mydgnbot.ui.components

import androidx.compose.material3.AssistChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


enum class BotStatus {

    MONITORING,
    PLAYER_FOUND,
    AWAITING_PURCHASE,
    OFFLINE

}


@Composable
fun LiveStatusChip(
    status: BotStatus = BotStatus.MONITORING
) {

    val label = when(status) {

        BotStatus.MONITORING ->
            "🟢 Monitoring"

        BotStatus.PLAYER_FOUND ->
            "🔵 Player Found"

        BotStatus.AWAITING_PURCHASE ->
            "🟡 Awaiting Purchase"

        BotStatus.OFFLINE ->
            "🔴 Offline"

    }


    AssistChip(

        onClick = {},

        label = {

            Text(label)

        }

    )

}
