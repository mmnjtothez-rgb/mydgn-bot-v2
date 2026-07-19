package com.mydgnbot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mydgnbot.ui.navigation.AppNavigation
import com.mydgnbot.ui.theme.MyDGNTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyDGNTheme {
                AppNavigation()
            }
        }
    }
}
