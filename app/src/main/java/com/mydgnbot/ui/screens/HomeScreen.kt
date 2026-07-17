package com.mydgnbot.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mydgnbot.ui.components.ControlButtons
import com.mydgnbot.ui.components.LiveStatusChip
import com.mydgnbot.ui.components.WalletChip

@Composable
fun HomeScreen() {

    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    androidx.compose.foundation.layout.Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "MyDGN Bot",
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.padding(horizontal = 6.dp))

                        LiveStatusChip()

                    }

                },

                navigationIcon = {

                    IconButton(
                        onClick = {}
                    ) {

                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu"
                        )

                    }

                }

            )

        }

    ) { padding ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp),

            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Spacer(modifier = Modifier.height(20.dp))

            ControlButtons()

            Spacer(modifier = Modifier.height(20.dp))

            WalletChip()

            Spacer(modifier = Modifier.height(48.dp))

            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                modifier = Modifier.height(72.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Waiting for player...",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "The bot is monitoring MyDGN.\nA player will appear here instantly.",
                style = MaterialTheme.typography.bodyMedium
            )

        }

    }

}
