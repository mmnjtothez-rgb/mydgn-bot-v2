package com.mydgnbot.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun HomeScreen(

    viewModel: Any? = null

) {


    Column(

        modifier = Modifier

            .fillMaxSize()

            .padding(16.dp)

    ) {


        Text(

            text = "MyDGN Bot",

            style = MaterialTheme.typography.headlineMedium

        )



        Spacer(

            modifier = Modifier.height(16.dp)

        )



        Text(

            text = "Waiting for player data..."

        )


    }


}
