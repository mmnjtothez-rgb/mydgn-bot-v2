package com.mydgnbot.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp


@Composable
fun WaitingIndicator() {

    val infiniteTransition =
        rememberInfiniteTransition()


    val scale by infiniteTransition.animateFloat(

        initialValue = 1f,

        targetValue = 1.15f,

        animationSpec = infiniteRepeatable(

            animation =
            tween(1000),

            repeatMode =
            RepeatMode.Reverse

        )

    )


    Icon(

        imageVector = Icons.Default.Search,

        contentDescription = "Searching",

        modifier = Modifier
            .size(64.dp)
            .scale(scale)

    )

}
