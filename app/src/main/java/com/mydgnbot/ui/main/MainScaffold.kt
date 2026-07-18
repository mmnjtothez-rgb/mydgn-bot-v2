package com.mydgnbot.ui.main


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu

import androidx.compose.material3.*
import androidx.compose.runtime.Composable



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(

    content: @Composable () -> Unit

) {


    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    Text(
                        text = "MyDGN Bot"
                    )

                },


                navigationIcon = {

                    IconButton(

                        onClick = {

                            // TODO:
                            // Open navigation drawer later

                        }

                    ) {

                        Icon(

                            imageVector = Icons.Default.Menu,

                            contentDescription = "Menu"

                        )

                    }

                }

            )

        }

    ) { paddingValues ->


        Surface(

            modifier = androidx.compose.ui.Modifier
                .padding(paddingValues)

        ) {


            content()


        }


    }


}
