package com.mydgnbot.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mydgnbot.ui.screens.HomeScreen
import com.mydgnbot.ui.screens.HistoryScreen
import com.mydgnbot.ui.screens.SettingsScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {
            HomeScreen()
        }

        composable(Screen.History.route) {
            HistoryScreen()
        }

        composable(Screen.Settings.route) {
            SettingsScreen()
        }

    }

}
