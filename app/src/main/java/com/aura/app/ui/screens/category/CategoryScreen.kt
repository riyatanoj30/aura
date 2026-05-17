package com.aura.app.ui.screens.category

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.aura.app.data.repository.ProductRepository
import com.aura.app.ui.components.Eyebrow
import com.aura.app.ui.components.ProductCard
import com.aura.app.ui.theme.AuraColors
import com.aura.app.ui.theme.AuraSpacing

@Composable
fun CategoryScreen(
    categoryId: String,
    onBack: () -> Unit,
    onOpenProduct: (String) -> Unit,
    onOpenCart: () -> Unit
) {
    val category = ProductRepository.categories().firstOrNull { it.id == categoryId }
        ?: ProductRepository.categories().first()
    val products = ProductRepository.byCategory(categoryId)

    Box(Modifier.fillMaxSize().background(AuraColors.Ink)) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(
                start = 12.dp, end = 12.dp,
                top = 0.dp, bottom = 80.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            // ────────── Editorial hero (full row) ──────────
            item(span = { GridItemSpan(2) }) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(420.dp)
                        .background(AuraColors.Smoke)
                ) {
                    AsyncImage(
                        model = category.coverImage,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    Box(
                        Modifier.fillMaxSize().background(
                            Brush.verticalGradient(
                                0f to AuraColors.Ink.copy(alpha = 0.55f),
                                0.4f to AuraColors.Ink.copy(alpha = 0.15f),
                                1f to AuraColors.Ink.copy(alpha = 0.85f)
                            )
                        )
                    )
                    // Top toolbar
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = AuraSpacing.edge, vertical = AuraSpacing.md),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Outlined.ArrowBack,
                            "Back",
                            tint = AuraColors.Ivory,
                            modifier = Modifier.size(22.dp).clickable(onClick = onBack)
                        )
                        Spacer(Modifier.weight(1f))
                        Icon(
                            Icons.Outlined.Search, "Search",
                            tint = AuraColors.Ivory,
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(Modifier.width(18.dp))
                        Icon(
                            Icons.Outlined.ShoppingBag, "Bag",
                            tint = AuraColors.Ivory,
                            modifier = Modifier.size(22.dp).clickable(onClick = onOpenCart)
                        )
                    }
                    // Centre title
                    Column(
                        Modifier.align(Alignment.BottomStart).padding(28.dp)
                    ) {
                        Eyebrow(category.accent.uppercase())
                        Spacer(Modifier.height(10.dp))
                        Text(
                            text = category.name,
                            style = MaterialTheme.typography.displayMedium,
                            color = AuraColors.Ivory
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = "${category.pieceCount} pieces  ·  ${category.tagline}",
                            style = MaterialTheme.typography.labelSmall,
                            color = AuraColors.Ivory.copy(alpha = 0.7f)
                        )
                    }
                }
            }

            // ────────── Filter / Sort bar ──────────
            item(span = { GridItemSpan(2) }) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${products.size} PIECES",
                        style = MaterialTheme.typography.labelSmall,
                        color = AuraColors.Ivory.copy(alpha = 0.6f)
                    )
                    Spacer(Modifier.weight(1f))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Outlined.Tune, "Filter",
                            tint = AuraColors.Champagne,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            "REFINE",
                            style = MaterialTheme.typography.labelSmall,
                            color = AuraColors.Champagne
                        )
                    }
                }
            }

            // ────────── Product grid ──────────
            items(products, key = { it.id }) { p ->
                ProductCard(product = p, onClick = { onOpenProduct(p.id) })
            }
        }
    }
}
