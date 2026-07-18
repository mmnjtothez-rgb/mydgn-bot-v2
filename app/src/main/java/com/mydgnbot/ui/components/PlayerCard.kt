package com.mydgnbot.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mydgnbot.data.model.Player
import com.mydgnbot.ui.design.Dimens


@Composable
fun PlayerCard(

    player: Player,

    onCancel: () -> Unit,

    onBought: () -> Unit

) {


    Card(

        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),

        shape = RoundedCornerShape(
            Dimens.CardCornerRadius
        )

    ) {


        Column(

            modifier = Modifier
                .padding(16.dp)

        ) {


            // Top section

            Row(

                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement =
                Arrangement.SpaceBetween,

                verticalAlignment =
                Alignment.CenterVertically

            ) {


                Box(

                    modifier = Modifier
                        .width(90.dp)
                        .height(110.dp)

                ) {

                    // FC card image goes here

                    Text(
                        text = "FC\nCARD",
                        modifier = Modifier
                            .align(Alignment.Center)
                    )

                }



                Column(

                    modifier = Modifier.weight(1f)
                        .padding(start = 16.dp)

                ) {


                    Text(

                        text = player.name,

                        style =
                        MaterialTheme.typography.titleLarge

                    )


                    Text(

                        text =
                        "${player.rating} ${player.position}",

                        style =
                        MaterialTheme.typography.bodyLarge

                    )


                }



                Text(

                    text = "⏳ ${player.marketTime}",

                    style =
                    MaterialTheme.typography.labelLarge

                )


            }



            Spacer(
                modifier = Modifier.height(20.dp)
            )



            // Prices

            Row(

                horizontalArrangement =
                Arrangement.spacedBy(12.dp),

                modifier = Modifier.fillMaxWidth()

            ) {


                PriceBox(

                    title = "Starting Bid",

                    price =
                    player.startingBid.toString(),

                    modifier =
                    Modifier.weight(1f)

                )


                PriceBox(

                    title = "Buy Now",

                    price =
                    player.buyNow.toString(),

                    modifier =
                    Modifier.weight(1f)

                )


            }



            Spacer(
                modifier = Modifier.height(16.dp)
            )



            InfoRow(
                title = "🧬 Chemistry",
                value = player.chemistryStyle
            )


            InfoRow(
                title = "👥 Owners",
                value = player.owners.toString()
            )


            InfoRow(
                title = "⏱ Market Time",
                value = player.marketTime
            )



            HorizontalDivider(
                modifier =
                Modifier.padding(vertical = 12.dp)
            )



            InfoRow(
                title = "👤 Account",
                value = player.account
            )


            InfoRow(
                title = "💳 Payment",
                value = player.payment
            )


            InfoRow(
                title = "🆔 Transaction ID",
                value = player.transactionId
            )


            InfoRow(
                title = "💰 MyDGN Price",
                value = player.myDgnPrice
            )



            Spacer(
                modifier = Modifier.height(20.dp)
            )



            // Actions

            Row(

                horizontalArrangement =
                Arrangement.spacedBy(12.dp),

                modifier =
                Modifier.fillMaxWidth()

            ) {


                OutlinedButton(

                    onClick = onCancel,

                    modifier =
                    Modifier.weight(1f)

                ) {

                    Icon(
                        Icons.Default.Close,
                        null
                    )

                    Spacer(
                        Modifier.width(6.dp)
                    )

                    Text("Cancel")

                }



                Button(

                    onClick = onBought,

                    modifier =
                    Modifier.weight(1f)

                ) {


                    Icon(
                        Icons.Default.Check,
                        null
                    )


                    Spacer(
                        Modifier.width(6.dp)
                    )


                    Text("Bought")

                }


            }


        }

    }

}
