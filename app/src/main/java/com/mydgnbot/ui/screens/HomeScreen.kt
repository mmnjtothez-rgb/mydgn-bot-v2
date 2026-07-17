package com.mydgnbot.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mydgnbot.domain.BotState
import com.mydgnbot.ui.components.ControlButtons
import com.mydgnbot.ui.components.WalletChip
import com.mydgnbot.ui.components.WaitingIndicator
import com.mydgnbot.ui.components.LiveStatusChip
import com.mydgnbot.ui.viewmodel.BotViewModel


@Composable
fun HomeScreen(

    botViewModel: BotViewModel = viewModel()

) {

    val state by botViewModel.state.collectAsState()


    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally

    ) {


        LiveStatusChip(
            state = state
        )


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        ControlButtons(

            onStart = {
                botViewModel.startBot()
            },

            onStop = {
                botViewModel.stopBot()
            }

        )


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        WalletChip()


        Spacer(
            modifier = Modifier.height(50.dp)
        )


        when(state) {


            BotState.Idle -> {

                Text(
                    text = "Bot stopped"
                )

            }



            BotState.Monitoring -> {


                WaitingIndicator()


                Spacer(
                    modifier = Modifier.height(20.dp)
                )


                Text(
                    text = "Waiting for player..."
                )

            }



            BotState.PlayerFound -> {


                Text(
                    text = "Player Found!"
                )


            }



            BotState.AwaitingPurchase -> {

                Text(
                    text = "Awaiting purchase"

                )

            }



            BotState.PurchaseCompleted -> {

                Text(
                    text = "Purchase completed"

                )

            }



            BotState.Offline -> {

                Text(
                    text = "Connection lost"

                )

            }

        }

    }

}
