package com.mydgnbot.ui.components.common

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun LabelValueRow(

    label: String,

    value: String,

    modifier: Modifier = Modifier

) {


    Row(

        modifier =
            modifier.fillMaxWidth(),

        horizontalArrangement =
            Arrangement.SpaceBetween

    ) {


        Text(

            text = label,

            style =
                MaterialTheme.typography.bodyMedium

        )


        Text(

            text = value,

            style =
                MaterialTheme.typography.bodyMedium

        )


    }

}
