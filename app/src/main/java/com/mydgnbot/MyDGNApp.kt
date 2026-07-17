package com.mydgnbot

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.mydgnbot.navigation.AppNavigation
import com.mydgnbot.ui.main.MainScaffold
import com.mydgnbot.ui.theme.MyDGNTheme


@Composable
fun MyDGNApp() {

    MyDGNTheme {


        val navController =
            rememberNavController()


        MainScaffold(

            navController = navController

        ) {


            AppNavigation(

                navController = navController

            )

        }

    }

}
