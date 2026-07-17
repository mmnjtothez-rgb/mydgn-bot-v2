package com.mydgnbot.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mydgnbot.data.model.Player


@Composable
fun PlayerCard(

    player: Player,

    onBought: () -> Unit

) {


    Card(

        modifier = Modifier
            .fillMaxWidth(),

        shape = MaterialTheme.shapes.large

    ) {


        Column(

            modifier = Modifier
                .padding(16.dp)

        ) {


            Row {


                Box(

                    modifier = Modifier
                        .size(
                            width = 90.dp,
                            height = 110.dp
                        )

                ) {

                    Text(
                        "FC\nCARD"
                    )

                }



                Spacer(
                    modifier = Modifier.width(16.dp)
                )



                Column {


                    Text(
                        player.name,
                        style =
                        MaterialTheme.typography.titleLarge
                    )


                    Text(
                        "${player.rating} • ${player.position}"
                    )


                }


                Spacer(
                    modifier = Modifier.weight(1f)
                )


                Text(
                    "⏳ ${player.marketTime}"
                )

            }



            Spacer(
                modifier = Modifier.height(20.dp)
            )



            Row(

                horizontalArrangement =
                Arrangement.spacedBy(12.dp)

            ) {


                PriceBox(
                    "Starting Bid",
                    player.startingBid
                )


                PriceBox(
                    "Buy Now",
                    player.buyNow
                )


            }



            Spacer(
                modifier = Modifier.height(16.dp)
            )



            InfoRow(
                "🧬 Chemistry",
                player.chemistryStyle
            )


            InfoRow(
                "👥 Owners",
                player.owners.toString()
            )


            InfoRow(
                "⏱ Market Time",
                player.marketTime
            )


            InfoRow(
                "Account",
                player.account
            )


            InfoRow(
                "Payment",
                player.payment
            )


            InfoRow(
                "Transaction ID",
                player.transactionId
            )


            InfoRow(
                "MyDGN Price",
                player.myDgnPrice
            )


            Spacer(
                modifier = Modifier.height(16.dp)
            )


            BoughtButton(
                onClick = onBought
            )


        }

    }

}
