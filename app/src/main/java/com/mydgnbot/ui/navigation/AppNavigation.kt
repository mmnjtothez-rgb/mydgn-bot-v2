package com.mydgnbot.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


sealed class Screen(
    val route: String
) {

    data object Home :
        Screen("home")

}



@Composable
fun AppNavigation() {


    val navController =
        rememberNavController()



    NavHost(

        navController = navController,

        startDestination =
            Screen.Home.route

    ) {



        composable(
            route = Screen.Home.route
        ) {


            HomeRoute()


        }


    }


}
