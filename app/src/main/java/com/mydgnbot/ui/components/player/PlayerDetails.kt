package com.mydgnbot.ui.components.player

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mydgnbot.data.model.Player
import com.mydgnbot.ui.components.common.LabelValueRow
import com.mydgnbot.ui.theme.AppSpacing
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope


@Composable
fun PlayerDetails(
    player: Player,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxWidth(),

        verticalArrangement =
            Arrangement.spacedBy(
                AppSpacing.Small
            )

    ) {


        HorizontalDivider()


        LabelValueRow(
            label = "🧬 Chemistry Style",
            value = player.chemistryStyle
        )


        LabelValueRow(
            label = "👥 Owners",
            value = player.owners.toString()
        )


        LabelValueRow(
            label = "⏱ Market Time",
            value = player.marketTime
        )


        LabelValueRow(
            label = "🆔 Transaction",
            value = player.transactionId
        )


    }

}
