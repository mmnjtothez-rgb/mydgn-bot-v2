package com.mydgnbot.ui.components.player

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mydgnbot.domain.CountdownState
import com.mydgnbot.ui.theme.AppSpacing


@Composable
fun CountdownBar(
    countdown: CountdownState,
    modifier: Modifier = Modifier
) {

    val progress =
        animateFloatAsState(
            targetValue = countdown.progress,
            animationSpec =
                tween(
                    durationMillis = 500
                ),
            label = "countdown_progress"
        )


    Column(
        modifier = modifier.fillMaxWidth(),

        verticalArrangement =
            Arrangement.spacedBy(
                AppSpacing.Small
            )

    ) {


        Row(
            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.SpaceBetween

        ) {


            Text(
                text = "MyDGN Purchase Time",

                style =
                    MaterialTheme.typography.labelMedium
            )


            Text(
                text =
                    countdown.formattedTime,

                style =
                    MaterialTheme.typography.labelMedium
            )

        }



        LinearProgressIndicator(
            progress = {
                progress.value
            },

            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(8.dp),

            trackColor =
                MaterialTheme.colorScheme.surfaceVariant
        )



    }

}
