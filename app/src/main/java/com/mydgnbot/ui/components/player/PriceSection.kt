package com.mydgnbot.ui.components.player

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mydgnbot.data.model.Player
import com.mydgnbot.ui.components.common.LabelValueRow
import com.mydgnbot.ui.theme.AppSpacing


@Composable
fun PriceSection(
    player: Player,
    modifier: Modifier = Modifier
) {


    Column(
        modifier = modifier.fillMaxWidth(),

        verticalArrangement =
            Arrangement.spacedBy(
                AppSpacing.Medium
            )

    ) {


        Row(
            modifier =
                Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.spacedBy(12.dp)

        ) {


            PriceBox(
                title = "Starting Bid",
                value =
                    player.startingBid
                        .formatCoins(),

                modifier =
                    Modifier.weight(1f)
            )


            PriceBox(
                title = "Buy Now",
                value =
                    player.buyNow
                        .formatCoins(),

                modifier =
                    Modifier.weight(1f)
            )


        }



        HorizontalDivider()



        LabelValueRow(
            label = "MyDGN Price",
            value = player.myDgnPrice
        )


        LabelValueRow(
            label = "Payment",
            value = player.payment
        )


    }

}
