package com.mydgnbot.ui.components.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import com.mydgnbot.ui.theme.AppElevation
import com.mydgnbot.ui.theme.AppShapes
import com.mydgnbot.ui.theme.AppSpacing

@Composable
fun SectionCard(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(AppSpacing.Large),
    content: @Composable () -> Unit
) {

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = AppShapes.Large,
        elevation = CardDefaults.cardElevation(
            defaultElevation = AppElevation.Low
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {

        Box(
            modifier = Modifier.padding(contentPadding)
        ) {
            content()
        }

    }

}
