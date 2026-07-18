package com.mydgnbot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import com.mydgnbot.ui.navigation.AppNavigation
import com.mydgnbot.ui.theme.MyDGNBotTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(
            savedInstanceState
        )


        enableEdgeToEdge()


        setContent {


            MyDGNBotTheme {


                AppNavigation()


            }

        }

    }

}
