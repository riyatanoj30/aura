package com.aura.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.aura.app.data.model.Category
import com.aura.app.ui.theme.AuraColors

@Composable
fun CategoryCard(
    category: Category,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    aspect: Float = 4f / 5f
) {
    Box(
        modifier
            .fillMaxWidth()
            .aspectRatio(aspect)
            .background(AuraColors.Smoke)
            .clickable(onClick = onClick)
    ) {
        AsyncImage(
            model = category.coverImage,
            contentDescription = category.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        // Editorial dark gradient overlay
        Box(
            Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        0f to AuraColors.Ink.copy(alpha = 0.15f),
                        0.55f to AuraColors.Ink.copy(alpha = 0.25f),
                        1f to AuraColors.Ink.copy(alpha = 0.85f)
                    )
                )
        )
        Column(
            Modifier
                .align(Alignment.BottomStart)
                .padding(24.dp)
        ) {
            Text(
                text = category.accent.uppercase(),
                style = MaterialTheme.typography.labelMedium,
                color = AuraColors.Champagne
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = category.name,
                style = MaterialTheme.typography.displaySmall,
                color = AuraColors.Ivory
            )
            Spacer(Modifier.height(6.dp))
            Text(
                text = "${category.pieceCount} pieces  ·  ${category.tagline}",
                style = MaterialTheme.typography.labelSmall,
                color = AuraColors.Ivory.copy(alpha = 0.65f)
            )
        }
    }
}
