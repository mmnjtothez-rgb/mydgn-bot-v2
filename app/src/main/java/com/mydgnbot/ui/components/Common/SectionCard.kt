package com.mydgnbot.ui.components.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.*
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SectionCard(

    modifier: Modifier = Modifier,

    content: @Composable () -> Unit

) {


    ElevatedCard(

        modifier = modifier

    ) {


        androidx.compose.foundation.layout.Column(

            modifier =
                Modifier.padding(
                    16.dp
                )

        ) {

            content()

        }

    }

}
