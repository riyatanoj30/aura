@file:OptIn(ExperimentalFoundationApi::class)

package com.aura.app.ui.screens.product

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.aura.app.data.repository.CartRepository
import com.aura.app.data.repository.ProductRepository
import com.aura.app.data.repository.WishlistRepository
import com.aura.app.ui.components.AuraButton
import com.aura.app.ui.components.AuraButtonVariant
import com.aura.app.ui.components.Eyebrow
import com.aura.app.ui.components.Hairline
import com.aura.app.ui.components.OrnamentalRule
import com.aura.app.ui.components.ProductCard
import com.aura.app.ui.theme.AuraColors
import com.aura.app.ui.theme.AuraSpacing
import com.aura.app.ui.theme.AuraStroke

@Composable
fun ProductDetailScreen(
    productId: String,
    onBack: () -> Unit,
    onOpenProduct: (String) -> Unit,
    onOpenCart: () -> Unit
) {
    val product = ProductRepository.byId(productId) ?: return
    val wishlisted by WishlistRepository.ids.collectAsState()
    val isWishlisted = product.id in wishlisted

    var selectedSize by remember { mutableStateOf(product.sizes.first()) }
    val pagerState = rememberPagerState(pageCount = { product.images.size })
    val scroll = rememberScrollState()

    Box(Modifier.fillMaxSize().background(AuraColors.Ink)) {
        Column(Modifier.fillMaxSize().verticalScroll(scroll)) {

            /* ───────────── Image carousel ───────────── */
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(560.dp)
                    .background(AuraColors.Smoke)
            ) {
                HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize()) { page ->
                    AsyncImage(
                        model = product.images.getOrNull(page),
                        contentDescription = product.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                // Soft gradient at top + bottom for legibility
                Box(
                    Modifier.fillMaxSize().background(
                        Brush.verticalGradient(
                            0f to AuraColors.Ink.copy(alpha = 0.45f),
                            0.25f to AuraColors.Ink.copy(alpha = 0.05f),
                            1f to AuraColors.Ink.copy(alpha = 0.35f)
                        )
                    )
                )
                // Top bar
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
                    Spacer(Modifier.weight(1f))
                    Icon(
                        Icons.Outlined.Share, "Share",
                        tint = AuraColors.Ivory,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(Modifier.width(20.dp))
                    Icon(
                        Icons.Outlined.ShoppingBag, "Bag",
                        tint = AuraColors.Ivory,
                        modifier = Modifier.size(22.dp).clickable(onClick = onOpenCart)
                    )
                }
                // Pager indicator hairlines
                Row(
                    Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 24.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    product.images.forEachIndexed { i, _ ->
                        Box(
                            Modifier
                                .width(if (i == pagerState.currentPage) 28.dp else 14.dp)
                                .height(1.dp)
                                .background(
                                    if (i == pagerState.currentPage)
                                        AuraColors.Champagne
                                    else
                                        AuraColors.Ivory.copy(alpha = 0.4f)
                                )
                        )
                    }
                }
            }

            /* ───────────── Heading: name, subcategory, price ───────────── */
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = AuraSpacing.edge, vertical = 32.dp)
            ) {
                Eyebrow(product.subcategory.uppercase())
                Spacer(Modifier.height(14.dp))
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.headlineLarge,
                    color = AuraColors.Ivory
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    text = product.priceFormatted,
                    style = MaterialTheme.typography.headlineSmall,
                    color = AuraColors.Champagne
                )
            }

            Hairline(color = AuraColors.HairLight)

            /* ───────────── Description ───────────── */
            Column(Modifier.padding(horizontal = AuraSpacing.edge, vertical = 32.dp)) {
                Eyebrow("THE PIECE")
                Spacer(Modifier.height(16.dp))
                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodyLarge,
                    color = AuraColors.Bone
                )
            }

            Hairline(color = AuraColors.HairLight)

            /* ───────────── Atelier details ───────────── */
            Column(Modifier.padding(horizontal = AuraSpacing.edge, vertical = 32.dp)) {
                Eyebrow("ATELIER")
                Spacer(Modifier.height(20.dp))
                DetailLine("Fabric", product.fabric)
                DetailLine("Origin", product.origin)
                DetailLine("Stock", "${product.inStock} available", isLast = true)
            }

            Hairline(color = AuraColors.HairLight)

            /* ───────────── Size selector ───────────── */
            Column(Modifier.padding(horizontal = AuraSpacing.edge, vertical = 32.dp)) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Eyebrow("SELECT  ·  SIZE")
                    Text(
                        text = "SIZE GUIDE",
                        style = MaterialTheme.typography.labelSmall,
                        color = AuraColors.Champagne
                    )
                }
                Spacer(Modifier.height(20.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(product.sizes) { size ->
                        val selected = size == selectedSize
                        Box(
                            Modifier
                                .defaultMinSize(minWidth = 56.dp, minHeight = 56.dp)
                                .background(if (selected) AuraColors.Champagne else AuraColors.Smoke)
                                .border(
                                    AuraStroke.hair,
                                    if (selected) AuraColors.Champagne else AuraColors.HairLight
                                )
                                .clickable { selectedSize = size }
                                .padding(horizontal = 16.dp, vertical = 18.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = size,
                                style = MaterialTheme.typography.labelLarge,
                                color = if (selected) AuraColors.Ink else AuraColors.Ivory
                            )
                        }
                    }
                }
            }

            Hairline(color = AuraColors.HairLight)

            /* ───────────── Delivery / Services ───────────── */
            Column(Modifier.padding(horizontal = AuraSpacing.edge, vertical = 32.dp)) {
                ServiceRow(
                    iconText = "✦",
                    title = "Complimentary delivery",
                    subtitle = product.deliveryEstimate.uppercase()
                )
                Spacer(Modifier.height(20.dp))
                ServiceRow(
                    iconText = "✕",
                    title = "Returns within 30 days",
                    subtitle = "WHITE-GLOVE COLLECTION"
                )
                Spacer(Modifier.height(20.dp))
                ServiceRow(
                    iconText = "○",
                    title = "Lifetime restoration",
                    subtitle = "EVERY PIECE. FOR ALWAYS."
                )
            }

            Hairline(color = AuraColors.HairLight)

            /* ───────────── Recommendations ───────────── */
            val recs = remember(productId) { ProductRepository.recommendationsFor(productId) }
            Column(
                Modifier.padding(top = 32.dp, bottom = 100.dp)
            ) {
                Column(
                    Modifier.padding(horizontal = AuraSpacing.edge),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Eyebrow("THE HOUSE PROPOSES")
                    Spacer(Modifier.height(16.dp))
                    Text(
                        text = "You may also consider",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontStyle = FontStyle.Italic
                        ),
                        color = AuraColors.Ivory
                    )
                    Spacer(Modifier.height(12.dp))
                    OrnamentalRule(width = 38, color = AuraColors.Champagne)
                }
                Spacer(Modifier.height(28.dp))
                LazyRow(
                    contentPadding = PaddingValues(horizontal = AuraSpacing.edge),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(recs, key = { it.id }) { p ->
                        Box(Modifier.width(240.dp)) {
                            ProductCard(product = p, onClick = { onOpenProduct(p.id) })
                        }
                    }
                }
            }
        }

        /* ───────────── Sticky bottom bar: Wishlist + Add to Bag ───────────── */
        Column(
            Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(AuraColors.Ink)
        ) {
            Hairline(color = AuraColors.HairLight)
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = AuraSpacing.edge, vertical = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    Modifier
                        .size(58.dp)
                        .border(AuraStroke.rule, AuraColors.HairLight)
                        .clickable { WishlistRepository.toggle(product.id) },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = if (isWishlisted) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                        contentDescription = "Wishlist",
                        tint = if (isWishlisted) AuraColors.Champagne else AuraColors.Ivory,
                        modifier = Modifier.size(20.dp)
                    )
                }
                AuraButton(
                    label = "Add to Bag",
                    onClick = {
                        CartRepository.add(product, selectedSize)
                        onOpenCart()
                    },
                    variant = AuraButtonVariant.Primary,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun DetailLine(label: String, value: String, isLast: Boolean = false) {
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = label.uppercase(),
                style = MaterialTheme.typography.labelSmall,
                color = AuraColors.Ivory.copy(alpha = 0.5f)
            )
            Text(
                text = value,
                style = MaterialTheme.typography.titleLarge,
                color = AuraColors.Bone
            )
        }
        if (!isLast) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(AuraColors.HairLight)
            )
        }
    }
}

@Composable
private fun ServiceRow(iconText: String, title: String, subtitle: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            Modifier
                .size(40.dp)
                .border(AuraStroke.hair, AuraColors.Champagne.copy(alpha = 0.4f)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = iconText,
                style = MaterialTheme.typography.titleLarge,
                color = AuraColors.Champagne
            )
        }
        Spacer(Modifier.width(16.dp))
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = AuraColors.Ivory
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.labelSmall,
                color = AuraColors.Ivory.copy(alpha = 0.5f)
            )
        }
    }
}
