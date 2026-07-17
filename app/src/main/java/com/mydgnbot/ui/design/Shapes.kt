package com.mydgnbot.ui.design

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val MyDGNShapes = Shapes(

    small = RoundedCornerShape(12.dp),

    medium = RoundedCornerShape(
        Dimens.SmallCardRadius
    ),

    large = RoundedCornerShape(
        Dimens.CardCornerRadius
    )

)
