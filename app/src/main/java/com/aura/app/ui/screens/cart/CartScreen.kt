package com.aura.app.ui.screens.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.aura.app.data.model.CartItem
import com.aura.app.data.repository.CartRepository
import com.aura.app.ui.components.AuraButton
import com.aura.app.ui.components.AuraButtonVariant
import com.aura.app.ui.components.Eyebrow
import com.aura.app.ui.components.Hairline
import com.aura.app.ui.theme.AuraColors
import com.aura.app.ui.theme.AuraSpacing
import com.aura.app.ui.theme.AuraStroke

@Composable
fun CartScreen(
    onBack: () -> Unit,
    onCheckout: () -> Unit,
    onContinue: () -> Unit
) {
    val bagItems by CartRepository.items.collectAsState()
    val subtotalCents = bagItems.sumOf { it.lineTotalCents }
    val subtotal = "$ %,d".format(subtotalCents / 100)

    Box(Modifier.fillMaxSize().background(AuraColors.Ink)) {
        /* ────────────── Header ────────────── */
        Column(Modifier.fillMaxSize()) {
            CartHeader(onBack = onBack)

            if (bagItems.isEmpty()) {
                CartEmpty(onContinue = onContinue)
            } else {
                LazyColumn(
                    Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(bottom = 160.dp)
                ) {
                    items(bagItems, key = { "${it.product.id}-${it.size}" }) { line ->
                        CartLine(item = line)
                    }
                }
            }
        }

        /* ────────────── Sticky footer: subtotal + checkout ────────────── */
        if (bagItems.isNotEmpty()) {
            Column(
                Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .background(AuraColors.Ink)
            ) {
                Hairline(color = AuraColors.HairLight)
                Column(Modifier.padding(horizontal = AuraSpacing.edge, vertical = 18.dp)) {
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Column {
                            Text(
                                text = "SUBTOTAL",
                                style = MaterialTheme.typography.labelSmall,
                                color = AuraColors.Ivory.copy(alpha = 0.55f)
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(
                                text = subtotal,
                                style = MaterialTheme.typography.headlineMedium,
                                color = AuraColors.Champagne
                            )
                        }
                        Text(
                            text = "TAX & SHIPPING\nAT CHECKOUT",
                            style = MaterialTheme.typography.labelSmall,
                            color = AuraColors.Ivory.copy(alpha = 0.45f)
                        )
                    }
                    Spacer(Modifier.height(16.dp))
                    AuraButton(
                        label = "Proceed to Checkout",
                        onClick = onCheckout,
                        variant = AuraButtonVariant.Primary,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
private fun CartHeader(onBack: () -> Unit) {
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
            Spacer(Modifier.weight(1f))
        }
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = AuraSpacing.edge, vertical = 24.dp)
        ) {
            Eyebrow("YOUR SHOPPING BAG")
            Spacer(Modifier.height(14.dp))
            Text(
                text = "The Bag",
                style = MaterialTheme.typography.displayMedium,
                color = AuraColors.Ivory
            )
        }
        Hairline(color = AuraColors.HairLight)
    }
}

@Composable
private fun CartLine(item: CartItem) {
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = AuraSpacing.edge, vertical = 20.dp)
        ) {
            // Image
            Box(
                Modifier
                    .size(width = 110.dp, height = 140.dp)
                    .background(AuraColors.Smoke)
            ) {
                AsyncImage(
                    model = item.product.images.firstOrNull(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(Modifier.width(16.dp))
            // Info
            Column(Modifier.weight(1f)) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(Modifier.weight(1f)) {
                        Text(
                            text = item.product.name,
                            style = MaterialTheme.typography.titleLarge,
                            color = AuraColors.Ivory
                        )
                        Spacer(Modifier.height(2.dp))
                        Text(
                            text = item.product.subcategory.uppercase(),
                            style = MaterialTheme.typography.labelSmall,
                            color = AuraColors.Ivory.copy(alpha = 0.5f)
                        )
                    }
                    Icon(
                        Icons.Outlined.Close, "Remove",
                        tint = AuraColors.Ivory.copy(alpha = 0.55f),
                        modifier = Modifier
                            .size(16.dp)
                            .clickable {
                                CartRepository.remove(item.product.id, item.size)
                            }
                    )
                }
                Spacer(Modifier.height(14.dp))
                Text(
                    text = "SIZE  ·  ${item.size}",
                    style = MaterialTheme.typography.labelSmall,
                    color = AuraColors.Bone.copy(alpha = 0.7f)
                )
                Spacer(Modifier.height(18.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Quantity stepper
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.border(AuraStroke.hair, AuraColors.HairLight)
                    ) {
                        QtyBtn("−") {
                            CartRepository.updateQuantity(
                                item.product.id, item.size, item.quantity - 1
                            )
                        }
                        Text(
                            text = item.quantity.toString(),
                            style = MaterialTheme.typography.titleMedium,
                            color = AuraColors.Ivory,
                            modifier = Modifier.width(40.dp).padding(vertical = 10.dp),
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                        QtyBtn("+") {
                            CartRepository.updateQuantity(
                                item.product.id, item.size, item.quantity + 1
                            )
                        }
                    }
                    Text(
                        text = item.product.priceFormatted,
                        style = MaterialTheme.typography.titleLarge,
                        color = AuraColors.Champagne
                    )
                }
            }
        }
        Hairline(color = AuraColors.HairLight)
    }
}

@Composable
private fun QtyBtn(label: String, onClick: () -> Unit) {
    Box(
        Modifier
            .size(40.dp)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium,
            color = AuraColors.Ivory
        )
    }
}

@Composable
private fun CartEmpty(onContinue: () -> Unit) {
    Column(
        Modifier.fillMaxSize().padding(AuraSpacing.edge),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Eyebrow("YOUR BAG IS EMPTY")
        Spacer(Modifier.height(20.dp))
        Text(
            text = "Nothing here, yet.",
            style = MaterialTheme.typography.displaySmall.copy(fontStyle = FontStyle.Italic),
            color = AuraColors.Ivory
        )
        Spacer(Modifier.height(40.dp))
        AuraButton(
            label = "Discover the Collection",
            onClick = onContinue,
            variant = AuraButtonVariant.Primary
        )
    }
}
