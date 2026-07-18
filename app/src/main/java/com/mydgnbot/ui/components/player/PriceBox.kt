package com.mydgnbot.ui.components.player


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

import androidx.compose.material3.Card
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun PriceBox(

    title: String,

    value: String,

    modifier: Modifier = Modifier

) {


    Card(

        modifier = modifier.width(140.dp)

    ) {


        Column(

            modifier = Modifier.padding(12.dp)

        ) {


            Text(title)


            Text(value)


        }

    }

}
