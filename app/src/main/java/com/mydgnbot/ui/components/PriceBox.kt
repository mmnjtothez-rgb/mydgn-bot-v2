package com.mydgnbot.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun PriceBox(

    title: String,

    price: String

) {

    Card {

        Column {

            Text(price)

            Text(title)

        }

    }

}
