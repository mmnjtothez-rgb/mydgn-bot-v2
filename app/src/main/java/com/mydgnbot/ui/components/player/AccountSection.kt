package com.mydgnbot.ui.components.player

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mydgnbot.data.model.Player
import com.mydgnbot.ui.components.common.LabelValueRow


@Composable
fun AccountSection(
    player: Player,
    modifier: Modifier = Modifier
) {


    Column(
        modifier = modifier.fillMaxWidth()
    ) {


        HorizontalDivider()


        LabelValueRow(
            label = "📧 Account",
            value = player.account
        )

    }

}
