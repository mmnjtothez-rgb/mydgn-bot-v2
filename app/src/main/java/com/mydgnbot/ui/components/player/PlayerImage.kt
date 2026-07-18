package com.mydgnbot.ui.components.player


import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun PlayerImage(

    imageUrl: String?,

    modifier: Modifier = Modifier

) {


    Card(

        modifier = modifier.size(

            width = 90.dp,

            height = 110.dp

        )

    ) {


        Text(
            text = "Player"
        )


    }


}
