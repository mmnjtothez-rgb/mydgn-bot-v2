package com.mydgnbot.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mydgnbot.ui.design.Dimens
import androidx.compose.ui.unit.dp


@Composable
fun MyDGNButton(
    text: String,
    onClick: () -> Unit,
) {

    Button(

        onClick = onClick,

        modifier = Modifier
            .height(Dimens.ButtonHeight),

        shape = RoundedCornerShape(
            Dimens.ButtonCornerRadius
        ),

        colors = ButtonDefaults.buttonColors()

    ) {

        Text(text)

    }

}
