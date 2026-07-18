package com.mydgnbot.ui.components.player

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mydgnbot.data.model.Player
import com.mydgnbot.ui.components.common.InfoChip
import com.mydgnbot.ui.theme.AppSpacing


@Composable
fun PlayerHeader(
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


        Row(
            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.SpaceBetween,

            verticalAlignment =
                Alignment.Top

        ) {


            PlayerImage(
                imageUrl = player.imageUrl
            )


            FutbinBadge(
                price = player.cardValueOrNull()
            )


        }



        Text(
            text = player.name,

            style =
                MaterialTheme.typography.titleLarge

        )



        Row(
            horizontalArrangement =
                Arrangement.spacedBy(8.dp)

        ) {


            InfoChip(
                text = "⭐ ${player.rating}"
            )


            InfoChip(
                text = player.position
            )


        }




        Row(
            horizontalArrangement =
                Arrangement.spacedBy(8.dp)

        ) {


            InfoChip(
                text =
                    player.nationalityFlag
                    ?: player.nationality
            )


            InfoChip(
                text =
                    player.club
            )


        }




        if(
            player.cardTitle.isNotBlank()
        ){

            InfoChip(
                text =
                    player.cardTitle
            )

        }



        if(
            player.cardRarity.isNotBlank()
        ){

            InfoChip(
                text =
                    player.cardRarity
            )

        }


    }

}
