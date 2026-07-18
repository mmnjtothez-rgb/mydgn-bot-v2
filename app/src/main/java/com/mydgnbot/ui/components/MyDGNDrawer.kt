package com.mydgnbot.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable


@Composable
fun MyDGNDrawer(
    onNavigate: (String) -> Unit
) {

    ModalDrawerSheet {

        Text(
            text = "MyDGN Bot",
            style = MaterialTheme.typography.headlineSmall,
            modifier = androidx.compose.ui.Modifier
                .padding(20.dp)
        )


        NavigationDrawerItem(

            label = {
                Text("Live Player")
            },

            selected = true,

            onClick = {
                onNavigate("home")
            },

            icon = {

                Icon(
                    Icons.Default.Home,
                    null
                )

            }

        )


        NavigationDrawerItem(

            label = {
                Text("History")
            },

            selected = false,

            onClick = {
                onNavigate("history")
            },

            icon = {

                Icon(
                    Icons.Default.History,
                    null
                )

            }

        )


        NavigationDrawerItem(

            label = {
                Text("Settings")
            },

            selected = false,

            onClick = {
                onNavigate("settings")
            },

            icon = {

                Icon(
                    Icons.Default.Settings,
                    null
                )

            }

        )

    }

}
