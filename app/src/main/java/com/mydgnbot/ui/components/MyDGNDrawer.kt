package com.mydgnbot.ui.components


import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings

import androidx.compose.material3.*

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun MyDGNDrawer() {


    ModalDrawerSheet {


        NavigationDrawerItem(

            label = {
                Text("Home")
            },

            selected = true,

            onClick = {},

            icon = {

                Icon(
                    Icons.Default.Home,
                    null
                )

            },

            modifier = Modifier.padding(
                12.dp
            )

        )



        NavigationDrawerItem(

            label = {
                Text("History")
            },

            selected = false,

            onClick = {},

            icon = {

                Icon(
                    Icons.Default.Refresh,
                    null
                )

            },

            modifier = Modifier.padding(
                12.dp
            )

        )



        NavigationDrawerItem(

            label = {
                Text("Settings")
            },

            selected = false,

            onClick = {},

            icon = {

                Icon(
                    Icons.Default.Settings,
                    null
                )

            },

            modifier = Modifier.padding(
                12.dp
            )

        )

    }

}
