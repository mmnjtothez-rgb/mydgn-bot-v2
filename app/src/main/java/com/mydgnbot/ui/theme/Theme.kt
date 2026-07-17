package com.mydgnbot.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = Primary,
    primaryContainer = PrimaryContainer,

    secondary = Secondary,

    background = Background,
    surface = Surface,

    onPrimary = OnPrimary,
    onBackground = OnBackground,
    onSurface = OnSurface
)

private val DarkColors = darkColorScheme(
    primary = DarkPrimary,
    primaryContainer = DarkPrimaryContainer,

    background = DarkBackground,
    surface = DarkSurface,

    onBackground = OnDarkBackground,
    onSurface = OnDarkSurface
)

@Composable
fun MyDGNTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = Typography,
        content = content
    )

}
