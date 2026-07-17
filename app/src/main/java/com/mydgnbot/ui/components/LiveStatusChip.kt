package com.mydgnbot.ui.components


import androidx.compose.material3.AssistChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.mydgnbot.domain.BotState



@Composable
fun LiveStatusChip(

    state: BotState = BotState.Idle

) {


    val text = when(state) {


        BotState.Idle ->
            "⚪ Stopped"


        BotState.Monitoring ->
            "🟢 Monitoring"


        BotState.PlayerFound ->
            "🔵 Player Found"


        BotState.AwaitingPurchase ->
            "🟡 Awaiting Purchase"


        BotState.PurchaseCompleted ->
            "✅ Bought"


        BotState.Offline ->
            "🔴 Offline"

    }



    AssistChip(

        onClick = {},

        label = {

            Text(text)

        }

    )

}
