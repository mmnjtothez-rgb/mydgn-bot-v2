package com.mydgnbot.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun PriceBox(

    title: String,

    price: String

) {


    Card(

        modifier = Modifier
            .width(140.dp),

    ) {


        Column(

            modifier = Modifier.padding(12.dp),

            horizontalAlignment = Alignment.CenterHorizontally

        ) {


            Text(

                text = title,

                style = MaterialTheme.typography.labelMedium

            )



            Spacer(
                modifier = Modifier.height(8.dp)
            )



            Text(

                text = price,

                style = MaterialTheme.typography.titleLarge

            )


        }


    }


}
