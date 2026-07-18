package com.mydgnbot.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mydgnbot.domain.BotState
import com.mydgnbot.ui.components.player.PlayerCard
import com.mydgnbot.ui.viewmodel.HomeViewModel


@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {


    val state by viewModel.uiState
        .collectAsStateWithLifecycle()



    Surface(
        modifier = Modifier.fillMaxSize()
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),

            horizontalAlignment =
                Alignment.CenterHorizontally

        ) {



            when(state.botState) {



                BotState.Idle -> {

                    Button(
                        onClick = {
                            viewModel.startBot(
                                platform = "pc"
                            )
                        }
                    ) {

                        Text(
                            "Start Monitoring"
                        )

                    }

                }



                BotState.Monitoring -> {

                    CircularProgressIndicator()

                    Spacer(
                        Modifier.height(16.dp)
                    )


                    Text(
                        "Searching for players..."
                    )

                }



                BotState.PlayerFound -> {


                    state.currentPlayer?.let {

                        PlayerCard(
                            player = it,
                            countdown = state.countdown,

                            onBought = {
                                viewModel.playerBought()
                            },

                            onCancel = {
                                viewModel.cancelPlayer()
                            }
                        )

                    }


                }



                BotState.Error -> {


                    Text(
                        text =
                            state.errorMessage
                                ?: "Unknown error"
                    )


                }



                else -> {

                    Text(
                        "Processing..."
                    )

                }


            }


        }


    }

}
