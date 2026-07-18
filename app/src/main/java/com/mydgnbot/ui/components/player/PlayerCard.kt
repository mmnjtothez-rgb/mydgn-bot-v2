package com.mydgnbot.ui.components.player

import androidx.compose.foundation.layout.*
import com.mydgnbot.ui.components.player.PriceBox
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mydgnbot.data.model.Player
import com.mydgnbot.domain.CountdownState
import com.mydgnbot.ui.components.common.SectionCard
import com.mydgnbot.ui.theme.AppSpacing


@Composable
fun PlayerCard(
    player: Player,
    countdown: CountdownState,
    onBought: () -> Unit,
    onCancel: () -> Unit,
    modifier: Modifier = Modifier
) {


    SectionCard(
        modifier = modifier
    ) {


        Column(
            verticalArrangement =
                Arrangement.spacedBy(
                    AppSpacing.Medium
                )
        ) {


            PlayerHeader(
                player = player
            )


            CountdownBar(
                countdown = countdown
            )


            PriceSection(
                player = player
            )


            PlayerDetails(
                player = player
            )


            AccountSection(
                player = player
            )


            ActionButtons(
                onBought = onBought,
                onCancel = onCancel
            )


        }


    }


}
