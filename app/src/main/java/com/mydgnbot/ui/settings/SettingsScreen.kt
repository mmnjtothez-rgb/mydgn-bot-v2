package com.mydgnbot.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.mydgnbot.data.model.UserSettings


@Composable
fun SettingsScreen(
    settings: UserSettings,
    onApiUserChange: (String) -> Unit,
    onSecretKeyChange: (String) -> Unit,
    onPlatformChange: (String) -> Unit,
    onPlayerTypeChange: (Int) -> Unit,
    onMinPriceChange: (Int) -> Unit,
    onMaxPriceChange: (Int) -> Unit,
    onPollingChange: (Long) -> Unit,
    onSave: () -> Unit
) {


    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {


        Text(
            text = "Settings",
            style = MaterialTheme.typography.headlineMedium
        )


        OutlinedTextField(

            value = settings.apiUser,

            onValueChange = onApiUserChange,

            label = {
                Text("API Username")
            },

            modifier = Modifier.fillMaxWidth()

        )


        OutlinedTextField(

            value = settings.secretKey,

            onValueChange = onSecretKeyChange,

            label = {
                Text("Secret Key")
            },

            visualTransformation =
                PasswordVisualTransformation(),

            modifier = Modifier.fillMaxWidth()

        )


        OutlinedTextField(

            value = settings.platform,

            onValueChange = onPlatformChange,

            label = {
                Text("Platform")
            },

            modifier = Modifier.fillMaxWidth()

        )


        OutlinedTextField(

            value = settings.playerType.toString(),

            onValueChange = {

                it.toIntOrNull()
                    ?.let(onPlayerTypeChange)

            },

            label = {
                Text("Player Type")
            },

            modifier = Modifier.fillMaxWidth()

        )


        OutlinedTextField(

            value = settings.minBuyPrice.toString(),

            onValueChange = {

                it.toIntOrNull()
                    ?.let(onMinPriceChange)

            },

            label = {
                Text("Minimum Buy Price")
            },

            modifier = Modifier.fillMaxWidth()

        )


        OutlinedTextField(

            value = settings.maxBuyPrice.toString(),

            onValueChange = {

                it.toIntOrNull()
                    ?.let(onMaxPriceChange)

            },

            label = {
                Text("Maximum Buy Price")
            },

            modifier = Modifier.fillMaxWidth()

        )


        OutlinedTextField(

            value = (settings.pollingInterval / 1000)
                .toString(),

            onValueChange = {

                it.toLongOrNull()
                    ?.let { seconds ->

                        onPollingChange(
                            seconds * 1000
                        )

                    }

            },

            label = {
                Text("Polling Interval (seconds)")
            },

            modifier = Modifier.fillMaxWidth()

        )


        Button(

            onClick = onSave,

            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)

        ) {

            Text(
                "Save Settings"
            )

        }

    }

}
