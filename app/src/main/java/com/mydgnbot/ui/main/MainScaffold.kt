package com.mydgnbot.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.mydgnbot.ui.components.BottomNavBar
import com.mydgnbot.ui.components.MyDGNDrawer
import com.mydgnbot.ui.components.LiveStatusChip
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(

    navController: NavHostController,

    content: @Composable () -> Unit

) {

    val drawerState =
        rememberDrawerState(
            initialValue = DrawerValue.Closed
        )


    val scope = rememberCoroutineScope()


    var selectedItem by remember {
        mutableStateOf("Live")
    }


    ModalNavigationDrawer(

        drawerState = drawerState,

        drawerContent = {

            MyDGNDrawer(

                onNavigate = { route ->

                    scope.launch {

                        drawerState.close()

                    }

                    navController.navigate(route)

                }

            )

        }

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

                                scope.launch {

                                    drawerState.open()

                                }

                            }

                        ) {

                            Icon(

                                imageVector =
                                androidx.compose.material.icons.Icons.Default.Menu,

                                contentDescription = "Menu"

                            )

                        }

                    },

                    actions = {

                        LiveStatusChip()

                    }

                )

            },


            bottomBar = {

                BottomNavBar(

                    selectedItem = selectedItem,

                    onItemSelected = {

                        selectedItem = it

                    }

                )

            }

        ) { padding ->


            androidx.compose.foundation.layout.Box(

                modifier = Modifier
                    .padding(padding)

            ) {

                content()

            }


        }


    }

}
