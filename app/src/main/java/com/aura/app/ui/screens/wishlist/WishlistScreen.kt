package com.aura.app.ui.screens.wishlist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aura.app.data.repository.WishlistRepository
import com.aura.app.ui.components.Eyebrow
import com.aura.app.ui.components.Hairline
import com.aura.app.ui.components.ProductCard
import com.aura.app.ui.theme.AuraColors
import com.aura.app.ui.theme.AuraSpacing

@Composable
fun WishlistScreen(
    onBack: () -> Unit,
    onOpenProduct: (String) -> Unit
) {
    val ids by WishlistRepository.ids.collectAsState()
    val products = remember(ids) { WishlistRepository.products() }

    Box(Modifier.fillMaxSize().background(AuraColors.Ink)) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 12.dp, end = 12.dp, bottom = 80.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            item(span = { GridItemSpan(2) }) {
                Column(Modifier.background(AuraColors.Ink)) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = AuraSpacing.edge, vertical = AuraSpacing.md),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Outlined.ArrowBack, "Back",
                            tint = AuraColors.Ivory,
                            modifier = Modifier.size(22.dp).clickable(onClick = onBack)
                        )
                    }
                    Column(Modifier.padding(horizontal = AuraSpacing.edge, vertical = 24.dp)) {
                        Eyebrow("YOUR SAVED PIECES")
                        Spacer(Modifier.height(14.dp))
                        Text(
                            text = "Wishlist",
                            style = MaterialTheme.typography.displayMedium,
                            color = AuraColors.Ivory
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = "${products.size} pieces  ·  set aside for consideration",
                            style = MaterialTheme.typography.bodyMedium,
                            color = AuraColors.Ivory.copy(alpha = 0.55f)
                        )
                    }
                    Hairline(color = AuraColors.HairLight)
                    Spacer(Modifier.height(16.dp))
                }
            }

            if (products.isEmpty()) {
                item(span = { GridItemSpan(2) }) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = AuraSpacing.edge, vertical = 80.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Nothing saved, yet.",
                            style = MaterialTheme.typography.headlineMedium,
                            color = AuraColors.Bone
                        )
                        Spacer(Modifier.height(12.dp))
                        Text(
                            text = "Tap the heart on a piece you'd like to consider.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = AuraColors.Ivory.copy(alpha = 0.5f)
                        )
                    }
                }
            } else {
                items(products, key = { it.id }) { p ->
                    ProductCard(product = p, onClick = { onOpenProduct(p.id) })
                }
            }
        }
    }
}
