package com.mydgnbot.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mydgnbot.data.model.PreviewPlayer
import com.mydgnbot.domain.BotState
import com.mydgnbot.ui.components.PlayerCard
import com.mydgnbot.ui.viewmodel.HomeViewModel


@Composable
fun HomeScreen(

    viewModel: HomeViewModel = viewModel()

) {


    val uiState by viewModel.uiState.collectAsState()



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


            when (uiState.botState) {


                BotState.Idle -> {


                    Text(

                        text = "Ready to monitor",

                        style =
                        MaterialTheme.typography.headlineSmall

                    )


                    Spacer(
                        Modifier.height(32.dp)
                    )


                    Button(

                        onClick = {

                            viewModel.startBot()

                        }

                    ) {

                        Text("▶ Start Bot")

                    }


                }



                BotState.Monitoring -> {


                    Text(

                        text = "🟢 Monitoring",

                        style =
                        MaterialTheme.typography.headlineSmall

                    )


                    Spacer(
                        Modifier.height(40.dp)
                    )


                    CircularProgressIndicator()


                    Spacer(
                        Modifier.height(20.dp)
                    )


                    Text(

                        text =
                        "Searching for players...",

                        style =
                        MaterialTheme.typography.bodyLarge

                    )


                    Spacer(
                        Modifier.height(32.dp)
                    )


                    OutlinedButton(

                        onClick = {

                            viewModel.stopBot()

                        }

                    ) {

                        Text("■ Stop Bot")

                    }


                    Spacer(
                        Modifier.height(30.dp)
                    )


                    // Development only
                    Button(

                        onClick = {

                            viewModel.playerFound(
                                PreviewPlayer
                            )

                        }

                    ) {

                        Text(
                            "Simulate Player Found"
                        )

                    }


                }



                BotState.PlayerFound -> {


                    uiState.currentPlayer?.let { player ->


                        PlayerCard(

                            player = player,

                            onCancel = {

                                viewModel.stopBot()

                            },


                            onBought = {

                                viewModel.purchaseCompleted()

                            }

                        )


                    }


                }



                else -> {


                    Text(
                        text = "Processing..."
                    )


                }


            }


        }


    }

}
