package com.aura.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.aura.app.data.model.Product
import com.aura.app.data.repository.WishlistRepository
import com.aura.app.ui.theme.AuraColors
import com.aura.app.ui.theme.AuraSpacing
import com.aura.app.ui.theme.AuraStroke

@Composable
fun ProductCard(
    product: Product,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val wishlisted by WishlistRepository.ids.collectAsState()
    val isWishlisted = product.id in wishlisted

    Column(
        modifier
            .background(AuraColors.Smoke)
            .clickable(onClick = onClick)
    ) {
        // Image
        Box(
            Modifier
                .fillMaxWidth()
                .aspectRatio(3f / 4f)
        ) {
            AsyncImage(
                model = product.images.firstOrNull(),
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            // Top-left tag (new / limited)
            val tag = when {
                product.isLimited -> "LIMITED"
                product.isNew     -> "NEW"
                else              -> null
            }
            if (tag != null) {
                Box(
                    Modifier
                        .padding(AuraSpacing.sm)
                        .align(Alignment.TopStart)
                        .background(AuraColors.Ink.copy(alpha = 0.55f))
                        .border(AuraStroke.hair, AuraColors.Champagne.copy(alpha = 0.4f))
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                ) {
                    Text(
                        text = tag,
                        style = MaterialTheme.typography.labelSmall,
                        color = AuraColors.Champagne
                    )
                }
            }
            // Top-right wishlist
            Box(
                Modifier
                    .padding(AuraSpacing.sm)
                    .align(Alignment.TopEnd)
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(AuraColors.Ink.copy(alpha = 0.55f))
                    .clickable { WishlistRepository.toggle(product.id) },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = if (isWishlisted) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "Save to wishlist",
                    tint = if (isWishlisted) AuraColors.Champagne else AuraColors.Ivory,
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        // Info row
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = AuraSpacing.md, vertical = AuraSpacing.md),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Column(Modifier.weight(1f)) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.titleLarge,
                    color = AuraColors.Ivory
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = product.subcategory.uppercase(),
                    style = MaterialTheme.typography.labelSmall,
                    color = AuraColors.Ivory.copy(alpha = 0.5f)
                )
            }
            Spacer(Modifier.width(12.dp))
            Text(
                text = product.priceFormatted,
                style = MaterialTheme.typography.titleLarge,
                color = AuraColors.Champagne
            )
        }
    }
}
