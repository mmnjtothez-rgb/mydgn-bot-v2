package com.mydgnbot.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mydgnbot.ui.screens.HomeScreen
import com.mydgnbot.ui.screens.HistoryScreen
import com.mydgnbot.ui.screens.SettingsScreen


@Composable
fun AppNavigation(

    navController: NavHostController

) {


    NavHost(

        navController = navController,

        startDestination = Screen.Home.route

    ) {


        composable(

            Screen.Home.route

        ) {

            HomeScreen()

        }



        composable(

            Screen.History.route

        ) {

            HistoryScreen()

        }



        composable(

            Screen.Settings.route

        ) {

            SettingsScreen()

        }


    }

}
