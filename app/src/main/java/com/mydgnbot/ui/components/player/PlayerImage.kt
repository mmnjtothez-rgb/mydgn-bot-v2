package com.mydgnbot.ui.components.player


import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp



@Composable
fun PlayerImage(

    imageUrl: String?

) {


    Card(

        modifier = Modifier

            .size(
                width = 90.dp,
                height = 110.dp
            )

            .clip(
                RoundedCornerShape(12.dp)
            )

    ) {


        Text(

            text = "Player",

            modifier = Modifier

        )


    }


}
