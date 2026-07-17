package com.mydgnbot

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.mydgnbot.navigation.AppNavigation
import com.mydgnbot.ui.theme.MyDGNTheme

@Composable
fun MyDGNApp() {

    MyDGNTheme {

        Surface {

            AppNavigation()

        }

    }

}
