package com.mydgnbot.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector


data class BottomNavItem(
    val label: String,
    val icon: ImageVector
)


@Composable
fun BottomNavBar(
    selectedItem: String = "Live",
    onItemSelected: (String) -> Unit
) {

    val items = listOf(

        BottomNavItem(
            "Live",
            Icons.Default.Home
        ),

        BottomNavItem(
            "History",
            Icons.Default.History
        ),

        BottomNavItem(
            "Settings",
            Icons.Default.Settings
        )

    )


    NavigationBar {

        items.forEach { item ->

            NavigationBarItem(

                selected = selectedItem == item.label,

                onClick = {
                    onItemSelected(item.label)
                },

                icon = {

                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label
                    )

                },

                label = {

                    Text(item.label)

                }

            )

        }

    }

}
