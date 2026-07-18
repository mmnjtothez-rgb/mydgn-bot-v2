package com.mydgnbot.ui.components


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings

import androidx.compose.material3.*

import androidx.compose.runtime.Composable



@Composable
fun BottomNavBar() {


    NavigationBar {


        NavigationBarItem(

            selected = true,

            onClick = {},

            icon = {

                Icon(
                    Icons.Default.Home,
                    contentDescription = "Home"
                )

            },

            label = {

                Text("Home")

            }

        )



        NavigationBarItem(

            selected = false,

            onClick = {},

            icon = {

                Icon(
                    Icons.Default.Refresh,
                    contentDescription = "History"
                )

            },

            label = {

                Text("History")

            }

        )



        NavigationBarItem(

            selected = false,

            onClick = {},

            icon = {

                Icon(
                    Icons.Default.Settings,
                    contentDescription = "Settings"
                )

            },

            label = {

                Text("Settings")

            }

        )

    }

}
