package com.mydgnbot.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mydgnbot.domain.BotState
import com.mydgnbot.ui.components.*
import com.mydgnbot.ui.viewmodel.BotViewModel


@Composable
fun HomeScreen(

    botViewModel: BotViewModel = viewModel()

) {


    val state by botViewModel.state.collectAsState()

    val player by botViewModel.player.collectAsState()



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
            modifier = Modifier.height(30.dp)
        )




        when(state) {



            BotState.Idle -> {


                Text(
                    "Bot stopped"
                )


            }



            BotState.Monitoring -> {


                WaitingIndicator()


                Spacer(
                    Modifier.height(16.dp)
                )


                Text(
                    "Waiting for player..."
                )


            }



            BotState.PlayerFound -> {



                AnimatedVisibility(

                    visible = player != null,

                    enter = slideInVertically() + fadeIn()

                ) {



                    player?.let {


                        PlayerCard(

                            player = it,

                            onBought = {

                                botViewModel.boughtPlayer()

                            }

                        )


                    }


                }


            }



            BotState.PurchaseCompleted -> {


                Text(
                    "✅ Purchase completed"
                )


            }



            BotState.AwaitingPurchase -> {


                Text(
                    "Awaiting purchase"
                )


            }



            BotState.Offline -> {


                Text(
                    "Offline"
                )


            }


        }


    }


}
